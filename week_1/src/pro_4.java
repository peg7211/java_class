import java.util.Scanner;

public class pro_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("자동차 상태 입력>>");
        int status = sc.nextInt();
        int temperature = status % 32;
        int aircon = status & 0b0100_0000;
        int running = status & 0b1000_0000;

        System.out.print("자동차는 ");
        if(running == 0){
            System.out.print("정지 상태이고 ");
        }
        else{
            System.out.print("달리는 상태이고 ");
        }

        if(aircon == 0){
            System.out.print("에어컨이 꺼진 상태이고 ");
        }
        else {
            System.out.print("에어컨이 켜진 상태이고 ");
        }

        System.out.print("온도는 " + temperature + "도이다.");

        sc.close();
    }
}
