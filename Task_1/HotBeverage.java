package Task_1;

public class HotBeverage extends Beverage {

    private int temperature;
    public int Temperature(){
        return temperature;
    }

    public HotBeverage(String name, int temperature) {
        super(name);
        this.temperature = temperature;
    }
}