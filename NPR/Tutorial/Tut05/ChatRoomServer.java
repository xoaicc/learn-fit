package NPRTutorial.Tut05;

import java.io.*;
import java.net.*;

class ChatRoomServer {
    public static void main(String argv[]) throws Exception {
        ServerSocket welcomeSocket = null;
        System.out.println("Server is waiting to accept user...");
        int clientNumber = 0;

        try {
            welcomeSocket = new ServerSocket(9876);
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }

        try {
            while (true) {
                Socket socketOfServer = welcomeSocket.accept();
                clientNumber++;
                new ServiceThread(socketOfServer, clientNumber).start();
            }
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        } finally {
            welcomeSocket.close();
        }
    }
}