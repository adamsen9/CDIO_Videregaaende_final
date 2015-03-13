package function;

import boundary.IBoundary;
import entity.IEntity;

public class Function implements IFunction {
	IBoundary menu;
	IEntity data;
	
	public Function(IEntity data) {
		this.data = data;
	}
	
	public void setBoundary(IBoundary menu) {
		this.menu = menu;
	}
	
	@Override
	public String interpret(String input) {
		if (input.equals("S\r\n")) {
			// send v�gt tilbage (S S)
			return "S S" + getWeight();
		}

		else if (input.equals("T\r\n")){ // Tar�r v�gt
			tareWeight();
			//opdater menu?
		}
		
		else if (input.startsWith("D ")) {
//			input.substring(3, input.indexOf("\r")-1);
//			opdater menu, vis besked...
		}

		else if (input.startsWith("B")){
//			String temp=input.substring(2,input.length());
//			brutto=Double.parseDouble(temp);
//			printMenu();
//			outStream.writeBytes("DB"+"\r\n");
		}

		else if ((input.startsWith("DW"))){
			System.out.println("Program stoppet, Q modtaget paa com port");
		}
		return null;
	}

	@Override
	public String getWeight() {
		return Double.toString(data.getBrutto()-data.getTara());
	}

	@Override
	public void tareWeight() {
		data.setTara(data.getBrutto());
	}

	@Override
	public void displayMsg(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayWeight() {
		
	}

	@Override
	public void displaySecMsg(String msg) {
		
	}

	@Override
	public void changeWeight(double weight) {
		data.setBrutto(weight);
	}
	

	@Override
	public void quit() {
		//luk alle connections
	}

	@Override
	public void zeroWeight() {
		data.setBrutto(0.0);
		data.setTara(0.0);
	}

}
