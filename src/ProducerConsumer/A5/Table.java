package ProducerConsumer.A5;

public class Table {
    private final String[] buffer;
    private int tail;  // �U�@��put���a��
    private int head;  // �U�@��take���a��
    private int count; // buffer�����J�|��
    public Table(int count) {
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }
    public synchronized void clear()  {
        // while���z�y�Ψ���ܲM���M�S�M�����J�|
        while (count > 0) {
            String cake = buffer[head];
            System.out.println(Thread.currentThread().getName() + " clears " + cake);
            head = (head + 1) % buffer.length;
            count--;
        }
        head = 0;
        tail = 0;
        count = 0;
        notifyAll();
    }
    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        while (count >= buffer.length) {
            wait();
        }
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        notifyAll();
    }
    public synchronized String take() throws InterruptedException {
        while (count <= 0) {
            wait();
        }
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }
}
