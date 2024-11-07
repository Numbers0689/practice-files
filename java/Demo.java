import javax.swing.*;
import java.awt.*;

public class Demo extends JFrame{
    public Demo () {
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        g.fillOval(100, 100, 100, 100);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Demo f = new Demo();
            f.setVisible(true);
        });
    }
}
