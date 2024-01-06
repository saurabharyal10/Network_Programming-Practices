package np;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SpamChecker {
	public static final String BLACKHOLE = "spamhaus.org/sbl";
	
	public static void main(String[] args) throws UnknownHostException{
		String[] ips = {"207.34.56.23","34.23.232.22","145.23.34.12"};
		for (String arg: ips) {
			if(isSpammer(arg)) {
				System.out.println(arg + " is a known spammer.");
			}else {
				System.out.println(arg + " appears legitimate.");
			}
		}	
	}
	private static boolean isSpammer(String arg) {
		try {
			InetAddress address = InetAddress.getByName(arg);
			byte[] quad = address.getAddress();
			
			String query = BLACKHOLE;
			
			for(byte octet:quad) {
				int unsignedByte = octet < 0 ? octet + 256 : octet;
				query = unsignedByte + "." + query;
//				System.out.println(query);
			}
			InetAddress.getByName(query);
			return true;
		}catch (UnknownHostException e) {
			return false;
		}
	}
	
}
