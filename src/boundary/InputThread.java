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
		while(true) {
			try {
				System.out.print("Indtast kommando:");
				System.out.println(func.interpret(sc.nextLine()));
				Thread.sleep(120);
			} catch (java.util.InputMismatchException e) {
				System.out.println("Indtast korrekt input");
				sc.nextLine();
			} catch (InterruptedException e) {
				
			}
		}
	}
}
