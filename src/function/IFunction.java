package function;

import boundary.IBoundary;

public interface IFunction {
	void setBoundary(IBoundary menu);
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
