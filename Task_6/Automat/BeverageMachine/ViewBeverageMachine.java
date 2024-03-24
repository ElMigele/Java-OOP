package Task_6.Automat.BeverageMachine;

import Task_6.Automat.General.View;

public class ViewBeverageMachine extends View {
    @Override
    public int GetCommandID(){
        System.out.println("Beverage Machine Commands:");
        System.out.println("0: Get Rest Beverage Info");
        System.out.println("1: Get Cola (0.2)");
        System.out.println("2: Get Cola (0.5):");
        System.out.println("3: Get Cola (0.8):");
        System.out.println("4: Get Rocket Juice (0.4)");
        System.out.println("5: Get Rocket Juice (0.8)");
        System.out.println("6: Turn off");
        return super.GetCommandID();
    }
}