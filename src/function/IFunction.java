package function;

import boundary.IMenu;

public interface IFunction {
	void setBoundary(IMenu menu);
	String interpret(String input);
	String getWeightString();
	Double getWeight();
	boolean getRM20();
	void engageRM20(boolean state);
	void tareWeight();
	void displayMsg(String msg);
	void displayWeight();
	void displaySecMsg(String msg);
	void changeWeight(double weight);
	void zeroWeight();
	void quit();
	String getText();
	String getSecText();
	double getBrutto();
	double convert(String input);
	public double getTara();
}
