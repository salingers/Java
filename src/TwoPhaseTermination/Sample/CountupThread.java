package TwoPhaseTermination.Sample;

public class CountupThread extends Thread {
    // �p�ƾ�����
    private long counter = 0;

    // �w�g�e�X�פ�ШD�h��true
    private volatile boolean shutdownRequested = false;

    // �פ�ШD
    public void shutdownRequest() {
        shutdownRequested = true;
        interrupt();
    }

    // �P�_�רD�ШD�O�_�w�g�e�X
    public boolean isShutdownRequested() {
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
    private void doWork() throws InterruptedException {
        counter++;
        System.out.println("doWork: counter = " + counter);
        Thread.sleep(500);
    }

    // �פ�B�z
    private void doShutdown() {
        System.out.println("doShutdown: counter = " + counter);
    }
}
