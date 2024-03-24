package Task_6.Automat.General;

import java.util.Scanner;

public abstract class View {
    protected Scanner scan;

    public View(){
        scan = new Scanner(System.in);
    }

    public int GetCommandID(){
        return scan.nextInt();
    }

    public int GetValue(){
        return scan.nextInt();
    }

    public boolean GetBoolean(){
        return scan.next().equals("y");
    }

    public void Print(String text){
        System.out.println(text);
    }
}