package TwoPhaseTermination.A5;

public class GracefulThread extends Thread {
    // �w�g�e�X�פ�ШD�h��true
    private volatile boolean shutdownRequested = false;

    // �פ�ШD
    public final void shutdownRequest() {
        shutdownRequested = true;
        interrupt();
    }

    // �P�_�פ�ШD�O�_�w�g�e�X
    public final boolean isShutdownRequested() {
        return shutdownRequested;
    }

    // �ʧ@
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

    // �@�~
    protected void doWork() throws InterruptedException {
    }

    // �פ�B�z
    protected void doShutdown() {
    }
}
