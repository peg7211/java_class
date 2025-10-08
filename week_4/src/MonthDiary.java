import java.util.Scanner;

class DayDiary{
    private String text;

    public DayDiary(String text){
        this.text = text;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return (text == null) ? "..." : text;
    }
}

public class MonthDiary {
    private Scanner scanner = new Scanner(System.in);
    private int year;
    private int month;
    private DayDiary monthDiary[] = new DayDiary[30];

    public MonthDiary(int year,int month){
        this.year = year;
        this.month = month;

        for(int i = 0; i < monthDiary.length; i++){
            monthDiary[i] = new DayDiary(null);
        }
    }

    private void write() {
        System.out.print("날짜(1~30)와 텍스트(빈칸없이 4글자이하)>>");
        int day = scanner.nextInt();
        String text = scanner.next();

        if(text.length() > 4) {
            System.out.println("입력 오류! 텍스트는 4글자 이하만 가능합니다.");
            return;
        }

        monthDiary[day - 1].setText(text);
    }

    public void show() {
        for(int i = 0; i < monthDiary.length; i++){
            DayDiary dayDiary = monthDiary[i];
            String text = dayDiary.getText();
            System.out.print(text + "\t ");

            if(((i + 1) % 7) == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private int getMenu() {
        System.out.print("기록:1, 보기:2, 종료:3>>");
        int menu = scanner.nextInt();
        return menu;
    }

    public void run() {
        System.out.println("***** " + year + "년 " + month + "월 다이어리 *****");
        while(true) {
            int menu = getMenu();
            switch (menu) {
                case 1:
                    write();
                    break;

                case 2:
                    show();
                    break;

                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    return;
            }
        }
    }

    public static void main(String[] args) {
        MonthDiary monthDiary = new MonthDiary(2025, 10);
        monthDiary.run();
    }
}


