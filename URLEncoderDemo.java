package np;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

public class URLEncoderDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
      String a = "https://www.google.com/search?hl=en&as_q=Java汉字&as_epq=I/O";
      String url = "https://www.google.com/search?";
      url += URLEncoder.encode("hl", "UTF-8");
      url += "=";
      url += URLEncoder.encode("en", "UTF-8");
      url += "&";
      url += URLEncoder.encode("as_q", "UTF-8");
      url += "=";
      url += URLEncoder.encode("Java汉字", "UTF-8");
      url += "&";
      url += URLEncoder.encode("as_epq", "UTF-8");
      url += "=";
      url += URLEncoder.encode("I/O", "UTF-8");
      System.out.println(url);
    }
}