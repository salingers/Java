package ThreadSpecificStorage.Sample2;

public class Log {
    private static final ThreadLocal tsLogCollection = new ThreadLocal();

    // �[�J�@��log
    public static void println(String s) {
        getTSLog().println(s);
    }

    // ����log
    public static void close() {
        getTSLog().close();
    }

    // ���o������S����log
    private static TSLog getTSLog() {
        TSLog tsLog = (TSLog)tsLogCollection.get();

        // �p�G������O�Ĥ@���I�s�A�N�إ߷s�ɮרõn��log
        if (tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
        }

        return tsLog;
    }
}
