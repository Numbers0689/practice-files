import java.net.*;

public class rec {
    public static void main(String[] args) throws Exception {
        String multicastAddress = "224.0.0.1";
        int port = 5000;

        MulticastSocket socket = new MulticastSocket(port);

        InetAddress group = InetAddress.getByName(multicastAddress);
        NetworkInterface networkInterface = NetworkInterface.getByName("wlam0"); 

        socket.joinGroup(new InetSocketAddress(group, port), networkInterface);

        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        System.out.println("Waiting for multicast message...");
        socket.receive(packet);

        String message = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Message received: " + message);

        socket.leaveGroup(new InetSocketAddress(group, port), networkInterface);

        socket.close();
    }
}
