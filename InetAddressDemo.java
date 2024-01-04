package np;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getByName("www.google.com");
			byte[] addr =ip.getAddress();
			System.out.println(ip.getHostAddress());
			System.out.println(ip.getHostName());
			System.out.println(ip.getLocalHost());
			System.out.println(ip.getByAddress(addr));
//			System.out.println(ip.isReachable(5000));
			
			String ipaddress = ip.getHostAddress();
			InetAddress ip2 = InetAddress.getByAddress(addr);
		}catch(UnknownHostException e) {
			System.out.println(e.getMessage());
		}
	}
}
