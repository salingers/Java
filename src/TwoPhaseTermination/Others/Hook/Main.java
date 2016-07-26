package TwoPhaseTermination.Others.Hook;

public class Main {
    public static void main(String[] args) {
        System.out.println("main:BEGIN");

        // �]�wshutdown hook
        Runtime.getRuntime().addShutdownHook(
            new Thread() {
                public void run() {
                    System.out.println("*****");
                    System.out.println(Thread.currentThread().getName() + ": SHUTDOWN HOOK!");
                    System.out.println("*****");
                }
            }
        );

        System.out.println("main:SLEEP...");

        // ��3���j����{��
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        System.out.println("main:EXIT");

        // �b�o�̱j���
        System.exit(0);

        // ���|�����o��
        System.out.println("main:END");
    }
}
