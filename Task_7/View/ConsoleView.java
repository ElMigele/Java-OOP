package Task_7.View;

import java.util.Scanner;

public class ConsoleView extends View {
	Scanner scan;
	
	public ConsoleView(){
		scan = new Scanner(System.in);
	}

	public double GetFirstValue(){
		System.out.print("Enter first value: ");
		return scan.nextDouble();
	}

	public double GetFirstValue(double v){
		System.out.print("Enter first value (last result " + v + "): ");
		return scan.nextDouble();
	}

	public double GetSecondValue(){
		System.out.print("Enter second value: ");
		return scan.nextDouble();
	}
		
	public String GetOperator(){
		System.out.print("Enter operator [ + | - | * | / ]: ");
		return scan.next();
	}
	
	public void ShowResult(double a, double b, double res, String oper){
		if (a == 0 && oper.equals("/"))
			System.out.println("Operation error: '" + a + " " + oper + " " + b + "'. Can't divide by zero");
		else
			System.out.println(a + " " + oper + " " + b + " = " + res);		
	}
	
	public Boolean GetConfirm(){
		System.out.print("Continue work? Enter \"y\" to continue: ");
		String s = scan.next();
		return s.equals("y");
	}

	public boolean CheckOper(String oper) {
		boolean check = oper.equals("+")
			|| oper.equals("-")
			|| oper.equals("*")
			|| oper.equals("/");
		if (!check)
			System.out.print("Error: Incorrect operator \n");
	
		return check;
	}
}