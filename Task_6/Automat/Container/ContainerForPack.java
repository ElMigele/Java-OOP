package Task_6.Automat.Container;

import Task_6.Product.ProductInPack;

public class ContainerForPack extends Container<ProductInPack> {
    @Override
    public boolean IsFull(){
        return product == null
            ? false
            : Math.floorDiv(currentVolume, product.PackSize())  == Math.floorDiv(maxVolume, product.PackSize());
    }

    @Override
    public int FreeSpace(){
        return product == null
        ? maxVolume - currentVolume
        : Math.floorDiv(maxVolume - currentVolume, product.PackSize());
    }

    @Override
    public boolean Load(ProductInPack product, int volume) {
        volume = volume * product.PackSize();
        if (maxVolume - currentVolume < volume)
            return false;
        if (this.product != product
            && this.product != null)
            return false;
        currentVolume += volume;
        this.product = product;
        return true;
    }

    @Override
    public boolean Unload(int volume) {
        volume = volume * product.PackSize();
        if (currentVolume < volume)
            return false;
        currentVolume -= volume;
        if (currentVolume == 0)
            product = null;
        return true;
    }

}