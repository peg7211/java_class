import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyPanel extends JPanel {
    private int[] unit = {50000, 10000, 1000, 500, 100, 50, 10};
    private String[] text = {"오만원", "만원", "천원", "500원", "100원", "50원", "10원", "1원"};
    private JTextField source;
    private JTextField[] textField = new JTextField[8];
    private JCheckBox[] checkBox = new JCheckBox[7];
    private final int LastTextFieldIdx = 7;

    public MyPanel() {
        setBackground(Color.PINK);
        setLayout(null);

        //금액 레이블
        JLabel la = new JLabel("금액");
        la.setHorizontalAlignment(JLabel.RIGHT);
        la.setSize(50, 20);
        la.setLocation(20, 20);
        add(la);

        //금액을 입력하는 JTextField
        source = new JTextField(30);
        source.setSize(100, 20);
        source.setLocation(100, 20);
        add(source);

        //계산 버튼
        JButton calcBtn = new JButton("계산");
        calcBtn.setSize(70, 20);
        calcBtn.setLocation(210, 20);
        add(calcBtn);

        //계산된 액수별 돈의 개수
        for(int i = 0; i < text.length; i++) {
            la = new JLabel(text[i]);
            la.setHorizontalAlignment(JLabel.RIGHT);
            la.setSize(50, 20);
            la.setLocation(50, 50 + i * 20);
            add(la);
            textField[i] = new JTextField(30);
            textField[i].setHorizontalAlignment(JTextField.CENTER);
            textField[i].setSize(70, 20);
            textField[i].setLocation(120, 50 + i * 20);

            add(textField[i]);
        }

        //체크 박스
        for(int i = 0; i < checkBox.length; i++) {
            checkBox[i] = new JCheckBox("", true); //초기화 모두 선택된 상태로 생성
            checkBox[i].setOpaque(false); //체크박스의 배경을 투명하게 설정
            checkBox[i].setHorizontalAlignment(JCheckBox.CENTER);
            checkBox[i].setSize(30, 20);
            checkBox[i].setLocation(200, 50 + i * 20);

            add(checkBox[i]);
        }

        //계산 버튼의 Action 리스너
        calcBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strMoney = source.getText(); //입력한 금액 문자열
                if(strMoney.length() == 0) {
                    return; //입력된 금액이 없음.
                }

                int money = Integer.parseInt(strMoney); //입력된 금액을 정수로 변환.
                int res;
                for(int i =0; i< unit.length; i++) {
                    if(!checkBox[i].isSelected()) {
                        textField[i].setText("0");
                        continue;
                    }
                    res = money /  unit[i]; // unit[i]의 개수 계산
                    textField[i].setText(Integer.toString(res));

                    if(res > 0) {
                        money = money % unit[i]; //money 갱신
                    }
                }

                textField[LastTextFieldIdx].setText(Integer.toString(money));
            }
        });
    }
}

public class MoneyChanger extends JFrame {
    public MoneyChanger() {
        setTitle("Money Changer with CheckBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());

        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MoneyChanger();
    }
}