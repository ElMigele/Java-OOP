package Task_6.Product;

public class ProductReady extends ProductLiquid {
    public Receipt Receipt(){
        return receipt;
    }
    private Receipt receipt;

    public ProductReady(String name, Receipt receipt) {
        super(name);
        this.receipt = receipt;
    }
}