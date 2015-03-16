package boundary;

import function.IFunction;

import java.io.*;
import java.net.*;

public class Listener implements Runnable {
	IFunction func;
	private static int port = 8000;

	public Listener(IFunction func) {
		this.func = func;
	}

	@Override
	public void run() {
		ServerSocket server  = null;
	    try {
	        server = new ServerSocket(port);
	    } catch (IOException e) {
	        System.err.println("Kunne ikke h�re p� port: " + port);
	        System.err.println(e);
	        System.exit(1);
	    }
	    
	    Socket client = null;
	    while(true) {
	    	try {
	    		client = server.accept();
	    	} catch (IOException ie) {
	    		System.out.print("Fangede IO fejl: " + ie.getMessage());
	    		System.exit(1);
	    	}
			// Connection started
    		Thread CC = new Thread(new ClientConnection(client,func));
    		CC.start();
	    }
	}
}
