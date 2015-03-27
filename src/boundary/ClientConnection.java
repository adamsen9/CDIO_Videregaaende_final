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
			//Obtain an input stream to this client
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			//and an output stream to the same client
			out = new PrintWriter(client.getOutputStream(), true);
		} catch(IOException e) {
	        System.err.println(e);
	        return;
		}
	}
	
	
	@Override
	public void run() {
		String input, response;
		try {
			//Loop reading lines from the client which are processed
			while((input = in.readLine()) != null) {

				System.out.println("Fik en besked:" + input);
				response = func.interpret(input, true);
				System.out.println("Svarer: " + response);
				
				out.println("Server: " + response + "\r");
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
