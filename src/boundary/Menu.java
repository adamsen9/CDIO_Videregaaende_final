package boundary;

import function.IFunction;

public class Menu implements IMenu, Runnable {
	String mainDisplay = "";
	String secDisplay = "";
	IFunction func;
	String brutto = "0.0";
	
	public Menu(IFunction func) {
		this.func = func;
	}

	@Override
	public void run() {
		if(func.getRM20() == true) {
			
		} else if(func.getRM20() == false) {
			try {
				System.out.println("===========================");
				System.out.print("Swag Vægt      ");
				System.out.println("");
				System.out.println("===========================");
				System.out.println("Brutto: " + brutto);
				
				while(true) {
					if((!func.getText().equals("") && !func.getText().equals(mainDisplay)) || (!func.getSecText().equals("") && !func.getSecText().equals(secDisplay))) {
						mainDisplay = func.getText();
						secDisplay = func.getSecText();
						System.out.println("===========================");
						System.out.println("Swag Vægt");
						System.out.println("===========================");
						System.out.println("     " + mainDisplay);
						System.out.println(secDisplay);
					} else if(!brutto.equals(func.getWeightString())) {
						brutto = func.getWeightString();
						System.out.println("===========================");
						System.out.println("Swag Vægt");
						System.out.println("===========================");
						System.out.println("     " + brutto + " kg");
						System.out.println(secDisplay);
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
