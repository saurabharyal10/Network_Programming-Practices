package SocketServerExamples;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SocketServerDemo {
	public static int DEFAULT_PORT = 13;
	
	public static void main(String[] args) {
		
		try(ServerSocket server = new ServerSocket(DEFAULT_PORT)) {
			while(true) {
				try(Socket connection = server.accept()){
					Writer out = new OutputStreamWriter(connection.getOutputStream());
					Date date = new Date();
					out.write("Current Date: "+date.toString());
					out.flush();
					connection.close();
				}catch(IOException ex) {
					System.out.println(ex.getMessage());
				}
			}
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
