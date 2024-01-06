package np;

import java.net.URI;
import java.net.URISyntaxException;

public class RelativeURItoAbsoluteURI {
    public static void main(String[] args) throws URISyntaxException {
        URI absoluteuri = new URI("https://www.asm.edu.np");
        URI relativeURI = new URI("/images/abc.png");
       
        URI rtoa = absoluteuri.resolve(relativeURI);
        System.out.println(rtoa);
       
    }
   
}