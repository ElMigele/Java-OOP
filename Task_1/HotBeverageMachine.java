package Task_1;

public class HotBeverageMachine extends VendingMachine<HotBeverage> {
    @Override
    public boolean LoadProduct(HotBeverage p, float volume){
        System.out.println("Load " + p.Name() + " ("+p.Temperature()+"°), Volume: " + volume);
        return super.LoadProduct(p, volume);
    }
    @Override
    public boolean UnloadProduct(HotBeverage p, int volume){
        System.out.println("Unload " + p.Name() + "(" + p.Temperature() + "°), Volume: " + volume);
        return super.UnloadProduct(p, volume);
    }
    
    @Override
    public void GetStatusPerProducts() {
        System.out.println("Vending machine status per products:");
        if (products.size() == 0){
            System.out.println("Vending Machine hasn't products");
        } else {
            for (int i = 0; i < products.size(); i++) {
                System.out.println("- " + products.get(i).Product().Name() + " ("+products.get(i).Product().Temperature()+"°): " + GetProductVolume(products.get(i).Product()));
            }   
        }
        System.out.println("");
    }

    @Override
    public void GetStatusPerContainers(){
        System.out.println("Vending machine status per containers:");
        for (int i = 0; i < containers.size(); i++) {
            Container<HotBeverage> c =  containers.get(i);           
            String stat = c.Product() != null
                ? c.Product().Name() + " (" + c.Product().Temperature() + "°), " + c.CurrentVolume() + " / " + c.MaxVolume()
                : "Empty, " + c.CurrentVolume() + " / " + c.MaxVolume(); 
            System.out.println("#" + i + ": " + stat);
        }
        System.out.println("");
    }
}