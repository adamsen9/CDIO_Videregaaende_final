package boundary;

import function.IFunction;

public class Menu implements IMenu, Runnable {


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
		
		System.out.println("===========================");
		System.out.print("Swag Vægt      ");
		System.out.println("");
		System.out.println("===========================");
		System.out.printf("     %.3f kg \n", func.getBrutto());
		input.start();
		
		while (true) {
			if(func.getRM20() == true) {
				System.out.println("RM20 ER SGU AKTIV!!");
				input.interrupt();
				System.out.println(func.getSecText());
			}
			else if(func.getRM20() == false) {
					if(!func.getText().equals(" ") && ((!func.getText().equals("") && !func.getText().equals(mainDisplay)) || (!func.getSecText().equals("") && !func.getSecText().equals(secDisplay)))) {
						mainDisplay = func.getText();
						secDisplay = func.getSecText();
						System.out.println("===========================");
						System.out.println("Swag Vægt");
						System.out.println("===========================");
						System.out.println("     " + mainDisplay);
						System.out.println(secDisplay);

					} else if(func.getBrutto() != brutto || func.getText().equals(" ") || func.getTara() != tara) {
						mainDisplay = "";
						func.displayMsg("");
						brutto = func.getBrutto();
						tara = func.getTara();
						System.out.println("===========================");
						System.out.println("Swag Vægt");
						System.out.println("===========================");
						System.out.printf("     %.3f kg \n", func.getBrutto()-func.getTara());
						System.out.println(secDisplay);
					}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}

}
