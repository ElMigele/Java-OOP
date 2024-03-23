package Task_7.Operation;

public class OperationFabric {
	public Operation GetInstance(double a, double b, String operator) {
		switch(operator) {
			case "+":
				return new Sum(a, b);
			case "-":
				return new Sub(a, b);
			case "*":
				return new Mul(a, b);
			case "/":
				return new Div(a, b);
			default:
				return null;
		}
	}
}