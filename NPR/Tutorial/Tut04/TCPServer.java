package NPRTutorial.Tut04;

import java.io.*; 
import java.net.*;  

class TCPServer {
    public static void main(String argv[]) throws Exception {  
        String clientSentence;  
        String capitalizedSentence;  
        ServerSocket welcomeSocket = new ServerSocket(6789); 
        System.out.println("Server is waiting to accept user... "); 

        while (true) { 
            Socket connectionSocket = welcomeSocket.accept();  
        	System.out.println("Accept a client!"); 
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());  
            clientSentence = inFromClient.readLine();  
            capitalizedSentence = clientSentence.toUpperCase() + "\n"; 
            outToClient.writeBytes(capitalizedSentence); 
            if (clientSentence == "QUIT") {
                break;
            }
        }  
    }  
}