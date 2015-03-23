package function;

import boundary.IMenu;

import java.math.*;

import entity.IEntity;

public class Function implements IFunction {
	IMenu menu;
	IEntity data;
	
	public Function(IEntity data) {
		this.data = data;
	}
	
	public void setBoundary(IMenu menu) {
		this.menu = menu;
	}
	
	@Override
	public String interpret(String input) {
		if (input.equals("S")) {
			// send vægt tilbage (S S)
			if(getWeight() < 0) {
				return "S S     " + String.format("%.3g",getWeight()) + " kg";
			}
			return "S S      " + String.format("%.3g",getWeight()) + " kg";
			
		} else if(getRM20()) {
			return "RM20 command in process, wait for it to end";
			
		} else if (input.equals("T")){ // Tar�r v�gt
			tareWeight();
			return "T S";
			//opdater menu?
		} else if (input.startsWith("D ")) {
			setText(input.substring(3, input.lastIndexOf("\"")));
			return "Godt robert";
//			opdater menu, vis besked...
		} else if (input.startsWith("B")){
			//HUSK VÆGT ALDRIG STIGER OVER 6KG selv hvis man Tara. Da vægten jo ikke forsvinder
//			String temp=input.substring(2,input.length());
//			brutto=Double.parseDouble(temp);
//			printMenu();
//			outStream.writeBytes("DB"+"\r\n");
		} else if ((input.startsWith("DW "))){
			//Nulstiller tekst på vægten, viser vejeresultat igen
			//menu.removeText();
			System.out.println("Program stoppet, Q modtaget paa com port");
			
		} else {
			
			return "ES";
		}
		return null;
	}

	@Override
	public String getWeightString() {
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

	@Override
	public Double getWeight() {
		return data.getBrutto()-data.getTara();
	}

	@Override
	public boolean getRM20() {
		return data.getRM20();
	}

	@Override
	public String getText() {
		return data.getText();
	}

	@Override
	public void setText(String text) {
		data.setText(text);
	}
}
