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
		String input;
		while(true) {
			try {
				if (func.getRM20()) System.out.println(func.getSecText()+":");
				input = sc.nextLine();
				if (func.getRM20()) {
					func.setRM20Answer(input);
					func.engageRM20(false);
				}
				else {
					System.out.println(func.interpret(input, false));
				}
				Thread.sleep(120);
			} catch (java.util.InputMismatchException e) {
				System.out.println("Indtast korrekt input.");
				sc.nextLine();
			} catch (InterruptedException e) {
				sc.close();
				this.interrupt();
				return;
			}
		}
	}
}
