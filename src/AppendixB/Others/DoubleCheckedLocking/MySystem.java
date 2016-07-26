package AppendixB.Others.DoubleCheckedLocking;

// X���O�Ұʧ@���T
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
        if (instance == null) {                 // (a) �Ĥ@��test
            synchronized (MySystem.class) {     // (b) �i��synchronized�϶�
                if (instance == null) {         // (c) �ĤG��test
                    instance = new MySystem();  // (d) set
                }
            }                                   // (e) ���}synchronized�϶�
        }
        return instance;                        // (f)
    }
}
