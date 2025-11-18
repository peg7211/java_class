import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAndImageLabelFrame extends JFrame {
    private JLabel imageLabel;
    private ImageIcon[] images = new ImageIcon[4];
    int currentImageIdx;

    public ButtonAndImageLabelFrame() {
        setTitle("Problem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane(); //컨텐트팬 얻기
        c.setLayout(new BorderLayout()); //컨텐트팬에 BorderLayout 설정

        //이미지 파일 로딩
        //프로젝트의 images 폴터의 images0.jpg, image1.jpg, image2.jpg, image3.jpg
        for(int i = 0; i < images.length; i++){
            images[i] = getScaledImage("./images/image" + i + ".jpg");
        }

        currentImageIdx = 0; //현재 선택된 이미지 번호
        imageLabel = new JLabel(images[currentImageIdx]); // 현재 선택된 이미지를 레이블이 출력
        c.add(imageLabel, BorderLayout.CENTER); //이미지 레이블을 CENTER에 부착
        c.add(new MenuPanel(), BorderLayout.SOUTH); //2개의 화살표 버튼을 가진 MenuPanel 부착

        setSize(300, 400);
        setVisible(true);
    }

    private ImageIcon getScaledImage(String imagePath){
        Image scaledImage = new ImageIcon(imagePath).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    class MenuPanel extends JPanel{
        public MenuPanel() {
            setBackground(Color.GRAY);
            ImageIcon leftIcon = new ImageIcon("./images/left.png"); //왼쪽 화살표 이미지 로딩
            ImageIcon rightIcon = new ImageIcon("./images/right.png"); //오른쪽 화살표 이미지 로딩
            JButton leftBtn = new JButton(leftIcon); //왼쪽 버튼 생성
            JButton rightBtn = new JButton(rightIcon); //오른쪽 버튼 생성

            add(leftBtn);
            add(rightBtn);

            //왼쪽 화살표 버튼에 Action 리스너 달기
            leftBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentImageIdx++; //이미지 번호 증가. 다음 이미지
                    currentImageIdx %= images.length; //4가 넘는 것을 막기 위해 이미지 개수로 나머지 구함
                    imageLabel.setIcon(images[currentImageIdx]); //이미지 레이블에 이미지 변경
                }
            });

            //오른쪽 화살표 버튼에 Action 리스너 달기
            rightBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentImageIdx++; //이미지 번호 증가. 다음 이미지
                    currentImageIdx %= images.length; //4가 넘는 것을 막기 위해 이미지 개수로 나머지 구함
                    imageLabel.setIcon(images[currentImageIdx]); //이미지 레이블에 이미지 변경
                }
            });
        }
    }

    public static void main(String[] args) {
        ButtonAndImageLabelFrame frame = new ButtonAndImageLabelFrame();
    }
}
