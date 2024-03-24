package Task_6.Product;

import java.util.ArrayList;

public class Receipt {
    private ArrayList<ProductRequired> requireds;
    public ArrayList<ProductRequired> RequiredProducts(){
        return requireds;
    } 

    public Receipt(ArrayList<ProductRequired> requireds) {
        this.requireds = requireds;
    }
}