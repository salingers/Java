package ReadWriteLock.A3_1;

public final class ReadWriteLock {
    private int readingReaders = 0; // (A)...��ڥ��bŪ����������ƶq
    private int waitingWriters = 0; // (B)...���b���ݼg�J��������ƶq
    private int writingWriters = 0; // (C)...��ڥ��b�g�J��������ƶq
    private boolean preferWriter = true; // �g�J�u�����ܡA�Ȭ�true 

    public synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
            wait();
        }
        readingReaders++;                       // (A)��ڥ��bŪ����������ƶq�[1
    }

    public synchronized void readUnlock() {
        readingReaders--;                       // (A)��ڥ��bŪ����������ƶq��1
        preferWriter = true;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;                       // (B)���b���ݼg�J��������ƶq�[1
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
        } finally {
            waitingWriters--;                   // (B)���b���ݼg�J��������ƶq��1
        }
        writingWriters++;                       // (C)��ڥ��b�g�J��������ƶq�[1
    }

    public synchronized void writeUnlock() {
        writingWriters--;                       // (C)��ڥ��b�g�J��������ƶq��1
        preferWriter = false;
        notifyAll();
    }
}
