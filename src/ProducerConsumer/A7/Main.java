package ProducerConsumer.A7;

public class Main {
    public static void main(String[] args) {
        // 執行Host的大型處理的執行緒
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

        // 啟動
        executor.start();

        // 休息約15秒
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
        }

        // 執行取消
        System.out.println("***** interrupt *****");
        executor.interrupt();
    }
}
