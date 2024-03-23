package Task_7.Operation;

public class Div implements Operation {
	private double a, b;
	
	public Div(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public double Perform() {
		return a / b;
	}
}