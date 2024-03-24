package Task_6.Automat.CofeeMachine;

import Task_6.Automat.General.View;

public class ViewCofeeMachine extends View {
    @Override
    public int GetCommandID(){
        System.out.println("Beverage Machine Commands:");
        System.out.println("0: Get Rest Products Info");
        System.out.println("1: Prepare Americano (0.3)");
        System.out.println("2: Prepare Americano (0.4)");
        System.out.println("3: Prepare Americano (0.5)");
        System.out.println("4: Prepare Expresso (0.2)");
        System.out.println("5: Prepare Expresso (0.3)");
        System.out.println("6: Turn off");
        return super.GetCommandID();
    }
}