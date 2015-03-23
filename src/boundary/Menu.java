package boundary;

import function.IFunction;

public class Menu implements IMenu, Runnable {
	String text = "";
	IFunction func;
	
	public Menu(IFunction func) {
		this.func = func;
	}

	@Override
	public void run() {

			try {
				System.out.println("===========================");
				System.out.print("Swag Vægt      ");
				System.out.println(text);
				System.out.println("===========================");
				System.out.println("Brutto: " + func.getWeightString());
				
				while(true) {
					if(!func.getText().equals("") && !func.getText().equals(text)) {
						this.text = func.getText();
						System.out.println("===========================");
						System.out.print("Swag Vægt      ");
						System.out.print(text);
						System.out.println("===========================");
						System.out.println("Tekst her");
						System.out.println("Brutto: " + func.getWeightString());
					} else {
						Thread.sleep(100);	
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		System.out.print("");
		
		// TODO Auto-generated method stub
			}

}
