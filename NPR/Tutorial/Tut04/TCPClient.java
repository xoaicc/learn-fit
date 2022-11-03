package NPRTutorial.Tut04;

import java.io.*;   
import java.net.*;

public class TCPClient {
    public static void main(String argv[]) throws Exception {   
        String sentence; 
        String modifiedSentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) { 
            System.out.print("Please enter your message: ");	 
            Socket clientSocket = new Socket("localhost", 6789); 
            DataOutputStream outToServer = new DataOutputStream (clientSocket.getOutputStream()); 
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
            sentence = inFromUser.readLine(); 
            outToServer.writeBytes(sentence + '\n');
            modifiedSentence = inFromServer.readLine();
            if (modifiedSentence == "QUIT") {
                break;
            } else {
                System.out.println("FROM SERVER: " + modifiedSentence);
            }
        }
    } 
}