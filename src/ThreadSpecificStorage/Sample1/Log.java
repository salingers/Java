package ThreadSpecificStorage.Sample1;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
    private static PrintWriter writer = null;

    // 初始化writer欄位
    static {
        try {
            writer = new PrintWriter(new FileWriter("log.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 加入一筆log
    public static void println(String s) {
        writer.println(s);
    }

    // 關閉log
    public static void close() {
        writer.println("==== End of log ====");
        writer.close();
    }
}
