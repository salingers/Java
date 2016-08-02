package Visitor.Sample;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {
    private String name;                    // �ؿ��W��
    private ArrayList dir = new ArrayList();      // �ؿ��i�J�I�����X
    public Directory(String name) {         // �غc�l
        this.name = name;
    }
    public String getName() {               // ���o�W��
        return name;
    }
    public int getSize() {                  // ���o�ؿ��e�q
        int size = 0;
        Iterator it = dir.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            size += entry.getSize();
        }
        return size;
    }
    public Entry add(Entry entry) {         // �s�W�i�J�I
        dir.add(entry);
        return this;
    }
    public Iterator iterator() {      // ����Iterator 
        return dir.iterator();
    }
    public void accept(Visitor v) {         // �����X��
        v.visit(this);
    }
}
