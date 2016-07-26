package TwoPhaseTermination.Sample;

public class CountupThread extends Thread {
    // 計數器的值
    private long counter = 0;

    // 已經送出終止請求則為true
    private volatile boolean shutdownRequested = false;

    // 終止請求
    public void shutdownRequest() {
        shutdownRequested = true;
        interrupt();
    }

    // 判斷終求請求是否已經送出
    public boolean isShutdownRequested() {
        return shutdownRequested;
    }

    // 動作
    public final void run() {
        try {
            while (!shutdownRequested) {
                doWork();
            }
        } catch (InterruptedException e) {
        } finally {
            doShutdown();
        }
    }

    // 作業
    private void doWork() throws InterruptedException {
        counter++;
        System.out.println("doWork: counter = " + counter);
        Thread.sleep(500);
    }

    // 終止處理
    private void doShutdown() {
        System.out.println("doShutdown: counter = " + counter);
    }
}
