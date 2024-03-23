package Task_7.Present;

import Task_7.Model.Model;

public abstract class Present {
	protected Model m;

	public Present(){
		m = new Model();
	}
	
	public abstract void Run();
}
