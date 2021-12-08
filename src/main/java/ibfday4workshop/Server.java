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
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(12345);
        Socket s = ss.accept(); //blocking call, this will wait till connection is attempted 
        System.out.println("client connected");//connects with client

        InputStreamReader in = new InputStreamReader(s.getInputStream());//receiving from client
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("client : "+str);

        PrintWriter pr = new PrintWriter(s.getOutputStream());//sending to client
        pr.println("yes");
        pr.flush();


       

    }
}
