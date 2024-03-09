package Task_2;

public class Market{
    public CustomerQueue<Customer> Customers;
    
    public Storage storage;
    
    public Market(Storage storage){
        this.storage = storage;
    }

    public Market(Storage storage, CustomerQueue<Customer> Customers){
        this.storage = storage;
        this.Customers = Customers;
    }

    public void Upkeep(){
        System.out.println("");
        System.out.println("Client is upkeeping. 'Please welcome, sir!'");

        Customer c = Customers.FirstOne();
        for (int i = 0; i < c.CustomerList.size(); i++) {
            if (c.CustomerList.get(i).Satisfied()){
                continue;
            } else {
                c.CustomerList.get(i).AddSupply(storage.UnloadProduct(c.CustomerList.get(i)));
            }
        }
        System.out.println("Client is upkeeped. Satisfied: " + c.Satisfied());
        Customers.Dequeue(c);
    }

    public void Update(){
        if (Customers.FirstOne() == null){
            System.out.println("No customers");
            return;
        }
        Upkeep();
        
        StoreStatus();
        QueueStatus();

    }

    public void StoreStatus(){
        storage.Status();
    }
    
    public void QueueStatus(){
        Customers.Status();
    }

}