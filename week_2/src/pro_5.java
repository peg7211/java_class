import java.util.Scanner;

public class pro_5 {
    public static boolean isValidChoice(String userChoice) {
        if(userChoice.equals("가위") || userChoice.equals("바위") || userChoice.equals("보")|| userChoice.equals("그만")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String []choice = {"가위", "바위", "보"};

        Scanner sc = new Scanner(System.in);
        System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");

        while(true){
            System.out.print("가위 바위 보!>>");
            String userChoice = sc.nextLine();

            if(false ==  isValidChoice(userChoice)) {
                System.out.println("다시 하세요.");
                continue;
            }
            if(userChoice.equals("그만")) {
                System.out.println("게임을 종료합니다...");
                break;
            }

            int n = (int)(Math.random()*3);
            String computerChoice = choice[n];

            System.out.print("사용자 = " + userChoice + ", 컴퓨터 = " + computerChoice + ", ");

            if(userChoice.equals(computerChoice)) {
                System.out.println("비겼습니다.");
            }
            else if((userChoice.equals("가위")) && (computerChoice.equals("보"))
                    || (userChoice.equals("바위")) && (computerChoice.equals("가위"))
                    || (userChoice.equals("보")) && (computerChoice.equals("바위"))){
                System.out.println("사용자가 이겼습니다!");
            }
            else {
                System.out.println("컴퓨터가 이겼습니다! ");
            }
        }
        sc.close();
    }
}
