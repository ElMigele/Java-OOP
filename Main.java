public class Main {
    public static void main(String[] args) {
        HotBeverage hgt = new HotBeverage("Hot Green Tea",  80);
        HotBeverage hbt = new HotBeverage("Hot Black Tea",  100);
        HotBeverage hc = new HotBeverage("Hot Coffee",  100);
    
        HotBeverageMachine bm = new HotBeverageMachine();

        bm.GetStatusPerContainers();
        bm.LoadProduct(hgt, 40);
        bm.GetStatusPerContainers();

        bm.UnloadProduct(hc, 40);

        bm.UnloadProduct(hgt, 20);
        bm.GetStatusPerContainers();
        bm.GetStatusPerProducts();

        bm.LoadProduct(hbt, 10);
        bm.GetStatusPerContainers();
        bm.GetStatusPerProducts();
    }
}