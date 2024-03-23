package Task_7.Operation;

public class Mul implements Operation {
	private double a, b;
	
	public Mul(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public double Perform() {
		return a * b;
	}
}