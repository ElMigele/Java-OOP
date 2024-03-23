package Task_7.Operation;

public class Sum implements Operation {
	private double a, b;
	
	public Sum(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public double Perform() {
		return a + b;
	}
}