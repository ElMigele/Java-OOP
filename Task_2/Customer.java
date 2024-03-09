package Task_2;

import java.util.ArrayList;

public class Customer {
    public ArrayList<SupplyDemand> CustomerList;
    
    public Customer(ArrayList<SupplyDemand> CustomerList){
        this.CustomerList = CustomerList;
    }

    public boolean Satisfied(){
        for (int i = 0; i < CustomerList.size(); i++) {
            if (!CustomerList.get(i).Satisfied()){
                return false;
            }
        }
        return true;
    }
}