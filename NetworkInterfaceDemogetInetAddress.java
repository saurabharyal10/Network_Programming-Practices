package np;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkInterfaceDemogetInetAddress {
	public static void main(String[] args) throws SocketException {
		NetworkInterface eth0 = NetworkInterface.getByName("lo");
		Enumeration allips = eth0.getInetAddresses();
		
		while(allips.hasMoreElements()) {
			System.out.println(allips.nextElement());
		}
	}
}
