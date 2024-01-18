package SocketServerExamples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException{
		ServerSocket server = new ServerSocket(1235);
		System.out.println("Server is starting");
		Socket socket = server.accept();
		System.out.println("Request Accpeted");
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
			while(true) {
				String msg = reader.readLine();
				if(msg.equalsIgnoreCase("exit")==true) {
					System.out.println("Connection Lost");
					System.exit(1);
				}
				System.out.println("Client Message:"+msg);
				
			}	
		}

}
