import java.awt.*;
import java.util.Calendar;
import java.util.Scanner;

class Player {
    private Scanner scanner = new Scanner(System.in);
    String name;
    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    int elapsedTime;

    public void turn() {
        System.out.print(name + " 시작 <Enter>키>>");
        String key = scanner.nextLine();
        Calendar c = Calendar.getInstance();
        int startSecond = c.get(Calendar.SECOND);
        System.out.println("\t 현재 초 시간 = " + startSecond);

        System.out.print(name + "10초 예상 후 <Enter>키>>");
        key = scanner.nextLine();
        c = Calendar.getInstance();
        int endSecond = c.get(Calendar.SECOND);
        System.out.println("\t 현재 초 시간 = " + endSecond);

        if(endSecond < startSecond) {
            endSecond += 60;
        }

        this.elapsedTime = Math.abs(startSecond - endSecond);
    }

    @Override
    public String toString() {
        return name + "의 결과 " + elapsedTime;
    }

}

public class GuessSecondGame {
    private void decideAndPrintWinner(Player p1, Player p2) {
        int point1 = Math.abs(10 - p1.elapsedTime);
        int point2 = Math.abs(10 - p2.elapsedTime);

        String result = null;

        if(point1 < point2) {
            result = p1.getName();
        }
        else if(point1 > point2) {
            result = p2.getName();
        }
        else {
            result = "없습니다.";
        }

        System.out.println(", 승자는 " + result);
    }

    public void run() {
        Player player[] = new Player[2];
        player[0] =  new Player("황기태");
        player[1] = new Player("이재문");

        System.out.println("10초에 가까운 사람이 이기는 게임입니다.");
        for(Player p : player) {
            p.turn();
        }

        System.out.print(player[0] + " " + player[1]);

        decideAndPrintWinner(player[0], player[1]);
    }

    public static void main(String[] args) {
        GuessSecondGame game = new GuessSecondGame();
        game.run();
    }
}
