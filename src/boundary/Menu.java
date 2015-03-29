package boundary;

import function.IFunction;

public class Menu extends Thread  {


	String mainDisplay = "";
	String secDisplay = "";
	IFunction func;
	Double brutto = 0.000;
	Double tara = 0.000;

	public Menu(IFunction func) {
		this.func = func;

	}

	@Override
	public void run() {
		InputThread input = new InputThread(func);
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("===========================");
		System.out.println("   Mettler Vægt Simulator     ");
		System.out.println("===========================");
		System.out.printf("Main display:     %.3f kg \n", func.getBrutto());
		System.out.println("Secondary display: "+ secDisplay);
		if (!func.getRM20()) System.out.print("Indtast kommando: ");
		input.start();
		
		while (true) {
			if(func.getRM20()) {
//				input.interrupt();
//				input = new InputThread(func);
//				System.out.println("Svar på: "+func.getSecText());
			}
			else if(!func.getRM20()) {
					if(!func.getText().equals(" ") && ((!func.getText().equals("") && !func.getText().equals(mainDisplay)) || (!func.getSecText().equals("") && !func.getSecText().equals(secDisplay)))) {
						mainDisplay = func.getText();
						secDisplay = func.getSecText();
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						System.out.println("===========================");
						System.out.println("   Mettler Vægt Simulator     ");
						System.out.println("===========================");
						System.out.println("Main display: " + mainDisplay);
						System.out.println("Secondary display: " + secDisplay);
						System.out.print("Indtast kommando: ");

					} else if(func.getBrutto() != brutto || func.getText().equals(" ") || func.getTara() != tara) {
						mainDisplay = "";
						func.displayMsg("");
						brutto = func.getBrutto();
						tara = func.getTara();
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						System.out.println("===========================");
						System.out.println("   Mettler Vægt Simulator     ");
						System.out.println("===========================");
						System.out.printf("Main display:     %.3f kg \n", func.getBrutto()-func.getTara());
						System.out.println("Secondary display: "+ secDisplay);
						System.out.print("Indtast kommando: ");
					}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				input.interrupt();
//				e.printStackTrace();
				return;
			}
		}
	}

}
