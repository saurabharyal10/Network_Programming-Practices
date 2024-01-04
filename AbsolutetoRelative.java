package np;

import java.net.URI;
import java.net.URISyntaxException;

public class AbsolutetoRelative {
	public static void main(String[] args) throws URISyntaxException {
		URI ab = new URI("https://www.asm.edu.np/images/ab.png");
		URI top = new URI("https://www.asm.edu.np");
		URI r = top.relativize(ab);
		System.out.println(r);
	} 
	
}
