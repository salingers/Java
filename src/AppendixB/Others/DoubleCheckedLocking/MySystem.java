package AppendixB.Others.DoubleCheckedLocking;

// X不保證動作正確
import java.util.Date;

public class MySystem {
    private static MySystem instance = null;
    private Date date = new Date();
    private MySystem() {
    }
    public Date getDate() {
        return date;
    }
    public static MySystem getInstance() {
        if (instance == null) {                 // (a) 第一次test
            synchronized (MySystem.class) {     // (b) 進行synchronized區塊
                if (instance == null) {         // (c) 第二次test
                    instance = new MySystem();  // (d) set
                }
            }                                   // (e) 離開synchronized區塊
        }
        return instance;                        // (f)
    }
}
