package np;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class DayTimeClient {
    public static void main(String[] args) {
        String hostname = "time.nist.gov";
        Socket socket = null;
        try{
          socket = new Socket(hostname,13);
          socket.setSoTimeout(15000);
          InputStream in = socket.getInputStream();
          InputStreamReader reader = new InputStreamReader(in,"ASCII");
          StringBuilder time = new StringBuilder();
          for(int c=reader.read();c!=-1;c=reader.read()){
             time.append((char) c);
          }
            System.out.println(time);  
        }catch(IOException ex){
            System.out.println(ex);
        }finally{
            if(socket!=null){
                try{
                    socket.close();
                }catch(IOException ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}