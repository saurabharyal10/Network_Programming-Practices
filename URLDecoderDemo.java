package np;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
     
      String encodeurl = "https://www.google.com/search?hl=en&as_q=Java%E6%B1%89%E5%AD%97&as_epq=I%2FO";
        System.out.println(URLDecoder.decode(encodeurl,"UTF-8"));
    }
}
