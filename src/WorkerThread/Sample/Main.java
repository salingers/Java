package WorkerThread.Sample;

public class Main {
    public static void main(String[] args) {
        Channel channel = new Channel(5);   // �u�H��������ƶq
        channel.startWorkers();
        new ClientThread("Alice", channel).start();
        new ClientThread("Bobby", channel).start();
        new ClientThread("Chris", channel).start();
    }
}
