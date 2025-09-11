import java.util.Scanner;

public class pro_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("가위바위보 게임입니다. 가위, 바위, 보 중에서 입력하세요");
        System.out.print("철수 >> ");
        String c_rsp = sc.next();
        System.out.print("영희 >> ");
        String y_rsp = sc.next();

        if(c_rsp.equals(y_rsp)){
            System.out.println("비겼습니다.");
        }
        else if(c_rsp.equals("주먹")){
            if(y_rsp.equals("가위")){
                System.out.println("철수가 이겼습니다.");
            }
            else {
                System.out.println("영희가 이겼습니다.");
            }
        }
        else if(c_rsp.equals("가위")){
            if(y_rsp.equals("보")){
                System.out.println("철수가 이겼습니다.");
            }
            else {
                System.out.println("영희가 이겼습니다.");
            }
        }
        else if(c_rsp.equals("보")){
            if(y_rsp.equals("주먹")){
                System.out.println("철수가 이겼습니다.");
            }
            else {
                System.out.println("영희가 이겼습니다.");
            }
        }
        sc.close();
    }
}
