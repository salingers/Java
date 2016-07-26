package ThreadSpecificStorage.A3;

public class Log {
    private static final ThreadLocal tsLogCollection = new ThreadLocal();

    // 寫log
    public static void println(String s) {
        getTSLog().println(s);
    }

    // 關閉log
    public static void close() {
        getTSLog().close();
    }

    // 獲得執行緒固有的log
    private static TSLog getTSLog() {
        TSLog tsLog = (TSLog)tsLogCollection.get();

        // 如果該執行緒是第一次呼叫，就重建登錄
        if (tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
            startWatcher(tsLog);
        }

        return tsLog;
    }

    // 啟動等待執行緒結束的執行緒
    private static void startWatcher(final TSLog tsLog) {
        // 被監視的執行緒
        final Thread target = Thread.currentThread();
        // 進行監視的執行緒
        final Thread watcher = new Thread() {
            public void run() {
                System.out.println("startWatcher for " + target.getName() + " BEGIN");
                try {
                    target.join();
                } catch (InterruptedException e) {
                }
                tsLog.close();
                System.out.println("startWatcher for " + target.getName() + " END");
            }
        };
        // 開始監視
        watcher.start();
    }
}
