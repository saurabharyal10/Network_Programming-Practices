package SocketServerExamples;

import java.io.IOException;
import java.net.ServerSocket;

public class RandomPort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket server = new ServerSocket(0);
			System.out.println("This server runs on port "+ server.getLocalPort());
			System.out.println("Local Address "+ server.getInetAddress());
			server.close();
		}catch(IOException ex) {
			System.out.println(ex);
		}

	}

}
