package Introduction1.A4;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("A Bad Bank", 1000);   // �إ�1000�����Ȧ�b���
        new ClientThread(bank).start();
        new ClientThread(bank).start();
    }
}
