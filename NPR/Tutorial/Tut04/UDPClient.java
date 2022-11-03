package NPRTutorial.Tut04;

import java.io.*;   
import java.net.*; 

public class UDPClient { 
    public static void main(String args[]) throws Exception { 
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader (System.in));   
        int port = 9876; 
        DatagramSocket clientSocket = new DatagramSocket();   
        InetAddress IPAddress = InetAddress.getByName("localhost"); 
        byte[] sendData = new byte[1024];   
        byte[] receiveData = new byte[1024]; 

        while(true) { 
            System.out.print("Please enter your message: "); 
            String sentence = inFromUser.readLine();   
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket (sendData,  sendData.length, IPAddress, port); 
            clientSocket.send(sendPacket);
            DatagramPacket receivePacket = new DatagramPacket  (receiveData, receiveData.length); 
            clientSocket.receive(receivePacket);
            String modifiedSentence = new String(receivePacket.getData()); 
            System.out.println("FROM SERVER: " + modifiedSentence); 
            //clientSocket.close();
        }
    } 
}