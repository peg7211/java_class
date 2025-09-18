import java.util.InputMismatchException;
import java.util.Scanner;

public class pro_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("곱하고자 하는 두 수 입력>>");

            try {
                int input1 = sc.nextInt();
                int input2 = sc.nextInt();
                System.out.println(input1 + "x" +  input2 + "="+ input1*input2);
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("실수는 입력하면 안됩니다.");
                sc.nextLine();
                continue;
            }
        } while(true);

        sc.close();
    }
}
