package np;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class NetworkInterfacegetByAddress {
	public static void main(String[] args) throws UnknownHostException, SocketException {
		InetAddress ip = InetAddress.getByName("127.0.0.1");
		NetworkInterface np = NetworkInterface.getByInetAddress(ip);
		if(np==null) {
			System.out.println("No Interface found");
		}else {
			System.out.println(np);
		}
}
}
