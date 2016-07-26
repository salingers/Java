package ThreadSpecificStorage.A3;

public class Log {
    private static final ThreadLocal tsLogCollection = new ThreadLocal();

    // �glog
    public static void println(String s) {
        getTSLog().println(s);
    }

    // ����log
    public static void close() {
        getTSLog().close();
    }

    // ��o������T����log
    private static TSLog getTSLog() {
        TSLog tsLog = (TSLog)tsLogCollection.get();

        // �p�G�Ӱ�����O�Ĥ@���I�s�A�N���صn��
        if (tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
            startWatcher(tsLog);
        }

        return tsLog;
    }

    // �Ұʵ��ݰ���������������
    private static void startWatcher(final TSLog tsLog) {
        // �Q�ʵ��������
        final Thread target = Thread.currentThread();
        // �i��ʵ��������
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
        // �}�l�ʵ�
        watcher.start();
    }
}
