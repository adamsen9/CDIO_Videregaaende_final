import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
	private static double brutto = 0, tara = 0;
	private static String inLine, instruktionsDisplay="";
	private static int portDst = 8000;
	private static ServerSocket listener;
	private static Socket sock;
	private static BufferedReader inStream;
	private static DataOutputStream outStream;
	
	public static void main(String[] args) throws IOException {
		listener = new ServerSocket(portDst);
		System.out.println("Venter på forbindelse på port "+portDst);
		sock = listener.accept();
		System.out.println(sock.getInetAddress());
		inStream = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		outStream = new DataOutputStream(sock.getOutputStream());
		printMenu();
		
		try {
			while (!(inLine = inStream.readLine().toUpperCase()).isEmpty()) {

				if (inLine.startsWith("DN")) {
					
				}

				else if (inLine.startsWith("D")) { // vis tekst på display (max. 7 karakterer)
					if (inLine.equals("D")) {
						instruktionsDisplay="";
					}
					else {
						//evt. tjek for streng længde her!
						instruktionsDisplay=(inLine.substring(2,inLine.length()));
						printMenu();
						outStream.writeBytes("DB"+"\r\n");
					}
				}

				else if (inLine.startsWith("T")){
					outStream.writeBytes("T"+(tara)+"kg"+"\r\n");
					tara=brutto;
					printMenu();
				}
	
				else if (inLine.startsWith("S")){
					printMenu();
					outStream.writeBytes("S"+(brutto-tara)+"kg" +"\r\n");
				}
	
				else if (inLine.startsWith("B")){
					String temp=inLine.substring(2,inLine.length());
					brutto=Double.parseDouble(temp);
					printMenu();
					outStream.writeBytes("DB"+"\r\n");
				}

				else if ((inLine.startsWith("Q"))){
					System.out.println("");
					System.out.println("Program stoppet, Q modtaget paa com port");
					System.in.close();
					System.out.close();
					inStream.close();
					outStream.close();
					System.exit(0);
				}
			}
		}
		finally {
			inStream.close();
			outStream.close();
			System.exit(0);	
		}
	}
	
	public static void printMenu() {
		for (int i=0; i<25; i++) System.out.println("");
		System.out.println("*****************************************************");
		System.out.println("Netto vægt: "+(brutto-tara)+" kg.");
		System.out.println("Instruktionsdisplay: "+instruktionsDisplay);
		System.out.println("                                                     ");
		System.out.println("                                                     ");
		System.out.println("Debug info:                                          ");
		System.out.println("Forbundet til: "+sock.getInetAddress());
		System.out.println("Brutto: "+brutto+" kg.");
		System.out.println("Strent modtaget: "+inLine);
		System.out.println("Denne vægtsimulator forstår ordrerne:");
		System.out.println("D, DN, S, T, B, Q");
		System.out.println("*******");
		System.out.println("Tast T for tara (svarende til knaptryk på vægt)");
		System.out.println("Tast B for ny bruttovægt (svarende til at belastningen på vægt ændres)");
		System.out.println("Tast Q for at afslutte program");
		System.out.println("Indtast(T/B/Q for knaptryk/bruttoændring/quit)");
		System.out.print ("Tast her:");
	}	
}
