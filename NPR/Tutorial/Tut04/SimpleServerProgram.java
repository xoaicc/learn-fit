package NPRTutorial.Tut04;

import java.io.*;
import java.net.*;

public class SimpleServerProgram { 
    public static void main(String args[]) {
        ServerSocket listener = null;
        String line;
        BufferedReader is;
        BufferedWriter os;
        Socket socketOfServer = null; 

        try { 
           listener = new ServerSocket(9999); 
        } catch (IOException e) { 
           System.out.println(e); 
           System.exit(1); 
        } 

        try {
            System.out.println("Server is waiting to accept user..."); 
            socketOfServer = listener.accept();
            System.out.println("Accept a client!"); 
            is = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream())); 
            os = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream())); 

            while (true) { 
                line = is.readLine();
                os.write(">> " + line); 
                os.newLine(); 
                os.flush(); 
                  
                if (line.equals("QUIT")) {
                    os.write(">> OK");
                    os.newLine(); 
                    os.flush(); 
                    break; 
                } 
            } 
        } catch (IOException e) { 
           System.out.println(e); 
           e.printStackTrace(); 
        } 
       System.out.println("Sever stopped!"); 
    }
}