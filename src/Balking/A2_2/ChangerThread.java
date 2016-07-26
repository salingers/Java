package Balking.A2_2;

import java.io.IOException;
import java.util.Random;

public class ChangerThread extends Thread {
    private Data data;
    private Random random = new Random();
    public ChangerThread(String name, Data data) {
        super(name);
        this.data = data;
    }
    public void run() {
        try {
            for (int i = 0; true; i++) {
                data.change("No." + i);             // �ק���
                Thread.sleep(random.nextInt(1000)); // �����h���O����
                data.save();                        // ���T�a�n�D�s��
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
