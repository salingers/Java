package Composite.Sample;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {
    private String name;                    // �ؿ��W��
    private ArrayList directory = new ArrayList();      // �ؿ��i�J�I�����X
    public Directory(String name) {         // �غc�l
        this.name = name;
    }
    public String getName() {               // ���o�ؿ��W��
        return name;
    }
    public int getSize() {                  // ���o�ؿ��e�q
        int size = 0;
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            size += entry.getSize();
        }
        return size;
    }
    public Entry add(Entry entry) {         // �s�W�i�J�I
        directory.add(entry);
        return this;
    }
    protected void printList(String prefix) {       // �i�J�I���`��
        System.out.println(prefix + "/" + this);
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            entry.printList(prefix + "/" + name);
        }
    }
}
