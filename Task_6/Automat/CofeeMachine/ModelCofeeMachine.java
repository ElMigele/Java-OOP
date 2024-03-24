package Task_6.Automat.CofeeMachine;

import java.util.ArrayList;

import Task_6.Automat.Container.ContainerSpecial;
import Task_6.Automat.General.Model;
import Task_6.Product.Product;
import Task_6.Product.ProductReady;
import Task_6.Product.ProductRequired;

public class ModelCofeeMachine extends Model<ContainerSpecial, Product>{
    private ArrayList<ProductReady> receipts;
    public ArrayList<ProductReady> Receipts(){
        return receipts;
    }

    public ModelCofeeMachine(ArrayList<ProductReady> receipts, ArrayList<Product> p){
        this.receipts = receipts;

        containers.add(new ContainerSpecial(10, p.get(0)));
        containers.add(new ContainerSpecial(10, p.get(1)));
        containers.add(new ContainerSpecial(10, p.get(2)));
    }
    
    public boolean PrepareProduct(ProductReady receipt){
        if (!PrepareCheck(receipt)){
            return false;
        }
        for (ProductRequired r : receipt.Receipt().RequiredProducts()) {
            Unload(r.Product(), r.Value());
        }
        return true;
    }

    private boolean PrepareCheck(ProductReady receipt) {
        for (ProductRequired r : receipt.Receipt().RequiredProducts()) {
            if (getProductVolume(r.Product()) < r.Value()){
                return false;
            }
        }
        return true;
    }
}