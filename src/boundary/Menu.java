package boundary;

import function.IFunction;

public class Menu implements IMenu, Runnable {
	

	String mainDisplay = "";
	String secDisplay = "";
	IFunction func;
	Double brutto = 0.000;
	
	public Menu(IFunction func) {
		this.func = func;

	}

	@Override
	public void run() {
	InputThread input = new InputThread(func);
		if(func.getRM20() == true) {
			
		} else if(func.getRM20() == false) {
			try {
				System.out.println("===========================");
				System.out.print("Swag Vægt      ");
				System.out.println("");
				System.out.println("===========================");
				System.out.println("Brutto: " + func.getBrutto());
				input.start();

				
				while(true) {
					if((!func.getText().equals("") && !func.getText().equals(mainDisplay)) || (!func.getSecText().equals("") && !func.getSecText().equals(secDisplay))) {
						mainDisplay = func.getText();
						secDisplay = func.getSecText();
						System.out.println("===========================");
						System.out.println("Swag Vægt");
						System.out.println("===========================");
						System.out.println("     " + mainDisplay);
						System.out.println(secDisplay);

					} else if(func.getBrutto() != brutto) {
						brutto = func.getBrutto();
						System.out.println("===========================");
						System.out.println("Swag Vægt");
						System.out.println("===========================");
						System.out.println("     " + func.getBrutto() + " kg");
					}
					
					System.out.println(func.getInputRunning());
					if(func.getInputRunning()) {
						
					} else {
						System.out.print("Bøh");
						func.setInputRunning(true);
						input = new InputThread(func);
						input.start();
					}
					
					Thread.sleep(100);	
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// TODO Auto-generated method stub
			}

}
