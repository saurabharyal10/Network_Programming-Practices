package np;

import java.net.NetworkInterface;
import java.net.SocketException;

public class NetworkInteface {
	public static void main(String[] args) throws SocketException {
		NetworkInterface ni = NetworkInterface.getByName("eth0");
			System.out.println(ni);
	}
}
