package NPRTutorial.Tut04;

import java.io.*; 
import java.net.*; 
import java.util.Date; 

public class ClientDemo { 
    public static void main(String[] args) { 
        final String serverHost = "localhost"; 
        Socket socketOfClient = null; 
        BufferedWriter os = null; 
        BufferedReader is = null; 

        try {
            socketOfClient = new Socket(serverHost, 7777); 
            os = new BufferedWriter(new OutputStreamWriter(socketOfClient.getOutputStream())); 
            is = new BufferedReader(new InputStreamReader(socketOfClient.getInputStream())); 
        } catch (UnknownHostException e) { 
            System.err.println("Don't know about host " + serverHost); 
            return; 
        } catch (IOException e) { 
            System.err.println("Couldn't get I/O for the connection to " + serverHost); 
            return; 
        } 

        try {
            os.write("HELLO! now is " + new Date()); 
            os.newLine();  
            os.flush();   
            os.write("I am a good slime!"); 
            os.newLine(); 
            os.flush(); 
            os.write("QUIT"); 
            os.newLine(); 
            os.flush(); 
            String responseLine; 

            while ((responseLine = is.readLine()) != null) { 
                System.out.println("Server: " + responseLine); 
                if (responseLine.indexOf("OK") != -1) { 
                    break;
                }
            }
            os.close(); 
            is.close(); 
            socketOfClient.close(); 
        } catch (UnknownHostException e) { 
            System.err.println("Trying to connect to unknown host: " + e); 
        } catch (IOException e) { 
            System.err.println("IOException:  " + e); 
        }
    }
}