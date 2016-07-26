package Balking.A2_2;

import java.io.IOException;
import java.io.FileWriter;
import java.io.Writer;

public class Data {
    private String filename;    // 儲存時的檔名
    private String content;     // 資料的內容
    private boolean changed;    // 修改後的內容還沒儲存的話，值為true

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    // 修改資料內容
    public synchronized void change(String newContent) {        
        content = newContent;                                   
        changed = true;                                           
    }                                                           

    // 若資料有修改，就儲存到檔案裡
    public void save() throws IOException {   // not synchronized
        if (!changed) {                                           
            System.out.println(Thread.currentThread().getName() + " balks");
            return;                                             
        }                                                       
        doSave();                                             
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        changed = false;                                          
    }                                                           

    // 實際將有資料儲存到檔案裡用的方法
    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
        Writer writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
}
