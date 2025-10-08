class Player {
    private int hp;

    Player() {
        hp = 500;
    }

    public void setHp(int hp) {
        if(hp < 0) {
            this.hp = 0;
        }
        else {
            this.hp = hp;
        }
    }

    public int getHp() {
        return hp;
    }
}


public class Pro_1 {
    public static void main(String[] args) {
        Player p = new Player();
        System.out.println("초기 HP: " + p.getHp());
        p.setHp(-1000);
        System.out.println("변경 후 HP: " + p.getHp());
    }
}
