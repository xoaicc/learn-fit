package NPRTutorial.Tut05;

import java.io.*;
import java.net.*;
import java.util.Date;

public class ServiceThread extends Thread {
    private int clientNumber;
    private Socket socketOfServer;
    String clientSentence;
    String serverSentence;

    public ServiceThread(Socket socketOfServer, int clientNumber) {
        this.clientNumber = clientNumber;
        this.socketOfServer = socketOfServer;
        log("New connection with client #" + this.clientNumber + " at " + socketOfServer + " on " + new Date());
    }

    @Override
    public void run() {
        try {
            while (true) {
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(socketOfServer.getOutputStream());
                clientSentence = inFromClient.readLine();
                serverSentence = clientSentence;
                outToClient.writeBytes(serverSentence);

                if (clientSentence.equals("QUIT")) {
                    log("Client #" + this.clientNumber + "quit!");
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    private static void log(String message) {
        System.out.println(message);
    }
}