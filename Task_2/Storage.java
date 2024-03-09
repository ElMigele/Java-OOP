package Task_2;

import java.util.ArrayList;

public class Storage {
    public class  ProductInStorage {
        public Product Product(){
            return product;
        }
        private Product product;

        public int Amount(){
            return amount;
        }
        private int amount;

        public ProductInStorage(Product p, int amount){
            product = p;
            this.amount = amount;
        }

        public boolean Add(int value){
            if (value <= 0) {
                return false;
            }
            amount += value;
            return true;
        }

        public String Status(){
            return product.Name() + ". Amount: " + amount;
        }

        public int Remove(int value){
            if (value <= 0) {
                return 0;
            }
            if (amount >= value) {
                amount -= value;
                return value;
            } else {
                int res = value - amount;
                amount = 0;
                return res;
            }
        }
    }
    public ArrayList<ProductInStorage> products;

    public Storage(){
        products = new ArrayList<ProductInStorage>();
    }

    public ProductInStorage getProductInStorage(Product p){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).product.equals(p)){
                return products.get(i);
            }
        }
        return null;
    }

    public int GetProductVolume(Product p){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).product.equals(p)){
                return products.get(i).amount;
            }
        }
        return -1;
    }

    public boolean hasProduct(Product p){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).product.equals(p)){
                return true;
            }
        }
        return false;
    }

    public void Status(){
        System.out.println("Produts in storage:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).Status());
        }

        System.out.println("");
    }

    public boolean LoadProduct(Product p, int value){
        System.out.println("Load " + p.Name() + ", Value: " + value);
        if (value <= 0) {
            System.out.println("error: value <= 0!");
            return false;
        }

        ProductInStorage pis = getProductInStorage(p);
        if (pis != null) {
            pis.amount += value;
        } else {
            products.add(new ProductInStorage(p, value));
        }

        return true;
    }

    public int UnloadProduct(SupplyDemand demand){
        return UnloadProduct(demand.Product(), demand.Demand() - demand.Supply());
    }

    public int UnloadProduct(Product p, int value){
        System.out.println("Trying to unload " + p.Name() + ", Value: " + value);
        if (value <= 0){
            System.out.println("error: value <= 0!");
            return 0;
        }
        ProductInStorage pis = getProductInStorage(p);
        if (pis == null) {
            System.out.println("error: storage hasn't this type of product!");
            return 0;
        }
        
        int res = pis.Remove(value);
        if (pis.Amount() <= 0){
            products.remove(pis);
        }
        System.out.println("Unloaded " + p.Name() + ", Value: " + res);
        System.out.println("");
        return res;
    }
}