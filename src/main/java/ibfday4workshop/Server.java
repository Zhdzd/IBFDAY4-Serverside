package ibfday4workshop;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.*;
import java.io.*;


public class Server {

    //test 1 2 3
    public static void main(String[] args) throws IOException{
        
        String inputFile = "cookie_file.txt";
        System.out.println("client connected");//connects with client
        ServerSocket ss = new ServerSocket(12345);
        Socket s = ss.accept(); //blocking call, this will wait till connection is attempted 
        
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        InputStreamReader in = new InputStreamReader(s.getInputStream());//receiving from client
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("client : "+str);
        
        while(!"close".equals(str) && null != str) {
            System.out.println("Client: "+ str);

        try {
                
            if ("get-cookie".equals(str)) {
                System.out.println("Sending a cookie..");
                out.println("cookie-text " + new Cookie().getCookie());
                out.flush();
                str = bf.readLine();
            } else{
                out.println("Server: you said "+str);
                out.flush();
                str = bf.readLine();
                }   
            } catch (Exception e){
                e.printStackTrace();
                break;
            } 
            
        }  
            s.close();
            ss.close();
    }       
          
}

    

