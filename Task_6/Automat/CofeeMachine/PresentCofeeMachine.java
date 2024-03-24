package Task_6.Automat.CofeeMachine;

import java.util.ArrayList;

import Task_6.Automat.Container.ContainerSpecial;
import Task_6.Automat.General.Present;
import Task_6.Product.Product;
import Task_6.Product.ProductReady;

public class PresentCofeeMachine extends Present<ContainerSpecial, Product, ModelCofeeMachine, ViewCofeeMachine>{
    ArrayList<ProductReady> receipts;
    public PresentCofeeMachine(ArrayList<ProductReady> readies, ArrayList<Product> products){
        this.receipts = readies;
        m = new ModelCofeeMachine(readies, products);
        m.Load(products.get(0), 10);
        m.Load(products.get(1), 10);
        m.Load(products.get(2), 10);

        v = new ViewCofeeMachine();
    }
    
    @Override
    public void Run() {
        while (loop) {
            switch (v.GetCommandID()) {
                case 0:
                    v.Print(m.GetStatusPerProducts());
                    break;
                case 1:
                    v.Print(m.PrepareProduct(receipts.get(0))
                        ? receipts.get(0).Name() +" is ready"
                        : "Can't prepare " + receipts.get(0).Name());
                    break;
                case 2:
                    v.Print(m.PrepareProduct(receipts.get(1))
                        ? receipts.get(1).Name() +" is ready"
                        : "Can't prepare " + receipts.get(1).Name());
                    break;
                case 3:
                    v.Print(m.PrepareProduct(receipts.get(2))
                        ? receipts.get(2).Name() +" is ready"
                        : "Can't prepare " + receipts.get(2).Name());
                    break;
                case 4:
                    v.Print(m.PrepareProduct(receipts.get(3))
                        ? receipts.get(3).Name() +" is ready"
                        : "Can't prepare " + receipts.get(3).Name());
                    break;
                case 5:
                    v.Print(m.PrepareProduct(receipts.get(4))
                        ? receipts.get(4).Name() +" is ready"
                        : "Can't prepare " + receipts.get(4).Name());
                    break;
                case 6:
                    loop = false;
                    break;
            }
        }
    }
}