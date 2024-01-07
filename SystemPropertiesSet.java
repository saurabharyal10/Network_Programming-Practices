package np;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SystemPropertiesSet {
    public static void main(String[] args) throws MalformedURLException, IOException {
        System.setProperty("http.proxyHost","198.125.124.1");
        System.setProperty("http.proxyPort","9000");
        System.setProperty("http.nonProxyHost","http://google.com|http://facebook.com|*.abc.com");
        URL url = new URL("http://asm.edu.np");
       
    }
}
