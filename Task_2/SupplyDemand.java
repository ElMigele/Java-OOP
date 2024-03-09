package Task_2;

public class SupplyDemand {
    public Product Product(){
        return product;
    }
    private Product product;

    public int Demand(){
        return demand;
    }
    private int demand;

    public int Supply(){
        return supply;
    }
    private int supply;

    public boolean Satisfied(){
        return supply == demand;
    }

    public void AddSupply(int value){
        supply += value;
    }

    public SupplyDemand(Product product, int demand, int supply){
        if (supply < 0 || demand < 0){
            return;
        }
        this.product = product;
        this.demand = demand;
        this.supply = supply;
    }
}