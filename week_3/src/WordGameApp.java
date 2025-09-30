import java.util.Scanner;

public class WordGameApp {
    private Scanner scanner;
    private String startword = "아버지";
    private Player[] players;

    public WordGameApp() {
        scanner = new Scanner(System.in);
    }

    // 게임 참가자 수를 입력받고 Player []를 생성하는 메소드
    public void createPlayers() {
        System.out.print("게임에 참가하는 인원은 몇 명입니까>>");
        int nPlayers = scanner.nextInt();
        players = new Player[nPlayers];

        //각 참여자의 이름을 입력받아 Player 객체 생성
        for(int i = 0; i < nPlayers; i++) {
            System.out.print("참가자의 이름을 입력하세요>>");
            String name = scanner.next();
            players[i] = new Player(name);
        }
    }

    // 게임을 진행하는 메소드
    public void run() {
        System.out.println("끝말잇기 게임을 시작합니다...");
        createPlayers(); //참가자를 위한 Player[]를 생성.
        String lastword = startword; //startword에서 부터 시작.

        System.out.println("시작하는 단어는 " + lastword + "입니다");
        int next = 0; //참가자들 순서대로 증가.

        //게임이 끝날 때까지 루프
        while(true) {
            String newWord = players[next].getWordFromUser();
            if(!players[next].checkSuccess(lastword)) {
                System.out.print(players[next].getName() + "이 졌습니다.");
                break;
            }

            next++;
            next %= players.length;
            lastword = newWord;
        }
        scanner.close();
    }


    public static void main(String[] args) {
        WordGameApp game = new WordGameApp();
        game.run();
    }
}

class Player {
    private Scanner scanner;
    private String name;
    private String word;

    public Player(String name) {
        this.name = name;
        scanner = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public String getWordFromUser() {
        System.out.print(name + ">>");
        word = scanner.next();
        return word;
    }

    //lastWord와 참가자가 말한 word를 비교하여 끝말잇기가 잘 되었는지 판단.
    //성공하였으면 true 리턴.
    public boolean checkSuccess(String lastword) {
        int lastIndex = lastword.length() - 1; //최종 단어의 맨 마지막 문자의 인덱스

        // 최종 단어의 맨 마지막 문자와 참가자가 말한 단어의 첫 문자가 같은지 비교
        if(lastword.charAt(lastIndex) == word.charAt(0)) {
            return true;
        }
        else {
            return false;
        }
    }
}


