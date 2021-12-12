package ibfday4workshop;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.net.*;
import java.io.*;


public class Server {

    //test 1 2 3
    public static void main(String[] args) throws IOException{
        Socket s;
        ServerSocket ss;

        String inputFile = "cookie_file.txt";
        if(args !=null && args.length >= 1)
            inputFile = args[0];
        else{
            System.out.println("you didnt provide a file to" +
                "read the cookies. WIll try to read from deafult file.");
        }

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        ss = new ServerSocket(12345);
        System.out.println("Server listening at port 12345...");

        try{
            while(true){
                s = ss.accept();
                int id = (int)(Math.random()*100);
                CookieHandler worker = new CookieHandler(socket, id,inputFile);
                threadPool.submit(worker);
            }

        }   finally {
            ss.close();
        }

    }       
          
}

    

