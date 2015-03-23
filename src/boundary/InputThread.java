package boundary;

import java.util.Scanner;

import function.IFunction;;

public class InputThread extends Thread {
	IFunction func;
	
	public InputThread(IFunction func) {
		this.func = func;
	}
	
	public void run(){
		func.setInputRunning(true);
		Scanner sc = new Scanner(System.in);
			try {
				System.out.print("Indtast ny brutto:");
				func.changeWeight(sc.nextDouble());
				System.out.println();
			} catch (Exception e) {
				
			}
		sc.close();
		func.setInputRunning(false);
		
	}
}
