package ThreadPerMessage.A7_1;

public class Blackhole {
    public static void enter(Object obj) {
        System.out.println("Step 1");
        magic(obj);
        System.out.println("Step 2");
        synchronized (obj) {
            System.out.println("Step 3 (never reached here)");  // ���|��o�̨�
        }
    }
    public static void magic(final Object obj) {
        // thread�|���oobj��lock�A�ܦ��L�a�j�骺�����
        // �Nthread���W�ٷ�@Guard����Өϥ�
        Thread thread = new Thread() {      // inner class
            public void run() {
                synchronized (obj) { // �b�����oobj����w
                    synchronized (this) {
                        this.setName("Locked"); // Guard�����ܤ�
                        this.notifyAll();       // �q���w�g���oobj����w
                    }
                    while (true) {
                        // �L�a�j��
                    }
                }
            }
        };
        synchronized (thread) {
            thread.setName("");
            thread.start(); // ��������Ұ�
            // Guarded Suspension�Ҧ�
            while (thread.getName().equals("")) {
                try {
                    thread.wait(); // ���ݷs����������oobj����w
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
