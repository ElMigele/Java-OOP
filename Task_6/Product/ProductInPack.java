package Task_6.Product;

public class ProductInPack extends ProductSolid {
    public int PackSize(){
        return packSize;
    }
    private int packSize;
    
    public ProductInPack(String name, int packSize) {
        super(name);
        this.packSize = packSize;
    }    
}