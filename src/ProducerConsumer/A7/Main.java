package ProducerConsumer.A7;

public class Main {
    public static void main(String[] args) {
        // ����Host���j���B�z�������
        Thread executor = new Thread() {
            public void run() {
                System.out.println("Host.execute BEGIN");
                try {
                    Host.execute(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Host.execute END");
            }
        };

        // �Ұ�
        executor.start();

        // �𮧬�15��
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
        }

        // �������
        System.out.println("***** interrupt *****");
        executor.interrupt();
    }
}
