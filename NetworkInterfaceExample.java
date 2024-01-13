package NPPractical;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class NetworkInterfaceExample {
	public static void main(String[] args) throws UnknownHostException, SocketException {
		InetAddress ip = InetAddress.getByName("127.0.0.1");
		NetworkInterface np = NetworkInterface.getByInetAddress(ip);
		if(np==null) {
			System.out.println("No Interface found");
		}else {
			System.out.println(np);
		}
		
		NetworkInterface ni = NetworkInterface.getByName("eth0");
		System.out.println(ni);

		Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
		while (interfaces.hasMoreElements()) {
			NetworkInterface nic = interfaces.nextElement();
			System.out.println(nic);
		}
		
}
}
