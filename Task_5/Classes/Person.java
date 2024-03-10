package Task_5.Classes;

public abstract class Person {
    public int ID(){
        return id;
    }
    private int id;

    public void SetID(int id){
        this.id = id;
    }

    public String Name(){
        return name;
    }
    private String name;
    
    public Person(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Name: " + name + ", ID: " + id;
    }
}