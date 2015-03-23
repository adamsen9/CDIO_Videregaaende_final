package boundary;

import java.util.Scanner;

import function.IFunction;;

public class InputThread extends Thread {
	IFunction func;
	
	public InputThread(IFunction func) {
		this.func = func;
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
			try {
				while(true) {
					System.out.println("Indtast ny brutto:");
					func.changeWeight(sc.nextDouble());
					System.out.println();
				}
			} catch (Exception e) {
				
			}
		sc.close();
		
	}
}
