package Task_6.Product;

public class ProductRequired {
    private Product product;
    public Product Product(){
        return product;
    }

    private int value;
    public int Value(){
        return value;
    }

    public ProductRequired(Product product, int value) {
        this.product = product;
        this.value = value;
    }
}