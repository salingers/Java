package Introduction1.Others.Sync;

public class Bank {
    private int money;
    private String name;

    public Bank(String name, int money) {
        this.name = name;
        this.money = money;
    }

    // �s��
    public synchronized void deposit(int m) {
        money += m;
    }

    // ���
    public synchronized boolean withdraw(int m) {
        if (money >= m) {
            money -= m;
            return true;    // �w���
        } else {
            return false;   // �l�B����
        }
    }

    public String getName() {
        return name;
    }
}
