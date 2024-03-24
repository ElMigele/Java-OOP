package Task_6.Automat.VendingMachine;

import java.util.ArrayList;

import Task_6.Automat.Container.ContainerForPack;
import Task_6.Automat.General.Present;
import Task_6.Product.ProductInPack;

public class PresentVendingMachine extends Present<ContainerForPack, ProductInPack, ModelVendingMachine, ViewVendingMachine>{
    ArrayList<ProductInPack> products;
    public PresentVendingMachine(ArrayList<ProductInPack> packs){
        m = new ModelVendingMachine();
        m.Load(packs.get(0) , 2);
        m.Load(packs.get(1) , 2);
        m.Load(packs.get(2) , 2);

        products = packs;
        v = new ViewVendingMachine();
    }

    @Override
    public void Run() {
        while (loop) {
            switch (v.GetCommandID()) {
                case 0:
                    v.Print(m.GetStatusPerContainers());
                    break;
                case 1:
                    v.Print(m.Unload(products.get(0), 1)
                        ? products.get(0).Name() +" is given"
                        : "Can't get " + products.get(0).Name());
                    break;
                case 2:
                    v.Print(m.Unload(products.get(1), 1)
                        ? products.get(1).Name() + " is given"
                        : "Can't get " + products.get(1).Name());
                    break;
                case 3:
                    loop = false;
                    break;
            }
        }
    }
    
}