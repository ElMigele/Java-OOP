package Task_6;

import java.util.ArrayList;

import Task_6.Automat.BeverageMachine.PresentBeverageMachine;
import Task_6.Automat.CofeeMachine.PresentCofeeMachine;
import Task_6.Automat.VendingMachine.PresentVendingMachine;
import Task_6.Product.*;

public class Main {
    public static void main(String[] args) {
        //TestBeverageMachine();
        //TestCofeeMachine();
        TestVendingMachine();
    }

    private static void TestVendingMachine() {
        ProductInPack p1 = new ProductInPack("Cola (0.5)", 5);
        ProductInPack p2 = new ProductInPack("Sprite (0.5)", 5);
        ProductInPack p3 = new ProductInPack("Sandwich", 2);

        ArrayList<ProductInPack> packs = new ArrayList<>();
        packs.add(p1);
        packs.add(p2);
        packs.add(p3);

        PresentVendingMachine p = new PresentVendingMachine(packs);
        p.Run();
    }

    static void TestBeverageMachine(){
        // 0: Cola
        // 1: Rocket Juice
        // 3: Pepsi
        ProductLiquid cola = new ProductLiquid("Cola");
        ProductLiquid roju = new ProductLiquid("Rocket Juice");
        ProductLiquid Pepsi = new ProductLiquid("Pepsi");
        ArrayList<ProductLiquid> liquids = new ArrayList<>();
        liquids.add(cola);
        liquids.add(roju);
        liquids.add(Pepsi);

        PresentBeverageMachine p = new PresentBeverageMachine(liquids);
        p.Run();
    }

    static void TestCofeeMachine(){

        ProductLiquid water = new ProductLiquid("Water");
        ProductSolid cofe = new ProductSolid("Cofe");
        ProductLiquid milk = new ProductLiquid("Milk");

        ArrayList<Product> products = new ArrayList<>(){};
        products.add(water);
        products.add(cofe);
        products.add(milk);

        ArrayList<ProductRequired> r1 = new ArrayList<>();
        r1.add(new ProductRequired(water, 3));
        r1.add(new ProductRequired(cofe, 1));

        ArrayList<ProductRequired> r2 = new ArrayList<>();
        r2.add(new ProductRequired(water, 4));
        r2.add(new ProductRequired(cofe, 1));

        ArrayList<ProductRequired> r3 = new ArrayList<>();
        r3.add(new ProductRequired(water, 5));
        r3.add(new ProductRequired(cofe, 1));

        ArrayList<ProductRequired> r4 = new ArrayList<>();
        r4.add(new ProductRequired(water, 2));
        r4.add(new ProductRequired(cofe, 1));
        r4.add(new ProductRequired(milk, 1));
        
        ArrayList<ProductRequired> r5 = new ArrayList<>();
        r5.add(new ProductRequired(water, 3));
        r5.add(new ProductRequired(cofe, 1));
        r5.add(new ProductRequired(milk, 1));

        ProductReady p1 = new ProductReady("Americano (0.3)", new Receipt(r1));
        ProductReady p2 = new ProductReady("Americano (0.4)", new Receipt(r2));
        ProductReady p3 = new ProductReady("Americano (0.5)", new Receipt(r3));
        ProductReady p4 = new ProductReady("Expresso (0.2)", new Receipt(r2));
        ProductReady p5 = new ProductReady("Expresso (0.3)", new Receipt(r3));

        ArrayList<ProductReady> readies =new ArrayList<>();
        readies.add(p1);
        readies.add(p2);
        readies.add(p3);
        readies.add(p4);
        readies.add(p5);
                
        PresentCofeeMachine p = new PresentCofeeMachine(readies, products);
        p.Run();
    }
}