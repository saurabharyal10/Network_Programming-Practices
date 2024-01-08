package np;
import java.net.*;

public class URLEquality {

    public static void main(String[] args) {
        try {
            URL www = new URL("https://www.asm.edu.np:443");
            URL ibiblio = new URL("https://asm.edu.np/");
           
            System.out.println(www.equals(ibiblio));
           
        } catch (MalformedURLException ex) {
            System.err.println(ex);
        }
    }
}
