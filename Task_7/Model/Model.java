package Task_7.Model;

import Task_7.Operation.Operation;
import Task_7.Operation.OperationFabric;

public class Model {
	OperationFabric fabric;
    
    public Model(){
		fabric = new OperationFabric();
	}
	
	public double Result(double a, double b, String operator) {
		Operation oper = fabric.GetInstance(a, b, operator);
		return oper.Perform();
	}
}