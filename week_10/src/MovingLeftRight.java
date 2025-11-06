import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MovingLeftRight extends JFrame {
    static final int ROTATION_COUNT = 1;

    public MovingLeftRight() {
        super("Left/Right 키로 문자열 이동");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel label = new JLabel("Love Java");
        c.add(label);

        label.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                JLabel la = (JLabel) e.getSource();
                String text = la.getText();

                if(KeyEvent.VK_LEFT == e.getKeyCode()) {
                    int targetIdx = ROTATION_COUNT;
                    String front = text.substring(0,targetIdx);
                    String remain = text.substring(targetIdx);
                    la.setText(remain + front);
                }
                if(KeyEvent.VK_RIGHT == e.getKeyCode()) {
                    int targetIdx = text.length() - ROTATION_COUNT;
                    String front = text.substring(0,targetIdx);
                    String remain = text.substring(targetIdx);
                    la.setText(remain + front);
                }
            }
        });

        setSize(250, 100);
        setVisible(true);

        label.setFocusable(true);
        label.requestFocus();
    }

    public static void main(String[] args) {
        new MovingLeftRight();
    }
}
