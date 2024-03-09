package Task_2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Black Tea");
        Product p2 = new Product("Beer");
        Product p3 = new Product("Cola");
        Product p4 = new Product("Bread");
        Product p5 = new Product("Red Vine");
        Product p6 = new Product("White Vine");

        ArrayList<SupplyDemand> cl1 = new ArrayList<SupplyDemand>();
        cl1.add(new SupplyDemand(p1, 1, 0));
        cl1.add(new SupplyDemand(p2, 2, 0));

        ArrayList<SupplyDemand> cl2 = new ArrayList<SupplyDemand>();
        cl2.add(new SupplyDemand(p1, 1, 0));
        cl2.add(new SupplyDemand(p2, 2, 0));
        
        ArrayList<SupplyDemand> cl3 = new ArrayList<SupplyDemand>();
        cl3.add(new SupplyDemand(p1, 1, 0));
        cl3.add(new SupplyDemand(p2, 2, 0));

        Customer c1 = new Customer(cl1);
        Customer c2 = new Customer(cl2);
        Customer c3 = new Customer(cl3);

        CustomerQueue<Customer> q = new CustomerQueue<Customer>();
        q.Queue = new LinkedList<Customer>();
        q.Enqueue(c1);
        q.Enqueue(c2);
        q.Enqueue(c3);

        Storage s = new Storage();
        s.LoadProduct(p1, 5);
        s.LoadProduct(p2, 5);
        s.LoadProduct(p3, 5);
        s.LoadProduct(p4, 5);
        s.LoadProduct(p5, 5);
        s.LoadProduct(p6, 5);

        Market m = new Market(s, q);

        m.Update();
        m.Update();
        m.Update();
    }
}