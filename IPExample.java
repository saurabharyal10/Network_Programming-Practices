package NPPractical;

import java.net.*;
import java.util.Scanner;

	public class IPExample {
		public static void main(String[] args) {
			
	    try {
	      Scanner scanner = new Scanner(System.in);
	      System.out.println("Please enter the IP address: ");
	      String demo = scanner.next();
	      InetAddress address = InetAddress.getByName(demo);

	      if (address.isAnyLocalAddress()) {
	        System.out.println(address + " is a wildcard address.");
	      }
	      if (address.isLoopbackAddress()) {
	        System.out.println(address + " is loopback address.");
	      }
	      else{
	        System.out.println("Don't know");
	      }
	    }
	 catch (UnknownHostException ex) {
	      System.err.println("Could not resolve " + args[0]);
	    }
	  }
	}