import java.util.Scanner;

public class pro_3 {
    public static boolean checkDuplication(int []arr, int size, int m) {
        for(int i = 0; i < size; i++) {
            if(arr[i] == m) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 몇 개 저장하시겠습니까>>");
        int n = sc.nextInt();
        int sum = 0;

        int []arr = new int[n];

        for(int i=0;i<arr.length;i++) {
            while(true) {
                int m = (int)(Math.random() * 101);

                boolean isDup = checkDuplication(arr, i, m);
                if(!isDup) {
                    arr[i] = m;
                    break;
                }
            }
        }

        System.out.print("랜덤한 정수를 ...");
        for(int k:arr) {
            System.out.print(k + " ");
            sum += k;
        }
        System.out.println("\n평균은 " + ((double) sum / arr.length));

        sc.close();
    }
}
