package Task_7.Operation;

public class Sub implements Operation {
	private double a, b;
	
	public Sub(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public double Perform() {
		return a - b;
	}
}