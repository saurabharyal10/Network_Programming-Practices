package SocketServerExamples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {
		Socket sc = new Socket("127.0.0.1",1235);
		System.out.println("Client is starting");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		PrintStream out = new PrintStream(sc.getOutputStream());
			while(true) {
				System.out.println("Enter Message:");
				String msg = reader.readLine();
				out.println(msg);
				if(msg.equalsIgnoreCase("exit")==true) {
					System.out.println("Connection was terminated");
					System.exit(1);
				}
				out.flush();
				
			}	
		}
}
