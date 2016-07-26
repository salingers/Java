package TwoPhaseTermination.Others.Hook;

public class Main {
    public static void main(String[] args) {
        System.out.println("main:BEGIN");

        // 設定shutdown hook
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

        // 約3秒後強制結束程式
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        System.out.println("main:EXIT");

        // 在這裡強制結束
        System.exit(0);

        // 不會執行到這裡
        System.out.println("main:END");
    }
}
