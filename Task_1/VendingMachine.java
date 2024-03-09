package Task_1;

import java.util.ArrayList;

public class VendingMachine<T> {
    protected ArrayList<Container<T>> containers;

    protected class InWorkProduct {
        private T product;
        public T Product(){
            return product;
        }

        private ArrayList<Container<T>> containers;
        public ArrayList<Container<T>> Containers(){
            return containers;
        }
    
        public InWorkProduct(T p) {
            product = p;
            containers = new ArrayList<>();
        }
    }
    protected ArrayList<InWorkProduct> products;
    public float GetFreeSpaceForProduct(T p) {
        float res = 0;
        for (int i = 0; i < containers.size(); i++) {
            if (containers.get(i).IsEmpty()
            || containers.get(i).Product().equals(p)){
                res += containers.get(i).FreeSpace();
            }
        }
        return res;
    }
    public float GetProductVolume(T p) {
        float res = 0;        
        InWorkProduct iwp = getInWorkProduct(p);
        for (int i = 0; i < iwp.containers.size(); i++) {
            res += iwp.containers.get(i).CurrentVolume();
        }
        return res;
    }

    public VendingMachine(){
        products = new ArrayList<>();
        containers = new ArrayList<Container<T>>();
        for (int i = 0; i < 2; i++) {
            containers.add(new Container<T>(30));
        }
    }

    public VendingMachine(int containersCount){
        products = new ArrayList<>();
        containers = new ArrayList<Container<T>>();
        for (int i = 0; i < containersCount; i++) {
            containers.add(new Container<T>(30));
        }
    }

    public VendingMachine(int containersCount, float containersMaxVolume){
        products = new ArrayList<>();
        containers = new ArrayList<Container<T>>();
        for (int i = 0; i < containersCount; i++) {
            containers.add(new Container<T>(containersMaxVolume));
        }
    }

    public boolean hasProduct(T p){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).Product().equals(p)){
                return true;
            }
        }
        return false;
    }

    public int getProductID(T p){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).Product().equals(p)){
                return i;
            }
        }
        return -1;
    }

    protected InWorkProduct getInWorkProduct(T p){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).Product().equals(p)){
                return products.get(i);
            }
        }
        return null;
    }

    public Container<T> GetEmptyContainer(){
        for (int i = 0; i < containers.size(); i++) {
            if (containers.get(i).IsEmpty()){
                return containers.get(i);
            }
        }
        return null;
    }

    public Container<T> GetProductContainerLesser(T p){
        Container<T> c = null;
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

    public boolean LoadProduct(T p, float volume){
        // System.out.println("Load " + p.Name() + ", Volume: " + volume);
        if (volume <= 0){
            System.out.println("error: volume <= 0!");
            return false;
        }
        if (GetFreeSpaceForProduct(p) < volume){
            System.out.println("error: not enougth space for load!");
            return false;
        }

        InWorkProduct iwp = getInWorkProduct(p);
        if (iwp != null) {
            if (iwp.Product().equals(p)){
                for (int i = 0; i < iwp.containers.size(); i++) {
                    if (volume == 0){
                        return true;
                    }
                    if (iwp.containers.get(i).IsFull()){
                        continue;
                    } else {
                        if (iwp.containers.get(i).Load(p, volume)){
                            return true;
                        } else {
                            float temp = volume - iwp.containers.get(i).FreeSpace();
                            iwp.containers.get(i).Load(p, temp);
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
            Container<T> c = GetEmptyContainer(); 
            iwp.containers.add(c);
            if (c.Load(p, volume)){
                return true;
            } else {
                float temp = c.FreeSpace();
                c.Load(p, temp);
                volume -= temp;
            }
        }
        return true;
    }

    public boolean UnloadProduct(T p, int volume){
        //System.out.println("Unload " + p.Name() + ", Volume: " + volume);
        if (volume <= 0){
            System.out.println("error: volume <= 0!");
            return false;
        }
        InWorkProduct iwp = getInWorkProduct(p);
        if (iwp == null) {
            System.out.println("error: vending machine hasn't this type of product!");
            return false;
        }
        if (GetProductVolume(p) < volume) {
            System.out.println("error: vending machine hasn't enougth volume of requested product!");
            return false;
        }
        
        while (volume != 0) {
            Container<T> c = GetProductContainerLesser(p);
            if (c.Unload(volume)) {
                if (c.IsEmpty()) {
                    iwp.containers.remove(c);
                    if (iwp.containers.size() == 0){
                        products.remove(iwp);
                    }
                }
                return true;
            } else {
                float temp = c.CurrentVolume();
                c.Unload(temp);
                iwp.containers.remove(c);
                if (iwp.containers.size() == 0){
                    products.remove(iwp);
                }
                volume -= temp;
            }
        }

        return true;
    }

    // rewrite
    public void GetStatusPerContainers(){
        System.out.println("Vending machine status per containers:");
        for (int i = 0; i < containers.size(); i++) {
            System.out.println("#" + i + ": " + containers.get(i).GetStatus());
        }
        System.out.println("");
    }

    // rewrite
    public void GetStatusPerProducts(){
        System.out.println("Vending machine status per products:");
        if (products.size() == 0){
            System.out.println("Vending Machine hasn't products");
        } else {
            for (int i = 0; i < products.size(); i++) {
                //System.out.println("- " + products.get(i).product.Name() + ": " + GetProductVolume(products.get(i).product));
            }   
        }
        System.out.println("");
    }
}