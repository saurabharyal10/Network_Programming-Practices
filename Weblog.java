package np;

import java.io.*;
import java.net.*;
public class Weblog {
public static void main(String[] args) {
    String filePath = "C:\\netbeans\\bin\\NP\\src\\np\\log.txt";
    try (FileInputStream fin = new FileInputStream(filePath);
        Reader in = new InputStreamReader(fin);
        BufferedReader bin = new BufferedReader(in);) {
        for (String entry = bin.readLine();entry != null;entry = bin.readLine()) {
            // separate out the IP address
             
                int index = entry.indexOf(' '); //14
                String ip = entry.substring(0, index);
            // Ask DNS for the hostname and print it out
                try {
                    InetAddress address = InetAddress.getByName(ip);
                    System.out.println(address.getHostName());
                } catch (UnknownHostException ex) {
                    System.err.println(entry);
                }
        }
    } catch (IOException ex) {
    System.out.println("Exception: " + ex);
    }
}
}