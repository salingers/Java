package TwoPhaseTermination.A5;

public class ServiceThread extends GracefulThread {
    private int count = 0;

    // ���椤
    protected void doWork() throws InterruptedException {
        System.out.print(".");
        Thread.sleep(100);
        count++;
        if (count >= 50) {
            shutdownRequest();  // �ۤv����
        }
    }

    // �����B�z
    protected void doShutdown() {
        System.out.println("done.");
    }
}
