package Strategy.Sample;

public class Player {
    private String name;
    private Strategy strategy;
    private int wincount;
    private int losecount;
    private int gamecount;
    public Player(String name, Strategy strategy) {         // �o��m�W�M�Բ�
        this.name = name;
        this.strategy = strategy;
    }
    public Hand nextHand() {                                // �V�Բ��Хܤ��
        return strategy.nextHand();
    }
    public void win() {                 // �qĹ
        strategy.study(true);
        wincount++;
        gamecount++;
    }
    public void lose() {                // �q��
        strategy.study(false);
        losecount++;
        gamecount++;
    }
    public void even() {                // ����
        gamecount++;
    }
    public String toString() {
        return "[" + name + ":" + gamecount + " games, " + wincount + " win, " + losecount + " lose" + "]";
    }
}
