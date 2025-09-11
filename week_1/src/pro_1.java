import java.util.Scanner;

public class pro_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("2자리수 정수 입력(10~99)>> ");

        int num = sc.nextInt();
        if(num < 10 || num > 99) {
            System.out.println("10~99 사이의 정수만 입력하세요.");
            sc.close();
            return;
        }

        int ten = num / 10;
        int one = num % 10;

        if(ten == one){
            System.out.println("Yes! 10의 자리와 1의 자리가 같습니다.");
        }
        else {
            System.out.println("No! 10의 자리와 1의 자리가 다릅니다.");
        }

        sc.close();
    }
}
