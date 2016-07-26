package ThreadSpecificStorage.Sample1;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
    private static PrintWriter writer = null;

    // ��l��writer���
    static {
        try {
            writer = new PrintWriter(new FileWriter("log.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // �[�J�@��log
    public static void println(String s) {
        writer.println(s);
    }

    // ����log
    public static void close() {
        writer.println("==== End of log ====");
        writer.close();
    }
}
