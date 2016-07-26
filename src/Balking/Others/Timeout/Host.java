package Balking.Others.Timeout;

public class Host {
    private final long timeout; // timeout值
    private boolean ready = false; // 如果可以執行方法的話則為true

    public Host(long timeout) {
        this.timeout = timeout;
    }

    // 更改狀態
    public synchronized void setExecutable(boolean on) {
        ready = on;
        notifyAll();
    }                                                           

    // 評斷狀態後執行之
    public synchronized void execute() throws InterruptedException, TimeoutException {
        long start = System.currentTimeMillis(); // 開始時刻
        while (!ready) {
            long now = System.currentTimeMillis(); // 現在時刻
            long rest = timeout - (now - start); // 剩下的等待時間
            if (rest <= 0) {
                throw new TimeoutException("now - start = " + (now - start) + ", timeout = " + timeout);
            }
            wait(rest);
        }
        doExecute();
    }

    // 實際的處理動作
    private void doExecute() {
        System.out.println(Thread.currentThread().getName() + " calls doExecute");
    }
}
