package Introduction1.Others.Sync;

public class Bank {
    private int money;
    private String name;

    public Bank(String name, int money) {
        this.name = name;
        this.money = money;
    }

    // ¦s´Ú
    public synchronized void deposit(int m) {
        money += m;
    }

    // »â´Ú
    public synchronized boolean withdraw(int m) {
        if (money >= m) {
            money -= m;
            return true;    // ¤w»â´Ú
        } else {
            return false;   // ¾lÃB¤£¨¬
        }
    }

    public String getName() {
        return name;
    }
}
