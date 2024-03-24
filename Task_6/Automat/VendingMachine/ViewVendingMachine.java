package Task_6.Automat.VendingMachine;

import Task_6.Automat.General.View;

public class ViewVendingMachine extends View{
    @Override
    public int GetCommandID(){
        System.out.println("Vending Machine Commands:");
        System.out.println("0: Get Rest Product Info");
        System.out.println("1: Get Cola (0.5)");
        System.out.println("2: Get Sprite (0.5)");
        System.out.println("3: Turn off");
        return super.GetCommandID();
    }
}