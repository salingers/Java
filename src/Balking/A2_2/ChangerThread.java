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
                data.change("No." + i);             // 修改資料
                Thread.sleep(random.nextInt(1000)); // 模擬去做別的事
                data.save();                        // 明確地要求存檔
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
