package ThreadSpecificStorage.A3;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TSLog {
    private PrintWriter writer = null;

    // ��l��writer���
    public TSLog(String filename) {
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // �[�J�@��log
    public void println(String s) {
        writer.println(s);
    }

    // ����log
    public void close() {
        writer.println("==== End of log ====");
        writer.close();
    }
}
