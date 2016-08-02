package Visitor.Sample;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {
    private String name;                    // 目錄名稱
    private ArrayList dir = new ArrayList();      // 目錄進入點的集合
    public Directory(String name) {         // 建構子
        this.name = name;
    }
    public String getName() {               // 取得名稱
        return name;
    }
    public int getSize() {                  // 取得目錄容量
        int size = 0;
        Iterator it = dir.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            size += entry.getSize();
        }
        return size;
    }
    public Entry add(Entry entry) {         // 新增進入點
        dir.add(entry);
        return this;
    }
    public Iterator iterator() {      // 產生Iterator 
        return dir.iterator();
    }
    public void accept(Visitor v) {         // 接受訪客
        v.visit(this);
    }
}
