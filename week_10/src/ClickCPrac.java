import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ClickCPrac extends JFrame {
    public ClickCPrac() {
        super("클릭 엽습 용 응용프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        JLabel label = new JLabel("C");
        c.add(label);

        //레이블 절대 위치 지정
        label.setLocation(100,100);
        label.setSize(20,20);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel la = (JLabel)e.getSource();
                Container c = la.getParent();

                //컨테이너의 크기 내에서 랜덤한 레이블 위치 설정
                int xBound = c.getWidth() - la.getWidth(); //레이블의 폭 만큼 감소
                int yBound = c.getHeight() - la.getHeight(); //레이블의 높이 만큼 감소
                int x = (int) (Math.random() * xBound);
                int y = (int) (Math.random() * yBound);
                la.setLocation(x, y);
            }
        });

        setSize(250,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ClickCPrac();
    }
}
