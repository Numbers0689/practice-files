import java.net.*;

public class send {
    public static void main(String[] args) throws Exception {
        String multicastAddress = "224.0.0.1";
        int port = 5000;

        MulticastSocket sender = new MulticastSocket();
        InetAddress group = InetAddress.getByName(multicastAddress);

        String message = "Hello, Multicast from Sender!";
        DatagramPacket packet = new DatagramPacket(
                message.getBytes(),
                message.length(),
                group,
                port
        );

        sender.send(packet);
        System.out.println("Message sent: " + message);

        sender.close();
    }
}
