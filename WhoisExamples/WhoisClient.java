package WhoisExamples;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class WhoisClient {
	public static final int DEFAULT_PORT = 443;
	public final static String DEFAULT_HOST = "lookup.icann.org";
	
	public static void main(String[] args) {
		InetAddress server;
		try {
			server = InetAddress.getByName(DEFAULT_HOST);
		}catch(UnknownHostException ex) {
			System.out.println("Error: could not locate the default host");
			return;
		}
		int port = DEFAULT_PORT;
		try {
			Socket theSocket = new Socket(server,port);
			Writer out = new OutputStreamWriter(theSocket.getOutputStream(),"8859_1");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the domain name: ");
			String domain = sc.next();
			out.write(domain+" ");
			out.write("\r\n");
			out.flush();
			
			InputStream raw = theSocket.getInputStream();
			InputStream in = new BufferedInputStream(raw);
			int c;
			while((c=in.read())!=-1) {
				System.out.println(c);
			}
		}catch(IOException ex) {
			System.out.println(ex);
		}
	}
}
