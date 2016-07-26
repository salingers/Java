package ThreadSpecificStorage.Sample2;

public class Log {
    private static final ThreadLocal tsLogCollection = new ThreadLocal();

    // 加入一筆log
    public static void println(String s) {
        getTSLog().println(s);
    }

    // 關閉log
    public static void close() {
        getTSLog().close();
    }

    // 取得執行緒特有的log
    private static TSLog getTSLog() {
        TSLog tsLog = (TSLog)tsLogCollection.get();

        // 如果執行緒是第一次呼叫，就建立新檔案並登錄log
        if (tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
        }

        return tsLog;
    }
}
