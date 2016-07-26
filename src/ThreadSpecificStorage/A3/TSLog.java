package ThreadSpecificStorage.A3;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TSLog {
    private PrintWriter writer = null;

    // 初始化writer欄位
    public TSLog(String filename) {
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 加入一筆log
    public void println(String s) {
        writer.println(s);
    }

    // 關閉log
    public void close() {
        writer.println("==== End of log ====");
        writer.close();
    }
}
