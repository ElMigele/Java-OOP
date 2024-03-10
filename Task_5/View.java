package Task_5;

import java.util.Scanner;

public class View {
    private Scanner scanner;

    public View(){
        scanner = new Scanner(System.in);
    }

    public int GetCommand(){
        System.out.println("Avaible commands:");
        System.out.println("0: Add Student");
        System.out.println("1: Get Student");
        System.out.println("2: Get All Student");

        System.out.println("3: Add Professor");
        System.out.println("4: Get Professor");
        System.out.println("5: Get All Professor");

        System.out.println("6: Add Group");
        System.out.println("7: Get Group");
        System.out.println("8: Get All Group");

        System.out.println("9: Shut Down Project");

        System.out.print("Enter # command: ");
        return scanner.nextInt();
    }

    public String GetName(String s){
        System.out.print("Enter "+ s + " name: ");
        return scanner.next();
    }

    public void ShowResult(String s){
        System.out.println(s);
    }

    public int GetID(String s){
        System.out.print("Enter " + s + " ID: ");
        return scanner.nextInt();
    }

    public void ShutDown() {
        System.out.println("Shutting down...");
    }

    public void ShowCom(int com) {
        System.out.println("");
        switch (com) {
            case 0:
                System.out.println("Run: Add Student");
                break;
            case 1:
                System.out.println("Run: Get Student");
                break;
            case 2:
                System.out.println("Run: Get All Student");
                break;
            case 3:
                System.out.println("Run: Add Professor");
                break;
            case 4:
                System.out.println("Run: Get Professor");
                break;
            case 5:
                System.out.println("Run: Get All Professor");
                break;
            case 6:
                System.out.println("Run: Create Group");
                break;
            case 7:
                System.out.println("Run: Get Group");
                break;
            case 8:
                System.out.println("Run: Get All Group");
                break;
            case 9:
                System.out.println("Run: Shut Down Project");
                break;
        }
    }

    public boolean ConfirmContinue() {
        System.out.print("Continue add student (enter 'y' to continue)? ");
        char r = scanner.next().charAt(0);
        return r == 'y';
    }
}