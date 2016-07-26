package ProducerConsumer.A8;

public class Table {
    private final String[] buffer;
    private int tail;  // 下一個put的地方
    private int head;  // 下一個take的地方
    private int count; // buffer內的蛋糕數
    public Table(int count) {
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }
    // 放置蛋糕
    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        while (count >= buffer.length) {
            wait();
        }
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        notify();
    }
    // 取得蛋糕
    public synchronized String take() throws InterruptedException {
        while (count <= 0) {
            wait();
        }
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notify();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }
}
