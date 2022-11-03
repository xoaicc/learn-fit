package NPRTutorial.MidtermProject;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ChatRoomServer {
    private int port;
    public static Map<String, Socket> ListSK = new HashMap<>();

    public ChatRoomServer(int port) {
        this.port = port;
    }

    private void execute() throws IOException {
        ServerSocket server = new ServerSocket(port);
        
        while (true) {
            Socket socket = server.accept();
            System.out.println("Accept a client with " + socket);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String name = dis.readUTF();
            ChatRoomServer.ListSK.put(name, socket);
            ContactServer contact = new ContactServer(name);
            contact.start();
        }
    }

    public static void main(String[] args) throws IOException {
        ChatRoomServer server = new ChatRoomServer(9876);
        System.out.println("Server is waiting to accept user...");
        server.execute();
    }

    public Socket accept() {
        return null;
    }
}

class ContactServer extends Thread {
    private String name;

    public ContactServer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Socket socket = ChatRoomServer.ListSK.get(name);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            while (true) {
                String message = dis.readUTF();
                if (message.contains("exit")) {
                    ChatRoomServer.ListSK.remove(name);
                    System.out.println("Disconnected to " + socket);
                    for (Socket item : ChatRoomServer.ListSK.values()) {
                        if (item.getPort() != socket.getPort()) {
                            DataOutputStream dos = new DataOutputStream(item.getOutputStream());
                            dos.writeUTF("SERVER: " + name + " is offline!");
                        }
                    }
                    continue;
                }
                if (message.contains("who online?")) {
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    dos.writeUTF("SERVER: " + ChatRoomServer.ListSK.keySet() + " are online!");
                    continue;
                }
                if (message.contains("chat to")) {
                    String privateMessage = message.substring(message.indexOf(">") + 2, message.length());
                    String toName = message.substring(message.indexOf("to") + 3, message.indexOf(" >"));
                    DataOutputStream dos = new DataOutputStream(ChatRoomServer.ListSK.get(toName).getOutputStream());
                    dos.writeUTF("(private) " + name + ": " + privateMessage);
                    continue;
                }
                for (Socket item : ChatRoomServer.ListSK.values()) {
                    if (item.getPort() != socket.getPort()) {
                        DataOutputStream dos = new DataOutputStream(item.getOutputStream());
                        dos.writeUTF(message);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}