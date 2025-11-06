import javax.swing.*;
import java.awt.*;

class SouthPanel extends JPanel {
    public SouthPanel() {
        setBackground(Color.YELLOW);
        setOpaque(true);
        setLayout(new FlowLayout());
        add(new JLabel("계산 결과"));
        add(new JTextField(15));
    }
}

class CenterPanel extends JPanel {
    JButton b[] = {new JButton("+"), new JButton("-"), new JButton("X"), new JButton("/")};

    public CenterPanel() {
        setBackground(Color.WHITE);
        setLayout(new GridLayout(4,4,5,5));

        for(int i = 0; i < 10; i ++) {
            JButton b = new JButton(Integer.toString(i));
            add(b);
        }
        add(new JButton("CE"));
        add(new JButton("계산"));

        for(int i = 0; i < b.length; i ++) {
            b[i].setBackground(Color.CYAN);
            add(b[i]);
        }
    }
}

class NorthPanel extends JPanel {
    public NorthPanel() {
        setBackground(Color.LIGHT_GRAY);
        setOpaque(true);
        setLayout(new FlowLayout());
        add(new JLabel("수식입력"));
        add(new JTextField(16));
    }
}



public class CalFrame extends JFrame {
    public CalFrame() {
        super("계산기 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();

        c.add(new SouthPanel(),BorderLayout.SOUTH);
        c.add(new CenterPanel(), BorderLayout.CENTER);
        c.add(new NorthPanel(), BorderLayout.NORTH);

        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CalFrame();
    }
}
