package Task_6.Automat.VendingMachine;

import java.util.ArrayList;

import Task_6.Automat.Container.ContainerForPack;
import Task_6.Product.ProductInPack;

public class ModelVendingMachine extends Task_6.Automat.General.Model<ContainerForPack, ProductInPack> {
    public ModelVendingMachine(){
        containers = new ArrayList<>();
        containers.add(new ContainerForPack());
        containers.add(new ContainerForPack());
        containers.add(new ContainerForPack());
    }

    @Override
    protected int getProductVolume(ProductInPack p){
        int res = 0;        
        InWorkProduct iwp = getInWorkProduct(p);
        for (int i = 0; i < iwp.Containers().size(); i++) {
            res += iwp.Containers().get(i).CurrentVolume();
        }
        return res;
    }

    @Override
    protected int getFreeSpaceForProduct(ProductInPack p) {
        int res = 0;
        for (int i = 0; i < containers.size(); i++) {
            if (containers.get(i).IsEmpty()
            || containers.get(i).Product().equals(p)){
                res += Math.floorDiv(containers.get(i).FreeSpace(), p.PackSize());
            }
        }
        return res;
    }

    @Override
    public boolean Load(ProductInPack p, int volume) {
        if (!LoadCheck(p, volume)){
            return false;
        }

        InWorkProduct iwp = getInWorkProduct(p);
        if (iwp != null) {
            if (iwp.Product().equals(p)){
                for (int i = 0; i < iwp.Containers().size(); i++) {
                    if (volume == 0){
                        return true;
                    }
                    if (iwp.Containers().get(i).IsFull()){
                        continue;
                    } else {
                        if (iwp.Containers().get(i).Load(p, volume)){
                            return true;
                        } else {
                            int temp = volume - iwp.Containers().get(i).FreeSpace();
                            iwp.Containers().get(i).Load(p, temp);
                            volume -= temp;
                        }
                    }
                }
            }
        }
        if (!hasProduct(p)) {
            products.add(new InWorkProduct(p));
            iwp = getInWorkProduct(p);
        }

        while (volume != 0){
            ContainerForPack c = getEmptyContainer(); 
            iwp.Containers().add(c);
            if (c.Load(p, volume)){
                return true;
            } else {
                int temp = Math.floorDiv(c.FreeSpace(), p.PackSize());
                c.Load(p, temp);
                volume -= temp;
            }
        }
        return true;
    }

    @Override
    public boolean Unload(ProductInPack p, int volume) {
        if (!UnloadCheck(p, volume)){
            return false;
        }
        InWorkProduct iwp = getInWorkProduct(p);
        
        while (volume != 0) {
            ContainerForPack c = getProductContainerLesser(p);
            if (c.Unload(volume)) {
                if (c.IsEmpty()) {
                    iwp.Containers().remove(c);
                    if (iwp.Containers().size() == 0){
                        products.remove(iwp);
                    }
                }
                return true;
            } else {
                int temp = c.CurrentVolume() / p.PackSize();
                c.Unload(temp);
                iwp.Containers().remove(c);
                if (iwp.Containers().size() == 0){
                    products.remove(iwp);
                }
                volume -= temp;
            }
        }
        return true;
    }
}