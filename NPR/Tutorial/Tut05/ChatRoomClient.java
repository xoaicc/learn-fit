package NPRTutorial.Tut05;

import java.io.*;
import java.net.*;

public class ChatRoomClient {
    public static void main(String[] args) throws Exception {
        String sentence;
        String serverSentence;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 9876);

        while (true) {
            System.out.print("Please enter your message: ");
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            sentence = inFromServer.readLine();
            outToServer.writeBytes(sentence + "\n");
            if (sentence.equals("QUIT")) break;

            serverSentence = inFromServer.readLine();
            System.out.println("FROM SERVER: " + serverSentence);
        }
    }
}