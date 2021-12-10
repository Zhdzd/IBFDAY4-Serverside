package ibfday4workshop;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.net.*;
import java.io.*;


//test 4 5 6
public class Client {
    public static void main(String[] args) throws IOException{
        System.out.println("Creating client socket....");
        Socket s = new Socket("localhost",12345);
        
        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));
        
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);//sending to server
        System.out.println("Connected to localhost:12345!");
        System.out.println("Get cookies?");
        Scanner scan = new Scanner(System.in);
        String serverMsg = "";
        String line = scan.nextLine();

        while (!"close".equals(line)){
            out.println(line); //relating to print writer
            out.flush();
            serverMsg = in.readLine();
            System.out.println(serverMsg);
            line = scan.nextLine();
        }
            s.close();
            scan.close();

    }
}
