package Task_5.Classes;

import java.util.ArrayList;

public class PersonList<P> {
    private int freeID = 0;
    public ArrayList<P> Persons(){
        return persons;
    }
    private ArrayList<P> persons;

    public PersonList(){
        persons = new ArrayList<>();
    }

    public void Add(P p){
        persons.add(p);
        ((Person)p).SetID(freeID);
        freeID++;
    }

    public P GetPerson(int ID){
        if (ID < 0 || ID >= persons.size()) {
            throw new UnsupportedOperationException("ID is out of range");
        }
        return persons.get(ID);
    }

    @Override
    public String toString(){
        String res = new String();
        for (P p : persons) {
            res += p.toString() + "\n";
        }
        return res;
    }
}