import java.net.*;

public class Test {
    public static void main(String[] args) {
        try {
            URI uri = new URI("https://nptel.ac.in/");
            URL url = uri.toURL();
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
