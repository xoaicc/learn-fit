package NPRTutorial.Tut04;

import java.io.*;   
import java.net.*; 

class UDPEchoServer { 
    public static void main(String args[]) throws Exception {   
        int port = 9876; 
        DatagramSocket serverSocket = new DatagramSocket(port);
        byte[] receiveData = new byte[1024];
        byte[] sendData	= new byte[1024];

        while(true) { 
            DatagramPacket receivePacket = new DatagramPacket (receiveData, receiveData.length); 
            serverSocket.receive(receivePacket); 
            String sentence = new String(receivePacket.getData());   
            InetAddress IPAddress = receivePacket.getAddress(); 
            int clientPort = receivePacket.getPort(); 
            String capitalizedSentence = sentence.toUpperCase();   
            sendData = capitalizedSentence.getBytes(); 
            DatagramPacket sendPacket = new DatagramPacket (sendData, sendData.length, IPAddress, clientPort); 
            serverSocket.send(sendPacket); 
        } 
    }
}