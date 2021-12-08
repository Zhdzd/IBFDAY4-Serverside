package ibfday4workshop;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.*;
import java.io.*;



public class Client {
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("localhost",12345);
        
        PrintWriter pr = new PrintWriter(s.getOutputStream());//sending to server
        pr.println("is it working");
        pr.flush();

        InputStreamReader in = new InputStreamReader(s.getInputStream());//receiving from server
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("server : "+str);
        
       

        
    }
}
