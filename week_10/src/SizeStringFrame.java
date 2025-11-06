import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SizeStringFrame extends JFrame {
    static final int UNIT_SIZE = 5;

    public SizeStringFrame() {
        super("마우스 휠을 굴려 문자열 크기 조절");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel label = new JLabel("Love Java");
        c.add(label);

        label.setFont(new Font("Arial", Font.PLAIN, 15));

        label.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int n = e.getWheelRotation();
                if (n < 0) {
                    JLabel la = (JLabel) e.getSource();
                    Font f = la.getFont();
                    int size = f.getSize();
                    if (size <= 5) {
                        return;
                    }
                    la.setFont(new Font("Arial", Font.PLAIN, size - UNIT_SIZE));
                }
                else {
                    JLabel la = (JLabel) e.getSource();
                    Font f = la.getFont();
                    int size = f.getSize();
                    la.setFont(new Font("Arial", Font.PLAIN, size + UNIT_SIZE));
                }
            }
        });

        setSize(250, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SizeStringFrame();
    }
}

