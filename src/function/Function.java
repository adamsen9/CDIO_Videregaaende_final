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
			return "RM20 mode engaged, wait for closure";
			
		} else if (input.equals("T")){ // Tar�r v�gt
			tareWeight();
			return "T S";
			//opdater menu - sker af sig selv
		} else if (input.startsWith("D ")) {
			displayMsg(input.substring(3, input.lastIndexOf("\"")));
			return "D A";
//			opdater menu, vis besked...
			
		} else if (input.equals("DW")){
			//Nulstiller tekst på vægten, viser vejeresultat igen
			displayMsg(" ");
			return "DW A";
			
		} else if (input.startsWith("RM20 ")){
			engageRM20(true);
			String split[] = input.split(" ");
			try {
				if(split[1].equals("4")) {
					System.out.println(split[1]);
				} else if(split[1].equals("8")) {
					System.out.println(split[1]);
				}
			} catch(IndexOutOfBoundsException e) {
				return "RM20 ES";
			}
			engageRM20(false);
			
			
			
			
			
			
			
			
		} else if(input.startsWith("P111 ")){
			displaySecMsg(input.substring(6, input.lastIndexOf("\"")));
			return "P111 A";
		} else if(input.equals("Q")){
			System.out.println("Systemet lukker ned.");
			System.exit(1);
		} else if(input.startsWith("B ")) {
			try {
				if(!input.contains(".")) {
					input += ".";
				}
				input += "0000";
				changeWeight(Double.parseDouble(input.substring(2,7)));
				return "";
			} catch(NumberFormatException e) {
				return "Input fejl, prøv igen";
			}
		}
		return "ES";
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
		data.setText(msg);
	}

	@Override
	public void displayWeight() {
	}

	@Override
	public void displaySecMsg(String msg) {
		data.setSecDisplay(msg);
	}

	@Override
	public void changeWeight(double weight) {
		if(weight > 6) {
			System.out.println("Brutto må ikke overstige 6 kg");
		} else {
			data.setBrutto(weight);			
		}
	}
	

	@Override
	public void quit() {
		System.out.println("Systemet lukker");
		System.exit(1);
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
	public String getSecText() {
		// TODO Auto-generated method stub
		return data.getSecDisplay();
	}
	
	@Override
	public double getBrutto(){
		return data.getBrutto();
	}
	
	@Override
	public double convert(String input){
		return Double.parseDouble(input) + 1;
	}

	@Override
	public double getTara() {
		return data.getTara();
	}

	@Override
	public void engageRM20(boolean state) {
		data.setRM20(state);
	}
}
