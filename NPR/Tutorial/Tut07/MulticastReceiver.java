package NPRTutorial.Tut07;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.MembershipKey;

public class MulticastReceiver {
    private static final String MULTICAST_INTERFACE = "en0";
    private static final int MULTICAST_PORT = 4321;
    private static final String MULTICAST_IP = "230.0.0.0";
    private String receiveMessage(String ip, String iface, int port) throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open(StandardProtocolFamily.INET); 
        NetworkInterface networkInterface = NetworkInterface.getByName(iface); 
        datagramChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true); 
        datagramChannel.bind(new InetSocketAddress(port)); 
        datagramChannel.setOption(StandardSocketOptions.IP_MULTICAST_IF, networkInterface); 
        InetAddress inetAddress = InetAddress.getByName(ip); 
        MembershipKey membershipKey = datagramChannel.join(inetAddress, networkInterface); 
        System.out.println("Waiting for the message..."); 
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024); 
        datagramChannel.receive(byteBuffer); 
        byteBuffer.flip();
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes, 0, byteBuffer.limit());
        membershipKey.drop();
        return new String(bytes);
    }

    public static void main(String[] args) throws IOException { 
        int n = 1; 
        while(true) { 
            MulticastReceiver mr = new MulticastReceiver(); 
            System.out.println("Message received: " + n + " " + mr.receiveMessage(MULTICAST_IP,MULTICAST_INTERFACE, MULTICAST_PORT)); 
            n++; 
        }
    }
}