package Task_6.Product;

public abstract class Product {
    public String Name(){
        return name;
    }
    protected String name;

    public Product(String name) {
        this.name = name;
    }
}