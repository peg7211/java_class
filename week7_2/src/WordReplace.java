import java.util.Scanner;

public class WordReplace {
    private static final int EXPECTED_TOKEN_NUM = 2;

    public static void main(String[] args) {
        System.out.print(">>");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuffer sb = new StringBuffer(text);

        while(true) {
            System.out.print("명령: ");
            String cmd = scanner.nextLine();

            if(cmd.equals("그만")){
                System.out.println("종료합니다...");
                break;
            }

            String [] tokens = cmd.split("!");
            if(EXPECTED_TOKEN_NUM != tokens.length){
                System.out.println("잘못된 명령입니다!");
            }
            else {
                if(0 == tokens[0].length() || 0 == tokens[1].length()){
                    System.out.println("잘못된 명령입니다!");
                    continue;
                }

                int index = sb.indexOf(tokens[0]);

                if(index == -1){
                    System.out.println("찾을 수 없습니다!");
                    continue;
                }
                sb.replace(index, index+tokens[0].length(), tokens[1]);
                System.out.println(sb.toString());
            }
        }
        scanner.close();
    }
}
