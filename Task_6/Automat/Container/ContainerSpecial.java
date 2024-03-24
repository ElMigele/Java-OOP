package Task_6.Automat.Container;

import Task_6.Product.Product;

public class ContainerSpecial extends Container<Product>{
    public Product product;

    public ContainerSpecial(Product product){
        super();
        this.product = product;
    }

    public ContainerSpecial(int volume, Product product){
        super(volume);
        this.product = product;
    }


    public boolean LoadCheck(int volume){
        return maxVolume - currentVolume < volume;
    }
    public boolean Load(int volume) {
        if (!LoadCheck(volume)){
            return false;
        }        
        currentVolume += volume;
        return true;
    }

    public boolean UnloadCheck(int volume){
        return currentVolume > volume;
    }
    @Override
    public boolean Unload(int volume) {
        if (!UnloadCheck(volume)){
            return false;
        }        
        currentVolume -= volume;
        return true;
    }
}