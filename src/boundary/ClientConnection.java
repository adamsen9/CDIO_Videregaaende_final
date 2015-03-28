package boundary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import function.IFunction;

public class ClientConnection implements Runnable {
	IFunction func;

	private Socket client;
	private BufferedReader in = null;
	private PrintWriter out = null;

	public ClientConnection(Socket CC, IFunction func){
		this.func = func;
		this.client = CC;
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream(), true);
		} catch(IOException e) {
			System.err.println(e);
			return;
		}
	}


	@Override
	public void run() {
		String input, response;
		while(true) {
//			System.out.println("YUP YUP");
			try {
				if (func.getRM20Answer() != "") { // svarer hvis der er indtastet et RM20 svar
					out.println("Svar på "+func.getSecText()+": "+func.getRM20Answer()+"\r");
					func.setRM20Answer("");
				}
				else if (in.ready()){
					input = in.readLine();
					if (input != null) {
//						System.out.println("Fik en besked: " + input);
						response = func.interpret(input, true);
//						System.out.println("Svarer: " + response);
						out.println("Server: " + response + "\r");
					}
				}
			} catch (IOException e) {
				System.err.println(e);
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
