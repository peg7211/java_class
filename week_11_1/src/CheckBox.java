import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CheckBox extends JFrame {
    private JButton countBtn = new JButton("test button");
    private JLabel countLabel = new JLabel("0");
    private int counter = 0;

    public CheckBox() {
        super("CheckBox Practice Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JCheckBox deactivateBtn = new JCheckBox("버튼 비활성화");
        JCheckBox hideBtn = new JCheckBox("버튼 감추기");
        c.add(deactivateBtn);
        c.add(hideBtn);
        c.add(countBtn);
        c.add(countLabel);

        deactivateBtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    countBtn.setEnabled(false);
                }
                else {
                    countBtn.setEnabled(true);
                }
            }
        });

        hideBtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    countBtn.setVisible(false);
                }
                else {
                    countBtn.setVisible(true);
                }
            }
        });

        countBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                countLabel.setText(Integer.toString(counter));
            }
        });

        setSize(250, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckBox();
    }
}
