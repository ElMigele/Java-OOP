package Task_6.Automat.BeverageMachine;

import java.util.ArrayList;

import Task_6.Automat.Container.ContainerForLiquid;
import Task_6.Automat.General.Model;
import Task_6.Product.ProductLiquid;

public class ModelBeverageMachine extends Model<ContainerForLiquid, ProductLiquid>{
    public ModelBeverageMachine(){
        containers = new ArrayList<>();
        containers.add(new ContainerForLiquid(20));
        containers.add(new ContainerForLiquid(20));
        containers.add(new ContainerForLiquid(20));
    }
}