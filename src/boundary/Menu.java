package boundary;

import function.IFunction;

public class Menu extends Thread  {

	String mainDisplay = " ";
	String secDisplay = "";
	IFunction func;
	Double brutto = 0.000;
	Double tara = 0.000;
	Boolean displayrm20 = false;

	public Menu(IFunction func) {
		this.func = func;
	}

	@Override
	public void run() {
		displayrm20 = false;
		InputThread input = new InputThread(func);
		try {
			input.start();
			while (true) {
				if(!func.getRM20()) {
					if(!func.getText().equals("") && !func.getText().equals(mainDisplay) || (!func.getSecText().equals("") && !func.getSecText().equals(secDisplay))) {
						secDisplay = func.getSecText();
						System.out.println("\n\n\n");
						System.out.println("===========================");
						System.out.println("   Mettler Vægt Simulator     ");
						System.out.println("===========================");
						
						if(!func.getText().equals(" ") && (!func.getText().equals("") && !func.getText().equals(mainDisplay))) {
							mainDisplay = func.getText();
							System.out.println("Primær display: " + mainDisplay);
						} else if (func.getText().equals(" ") && !mainDisplay.equals(" ")) {
							mainDisplay = " ";
							System.out.printf("Primær display:     %.3f kg \n", func.getBrutto()-func.getTara());
						} else {
							//Else brutto
							System.out.printf("Primær display:     %.3f kg \n", func.getBrutto()-func.getTara());
						}
						System.out.println("Sekundær display: " + secDisplay);
						System.out.print("Indtast kommando: ");
					} else if(!func.getText().equals(" ") && (func.getBrutto() != brutto || !func.getText().equals(mainDisplay) || func.getTara() != tara || (!func.getSecText().equals("") && !func.getSecText().equals(secDisplay)))) {
						mainDisplay = "";
						func.displayMsg("");
						brutto = func.getBrutto();
						tara = func.getTara();
						System.out.println("\n\n\n");
						System.out.println("===========================");
						System.out.println("   Mettler Vægt Simulator  ");
						System.out.println("===========================");
						System.out.printf("Primær display:     %.3f kg \n", func.getBrutto()-func.getTara());
						System.out.println("Sekundær display: "+ secDisplay);
						System.out.print("Indtast kommando: ");
					} 
				} else {
					if(displayrm20 == false) {
						System.out.println("\n\n\n");
						System.out.println("===========================");
						System.out.println("   Mettler Vægt Simulator  ");
						System.out.println("===========================");
						System.out.printf("Primær display:   %s\n", func.getText());
						System.out.printf("Sekundær display: %s\n", func.getSecText());
						System.out.print("Indtast kommando: ");
						displayrm20 = true;
					}
				}
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println("God historie 1");
		}
	}
}
