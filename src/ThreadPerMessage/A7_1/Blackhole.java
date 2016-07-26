package ThreadPerMessage.A7_1;

public class Blackhole {
    public static void enter(Object obj) {
        System.out.println("Step 1");
        magic(obj);
        System.out.println("Step 2");
        synchronized (obj) {
            System.out.println("Step 3 (never reached here)");  // 不會到這裡來
        }
    }
    public static void magic(final Object obj) {
        // thread會取得obj的lock，變成無窮迴圈的執行緒
        // 將thread的名稱當作Guard條件來使用
        Thread thread = new Thread() {      // inner class
            public void run() {
                synchronized (obj) { // 在此取得obj的鎖定
                    synchronized (this) {
                        this.setName("Locked"); // Guard條件的變化
                        this.notifyAll();       // 通知已經取得obj的鎖定
                    }
                    while (true) {
                        // 無窮迴圈
                    }
                }
            }
        };
        synchronized (thread) {
            thread.setName("");
            thread.start(); // 執行緒的啟動
            // Guarded Suspension模式
            while (thread.getName().equals("")) {
                try {
                    thread.wait(); // 等待新的執行緒取得obj的鎖定
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
