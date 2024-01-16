package HTTPServer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Server {

    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(8080)){
            while(true){
                try(Socket client = serverSocket.accept()){
                    handleClient(client);
                }
            }
        }
    }
   
    private static void handleClient(Socket client) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        StringBuilder requestBuilder = new StringBuilder();
        String line;
        while(!(line=br.readLine()).isBlank()){
            requestBuilder.append(line+"\r\n");
        }
        String request = requestBuilder.toString();
        System.out.println(request);
        String[] requestLines = request.split("\r\n");
        String[] requestLine = requestLines[0].split(" ");
        String method  = requestLine[0];
        String path = requestLine[1];
        String version = requestLine[2];
        String host = requestLine[1].split(" ")[1];
       
        List<String> headers = new ArrayList<>();
        for(int i=2;i<requestLines.length;i++){
            String header = requestLines[i];
            headers.add(header);
        }
       
        String accessLog = String.format("Client %s, method %s , path %s , version %s, host %s , headers %s",
                client.toString(),method,path,version,host);
        System.out.println(accessLog);
        Path filePath = getFilePath(path);
       
        if(Files.exists(filePath)){
            String contentType = guessContentType(filePath);
            sendResponse(client,"200 Ok", contentType, Files.readAllBytes(filePath));
        }else{
            byte[] notfoundcontent = "<h1> NOT found </h1>".getBytes();
           
            sendResponse(client,"404 Not Found","text/html", notfoundcontent);
        }
               
    }
   
    private static void sendResponse(Socket client, String status, String contentType,byte[] content) throws IOException{
        OutputStream clientout = client.getOutputStream();
        clientout.write(("HTTP/1.1 \r\n"+status).getBytes());
        clientout.write(("ContentType: "+contentType).getBytes());
        clientout.write("\r\n".getBytes());
        clientout.write(content);
        clientout.write("\r\n\r\n".getBytes());
        clientout.flush();
        client.close();
    }
   
    private static Path getFilePath(String path){
        if("/".equals("path")){
            path = "/index.html";
        }
        return Paths.get("/www",path);
    }
   
    private static String guessContentType(Path filPath) throws IOException{
        return Files.probeContentType(filPath);
    }
   
}
