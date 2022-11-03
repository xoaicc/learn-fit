package NPRTutorial.Tut04;

import java.io.*;
import java.net.*;

public class ServerProgram { 
    public static void main(String args[]) throws IOException { 
        ServerSocket listener = null; 
        System.out.println("Server is waiting to accept user..."); 
        int clientNumber = 0; 
        
        try { 
            listener = new ServerSocket(7777); 
        } catch (IOException e) { 
           System.out.println(e); 
           System.exit(1); 
        } 

        try { 
            while (true) { 
                Socket socketOfServer = listener.accept(); 
                new ServiceThread(socketOfServer, clientNumber++).start(); 
            } 
        } finally {
            listener.close(); 
        } 
    }
    private static void log(String message) { 
       System.out.println(message); 
    }
    private static class ServiceThread extends Thread { 
        private int clientNumber; 
        private Socket socketOfServer; 
        public ServiceThread(Socket socketOfServer, int clientNumber) { 
            this.clientNumber = clientNumber;
            this.socketOfServer = socketOfServer; 
            // Log 
            log("New connection with client# " + this.clientNumber + " at " + socketOfServer); 
        }
        
        @Override 
        public void run() { 
            try { 
                BufferedReader is = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream())); 
                BufferedWriter os = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream())); 
                while (true) { 
                    String line = is.readLine(); 
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
        } 
    } 
}