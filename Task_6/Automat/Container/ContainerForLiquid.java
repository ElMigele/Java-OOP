package Task_6.Automat.Container;

import Task_6.Product.ProductLiquid;

public class ContainerForLiquid extends Container<ProductLiquid>{
    public ContainerForLiquid(){
        maxVolume = 10;
    }

    public ContainerForLiquid(int maxVolume){
        this.maxVolume = maxVolume;
    }
}