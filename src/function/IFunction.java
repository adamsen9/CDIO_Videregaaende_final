package function;

import boundary.IMenu;

public interface IFunction {
	void setBoundary(IMenu menu);
	String interpret(String input);
	String getWeight();
	void tareWeight();
	void displayMsg(String msg);
	void displayWeight();
	void displaySecMsg(String msg);
	void changeWeight(double weight);
	void zeroWeight();
	void quit();
}
