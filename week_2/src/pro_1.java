import java.util.*;

public class pro_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1};

        System.out.print("금액을 입력하시요>>");
        int price = sc.nextInt();

        for(int i=0;i<unit.length;i++) {
            int tmp = price / unit[i];

            if(tmp > 0) {
                System.out.println(unit[i] + "원 짜리 : " + tmp + "개");
                price = price  % unit[i];
            }
        }
        sc.close();
    }
}
