package Task_6.Automat.BeverageMachine;

import java.util.ArrayList;

import Task_6.Automat.Container.ContainerForLiquid;
import Task_6.Automat.General.Present;
import Task_6.Product.ProductLiquid;

public class PresentBeverageMachine extends Present<ContainerForLiquid, ProductLiquid, ModelBeverageMachine, ViewBeverageMachine>{
    ArrayList<ProductLiquid> products;
    public PresentBeverageMachine(ArrayList<ProductLiquid> products){
        this.products = products;
        m = new ModelBeverageMachine();
        for (ProductLiquid productLiquid : products) {
            m.Load(productLiquid, 10);
        }

        v = new ViewBeverageMachine();
    }

    @Override
    public void Run() {
        while (loop) {
            switch(v.GetCommandID()){
                case 0:
                    v.Print(m.GetStatusPerProducts());
                    break;
                case 1:
                    v.Print(m.Unload(products.get(0), 2)
                        ? "Cola (0.2) is ready"
                        : "Can't get Cola (0.2)");
                    break;
                case 2:
                    v.Print(m.Unload(products.get(0), 5)
                        ? "Cola (0.5) is ready"
                        : "Can't get Cola (0.5)");
                    break;
                case 3:
                    v.Print(m.Unload(products.get(0), 8)
                        ? "Cola (0.8) is ready"
                        : "Can't get Cola (0.8)");
                    break;
                case 4:
                    v.Print(m.Unload(products.get(1), 4)
                        ? "Rocket Juice (0.4) is ready"
                        : "Can't get Rocket Juice (0.4)");
                    break;
                case 5:
                    v.Print(m.Unload(products.get(1), 8)
                        ? "Rocket Juice (0.8) is ready"
                        : "Can't get Rocket Juice (0.8)");
                    break;
                case 6:
                    loop = false;
                    break;
            }
        }
    }
}