package Task_7.Present;

import Task_7.View.ConsoleView;

public class ConsolePresent extends Present {
	Boolean loop;
	double d1, d2, d3;
	String oper;
    ConsoleView v;
	boolean operCorrect;

	public ConsolePresent(){
        v = new ConsoleView();
		loop = true;
	}
	
	@Override
	public void Run(){
		while (loop){
            operCorrect = false;
			d1 = d3 != 0
				? v.GetFirstValue(d3)
				: v.GetFirstValue();				
			while (!operCorrect){
                oper = v.GetOperator();
                operCorrect = v.CheckOper(oper);
            }
			
            d2  = v.GetSecondValue();
			
			d3 = m.Result(d1, d2, oper);
			
			v.ShowResult(d1, d2, d3, oper);

			loop = v.GetConfirm();
		}
	}
}