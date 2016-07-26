package TwoPhaseTermination.A5;

public class GracefulThread extends Thread {
    // 已經送出終止請求則為true
    private volatile boolean shutdownRequested = false;

    // 終止請求
    public final void shutdownRequest() {
        shutdownRequested = true;
        interrupt();
    }

    // 判斷終止請求是否已經送出
    public final boolean isShutdownRequested() {
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
    protected void doWork() throws InterruptedException {
    }

    // 終止處理
    protected void doShutdown() {
    }
}
