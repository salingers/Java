package Balking.A2_2;

import java.io.IOException;
import java.io.FileWriter;
import java.io.Writer;

public class Data {
    private String filename;    // �x�s�ɪ��ɦW
    private String content;     // ��ƪ����e
    private boolean changed;    // �ק�᪺���e�٨S�x�s���ܡA�Ȭ�true

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    // �ק��Ƥ��e
    public synchronized void change(String newContent) {        
        content = newContent;                                   
        changed = true;                                           
    }                                                           

    // �Y��Ʀ��ק�A�N�x�s���ɮ׸�
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

    // ��ڱN������x�s���ɮ׸̥Ϊ���k
    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
        Writer writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
}
