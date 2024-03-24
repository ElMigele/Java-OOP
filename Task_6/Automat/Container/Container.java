package Task_6.Automat.Container;

import Task_6.Product.Product;

public abstract class Container<P extends Product> {
    public int MaxVolume(){
        return maxVolume;
    }
    protected int maxVolume;

    public int CurrentVolume(){
        return currentVolume;
    }
    protected int currentVolume;
    public int FreeSpace(){
        return maxVolume - currentVolume;
    }

    public P Product(){
        return product;
    }
    protected P product;

    public boolean IsFull(){
        return currentVolume == maxVolume;
    }
    public boolean IsEmpty(){
        return currentVolume == 0;
    }

    public Container(){
        maxVolume = 20;
    }
    
    public Container(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    public boolean Load(P product, int volume) {
        if (maxVolume - currentVolume < volume)
            return false;
        if (this.product != product
            && this.product != null)
            return false;
        currentVolume += volume;
        this.product = product;
        return true;
    }

    public boolean Unload(int volume) {
        if (currentVolume < volume)
            return false;
        currentVolume -= volume;
        if (currentVolume == 0)
            product = null;
        return true;
    }

    public String GetStatus(){
        return product != null
            ? "Product: " + product.Name() + ". V: " + currentVolume + " / " + maxVolume
            : "Container is empty";
    }
}