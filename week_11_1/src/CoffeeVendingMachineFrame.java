import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoffeeVendingMachineFrame extends JFrame {
    private CoffeeMachinePanel coffeeMachinePanel = new CoffeeMachinePanel();

    public CoffeeVendingMachineFrame() {
        setTitle("Coffee Vending Machine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c =  getContentPane();

        c.add(new TitlePanel(), BorderLayout.NORTH);
        c.add(coffeeMachinePanel, BorderLayout.CENTER);
        c.add(new ButtonPanel(), BorderLayout.SOUTH);

        setSize(450, 400);
        setResizable(false);
        setVisible(true);
    }

    class TitlePanel extends JPanel {
        private JLabel titleMsg = new JLabel("Welcome, Hot Coffee !!");

        public TitlePanel() {
            titleMsg.setHorizontalAlignment(JLabel.CENTER);
            setBackground(Color.DARK_GRAY);
            titleMsg.setForeground(Color.WHITE);
            add(titleMsg);
        }
    }

    class ButtonPanel extends JPanel {
        private JButton[] coffeeButtons = new JButton[4];
        private String[] names = {"Americano", "Latte", "Vanilla Latte", "Reset"};

        public ButtonPanel() {
            for(int i =0; i < coffeeButtons.length; i++) {
                coffeeButtons[i] = new JButton(names[i]);
                add(coffeeButtons[i]);

                coffeeButtons[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String selectedOperation = e.getActionCommand();
                        coffeeMachinePanel.operate(selectedOperation);
                    }
                });
            }
        }
    }

    class CoffeeMachinePanel extends JPanel {
        private JProgressBar[] boxes = new JProgressBar[5];
        private JLabel coffeeImageLabel;

        private final int CUP = 0;
        private final int COFFEE = 1;
        private final int WATER = 2;
        private final int MILK = 3;
        private final int VANILLA_SYRUP = 4;

        private String[] boxNames = {"Cup", "Coffee", "Water", "Milk", "Vanilla Syrup"};

        private ImageIcon coffeeIcon = new ImageIcon("images/coffee.png");
        public CoffeeMachinePanel() {
            setLayout(null);

            for(int i =0; i < boxes.length; i++) {
                boxes[i] = new JProgressBar(0, 10);
                boxes[i].setValue(10);
                boxes[i].setStringPainted(true);
                boxes[i].setLocation(30+80*i, 10);
                boxes[i].setSize(60, 100);

                JLabel text = new JLabel(boxNames[i]);
                text.setLocation(30+80*i, 120);
                text.setSize(80, 30);

                add(boxes[i]);
                add(text);
            }

            coffeeImageLabel = new JLabel();
            coffeeImageLabel.setLocation(180, 200);
            coffeeImageLabel.setSize(coffeeIcon.getIconWidth(), coffeeIcon.getIconHeight());

            add(coffeeImageLabel);
        }

        public void operate(String cmd) {
            int[] resources = null;

            if(cmd.equals("Americano")) {
                resources = new int[] {CUP, COFFEE, WATER};
            }
            else if(cmd.equals("Latte")) {
                resources = new int[] {CUP,COFFEE, WATER, MILK};
            }
            else if(cmd.equals("Vanilla Latte")) {
                resources = new int[] {CUP, COFFEE, WATER, MILK, VANILLA_SYRUP};
            }
            else if(cmd.equals("Reset")) {
                resetResources();
                coffeeImageLabel.setIcon(null);
                return;
            }
            else {
                printError("Unknown command: " + cmd);
                return;
            }

            if(isAnyResourceEmpty(resources)) {
                printError("Not enough ingredients. Please refill.");
                return;
            }
            consumeResources(resources);

            coffeeImageLabel.setIcon(coffeeIcon);

            JOptionPane.showMessageDialog(CoffeeMachinePanel.this, "Enjoy your coffee!", "Coffee Ready", JOptionPane.INFORMATION_MESSAGE);

            coffeeImageLabel.setIcon(null);
        }

        private boolean isAnyResourceEmpty(int[] resources) {
            for(int resource : resources) {
                if(boxes[resource].getValue() == 0) {
                    return true;
                }
            }
            return false;
        }

        private void consumeResources(int[] resources) {
            for(int resource: resources) {
                boxes[resource].setValue(boxes[resource].getValue() - 1);
            }
        }

        private void resetResources() {
            for(JProgressBar box : boxes) {
                box.setValue(10);
            }
        }

        public void printError(String msg) {
            JOptionPane.showMessageDialog(CoffeeMachinePanel.this, msg, "Coffee Vending Machine Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new CoffeeVendingMachineFrame();
    }
}
