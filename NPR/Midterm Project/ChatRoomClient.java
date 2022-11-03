package NPRTutorial.MidtermProject;

import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;

public class ChatRoomClient {
    private InetAddress host;
    private int port;

    public ChatRoomClient(InetAddress host, int port) {
        this.host = host;
        this.port = port;
    }

    public void execute() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your nickname: ");
        String name = input.nextLine();

        Socket client = new Socket(host, port);
        DataOutputStream dos = new DataOutputStream (client.getOutputStream());
        dos.writeUTF(name);
        System.out.println("Connected! Start message...");
        ReadClient read = new ReadClient(client);
        read.start();
        WriteClient write = new WriteClient(client, name);
        write.start();
    }

    public static void main(String[] args) throws IOException {
        ChatRoomClient client = new ChatRoomClient(InetAddress.getLocalHost(), 9876);
        client.execute();
    }
}

class ReadClient extends Thread {
    private Socket client;

    public ReadClient(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(client.getInputStream());
            while (true) {
                String message = dis.readUTF();
                System.out.println(message);
            }
        } catch (Exception e) {
            try {
                dis.close();
                client.close();
            } catch (IOException er) {
                System.out.println("Disconnected the server!");
            }
        }
    }
}

class WriteClient extends Thread {
    private Socket client;
    private String name;

    public WriteClient(Socket client, String name) {
        this.client = client;
        this.name = name;
    }

    @Override
    public void run() {
        DataOutputStream dos = null;
        Scanner input = new Scanner(System.in);

        try {
            dos = new DataOutputStream(client.getOutputStream());

            while (true) {
                String message = input.nextLine();
                dos.writeUTF(name + ": " + message);
            }
        } catch (Exception e) {
            try {
                dos.close();
                client.close();
            } catch (IOException er) {
                System.out.println("Disconnected the server!");
            }
        }
    }
}