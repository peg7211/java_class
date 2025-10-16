import java.util.Scanner;

public class AlphabetHistogramApp {
    //영어 알파벳 26자를 카운팅하는 정수형 배열.
    private int histoData[] = new int[26];

    public AlphabetHistogramApp() {
        for(int i = 0; i < histoData.length; i++) {
            histoData[i] = 0; //초기에 카운팅 값을 모두 0으로 설정.
        }
    }

    //키보드로부터 알파벳 문자를 읽고 히스토그램을 그리는 핵심 메소드.
    public void run() {
        String s = readString();
        makeHistogram(s);
        drawHistogram();
    }

    //입력받은 문자들로부터 히스토그램의 데이터를 만든다.
    private void makeHistogram(String text) {
        text = text.toUpperCase();  //스트링을 모두 대문자로 변경.

        //입력된 모든 문자를 비교하여 히스토그램 데이터를 만든다.
        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(c >= 'A' && c <= 'Z') { //알파벳 문자만 카운팅.
                int index = c - 'A';
                histoData[index]++;
            }
        }
    }

    //히스토그램을 그린다.
    private void drawHistogram() {
        System.out.println("\n히스토그램을 그립니다.");
        for(int i = 0; i < histoData.length; i++) {
            System.out.print((char)('A' + i)); //대문자 출력.

            for(int j = 0; j < histoData[i]; j++) {
                System.out.print("-"); //히스토데이터 개수만큼 -를 출력.
            }
            System.out.println();
        }
    }

    //키보드로부터 문자열을 읽어 스트링 버퍼에 저장.
    private String readString() {
        System.out.println("영문 텍스트를 입력하고 세미콜론을 입력하세요.");
        StringBuffer sb = new StringBuffer(); //키 입력을 받을 스트링 버퍼 생성.
        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine(); //텍스트 한 라인을 읽음.
            if(line.equals(";")) {
                break; //입력 끝.
            }
            sb.append(line); //읽은 라인 문자열을 스트링버퍼에 추가.
        }
        sc.close();
        return sb.toString(); //스트링 버퍼의 문자열을 스트링으로 리턴.
    }

    public static void main(String[] args) {
        AlphabetHistogramApp app = new AlphabetHistogramApp();
        app.run();
    }
}

