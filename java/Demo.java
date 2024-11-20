import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Demo extends JFrame{
    private JTextField tf;
    public Demo () {
        setSize(900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tf = new JTextField();
        add(tf, BorderLayout.NORTH);
        String[] bs = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 4));
        for (String s : bs) {
            JButton b = new JButton(s);
            b.addActionListener(e -> handle(e));
            p.add(b);
        }
        add(p);
    }

    private double eval(String e) {
        try {
            return Double.parseDouble(new javax.script.ScriptEngineManager().getEngineByName("JavaScript").eval(e).toString());
        } catch (Exception ex) {
            return 0;
        }
    }

    public void handle(ActionEvent e) {
        String c = e.getActionCommand();
        if (c.equals("=")) {
            tf.setText(String.valueOf(eval(tf.getText())));
        } else {
            tf.setText(tf.getText() + c);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Demo f = new Demo();
            f.setVisible(true);
        });
    }
}
