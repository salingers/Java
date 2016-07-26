package ReadWriteLock.A3_1;

public final class ReadWriteLock {
    private int readingReaders = 0; // (A)...實際正在讀取的執行緒數量
    private int waitingWriters = 0; // (B)...正在等待寫入的執行緒數量
    private int writingWriters = 0; // (C)...實際正在寫入的執行緒數量
    private boolean preferWriter = true; // 寫入優先的話，值為true 

    public synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
            wait();
        }
        readingReaders++;                       // (A)實際正在讀取的執行緒數量加1
    }

    public synchronized void readUnlock() {
        readingReaders--;                       // (A)實際正在讀取的執行緒數量減1
        preferWriter = true;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;                       // (B)正在等待寫入的執行緒數量加1
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
        } finally {
            waitingWriters--;                   // (B)正在等待寫入的執行緒數量減1
        }
        writingWriters++;                       // (C)實際正在寫入的執行緒數量加1
    }

    public synchronized void writeUnlock() {
        writingWriters--;                       // (C)實際正在寫入的執行緒數量減1
        preferWriter = false;
        notifyAll();
    }
}
