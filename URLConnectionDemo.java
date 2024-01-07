package np;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionDemo {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://iitnepal.edu.np/");
			URLConnection uc = url.openConnection();
			try(InputStream raw = uc.getInputStream()) {
				InputStream buffer = new BufferedInputStream(raw);
				Reader reader = new InputStreamReader(buffer);
				int c;
				while((c=reader.read())!=-1){
					System.out.print((char) c);
				}
			}
			
		}catch(MalformedURLException ex) {
			System.out.println(ex.getMessage());
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
