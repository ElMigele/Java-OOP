package Task_6.Automat.General;

import java.util.ArrayList;

import Task_6.Automat.Container.Container;
import Task_6.Product.Product;

public abstract class Model<C extends Container<P>, P extends Product> {
    public ArrayList<C> Containers(){
        return containers;
    }
    protected ArrayList<C> containers;
    
    protected class InWorkProduct {
        private P product;
        public P Product(){
            return product;
        }

        protected ArrayList<C> containers;
        public ArrayList<C> Containers(){
            return containers;
        }
    
        public int TotalVolume(){
            int res = 0;
            for (C c : containers) {
                res += c.CurrentVolume();
            }
            return res;
        }

        public InWorkProduct(P p) {
            product = p;
            containers = new ArrayList<>();
        }
    }
    protected ArrayList<InWorkProduct> products;

    protected int getFreeSpaceForProduct(P p){
        int res = 0;
        for (int i = 0; i < containers.size(); i++) {
            if (containers.get(i).IsEmpty()
            || containers.get(i).Product().equals(p)){
                res += containers.get(i).FreeSpace();
            }
        }
        return res;
    }
    protected InWorkProduct getInWorkProduct(P p){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).Product() == p){
                return products.get(i);
            }
        }
        return null;
    }

    protected int getProductVolume(P p) {
        int res = 0;        
        InWorkProduct iwp = getInWorkProduct(p);
        for (int i = 0; i < iwp.containers.size(); i++) {
            res += iwp.containers.get(i).CurrentVolume();
        }
        return res;
    }

    protected C getProductContainerLesser(P p){
        C c = null;
        InWorkProduct iwp = getInWorkProduct(p);
        if (iwp.containers.size() == 1) {
            c = iwp.containers.get(0);
        } else {
            c = iwp.containers.get(0);
            for (int i = 1; i < iwp.containers.size(); i++) {
                if (c.CurrentVolume() > iwp.containers.get(i).CurrentVolume()) {
                    c = iwp.containers.get(i);
                }
            }
        }
        return c;
    }

    protected C getEmptyContainer(){
        for (int i = 0; i < containers.size(); i++) {
            if (containers.get(i).IsEmpty()){
                return containers.get(i);
            }
        }
        return null;
    }

    public Model(){
        containers = new ArrayList<>();
        products = new ArrayList<>();
    }

    protected boolean hasProduct(P p){
        for (C c : containers) {
            if (c.Product() == (p)){
                return true;
            }
        }
        return false;
    }

    protected boolean LoadCheck(P p, int volume){
        if (volume <= 0){
            return false;
        }
        if (getFreeSpaceForProduct(p) < volume){
            return false;
        }
        return true;
    }
    public boolean Load(P p, int volume){
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
            C c = getEmptyContainer(); 
            iwp.Containers().add(c);
            if (c.Load(p, volume)){
                return true;
            } else {
                int temp = c.FreeSpace();
                c.Load(p, temp);
                volume -= temp;
            }
        }
        return true;
    }

    protected boolean UnloadCheck(P p, int volume){
        if (volume <= 0){
            //System.out.println("error: volume <= 0!");
            return false;
        }
        if (getInWorkProduct(p) == null) {
            //System.out.println("error: vending machine hasn't this type of product!");
            return false;
        }
        if (getProductVolume(p) < volume) {
            //System.out.println("error: vending machine hasn't enougth volume of requested product!");
            return false;
        }
        return true;
    }
    public boolean Unload(P p, int volume){
        if (!UnloadCheck(p, volume)){
            return false;
        }
        InWorkProduct iwp = getInWorkProduct(p);
        
        while (volume != 0) {
            C c = getProductContainerLesser(p);
            if (c.Unload(volume)) {
                if (c.IsEmpty()) {
                    iwp.Containers().remove(c);
                    if (iwp.Containers().size() == 0){
                        products.remove(iwp);
                    }
                }
                return true;
            } else {
                int temp = c.CurrentVolume();
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

    // rewrite
    public String GetStatusPerContainers(){
        String res ="Vending machine status per containers:";
        for (int i = 0; i < containers.size(); i++) {
            res += "\n#" + i + ": " + containers.get(i).GetStatus();
        }
        return res;
    }

    // rewrite
    public String GetStatusPerProducts(){
        String res = "Vending machine status per products:";
        if (products.size() == 0){
            res += "\nVending Machine hasn't products";
        }
        for (int i = 0; i < products.size(); i++) {
            res += "\n- " + products.get(i).product.Name() + ": " + products.get(i).TotalVolume();
        }
        return res;
    }
}