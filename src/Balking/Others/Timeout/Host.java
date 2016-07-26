package Balking.Others.Timeout;

public class Host {
    private final long timeout; // timeout��
    private boolean ready = false; // �p�G�i�H�����k���ܫh��true

    public Host(long timeout) {
        this.timeout = timeout;
    }

    // ��窱�A
    public synchronized void setExecutable(boolean on) {
        ready = on;
        notifyAll();
    }                                                           

    // ���_���A����椧
    public synchronized void execute() throws InterruptedException, TimeoutException {
        long start = System.currentTimeMillis(); // �}�l�ɨ�
        while (!ready) {
            long now = System.currentTimeMillis(); // �{�b�ɨ�
            long rest = timeout - (now - start); // �ѤU�����ݮɶ�
            if (rest <= 0) {
                throw new TimeoutException("now - start = " + (now - start) + ", timeout = " + timeout);
            }
            wait(rest);
        }
        doExecute();
    }

    // ��ڪ��B�z�ʧ@
    private void doExecute() {
        System.out.println(Thread.currentThread().getName() + " calls doExecute");
    }
}
