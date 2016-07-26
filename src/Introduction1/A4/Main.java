package Introduction1.A4;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("A Bad Bank", 1000);   // «Ø¥ß1000¤¸ªº»È¦æ±b¤á‚é
        new ClientThread(bank).start();
        new ClientThread(bank).start();
    }
}
