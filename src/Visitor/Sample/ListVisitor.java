package Visitor.Sample;

import java.util.Iterator;

public class ListVisitor extends Visitor {
    private String currentdir = "";                         // �ثe�Ҧb���ؿ��W��
    public void visit(File file) {                  // �X���ɮ׮ɧY�I�s
        System.out.println(currentdir + "/" + file);
    }
    public void visit(Directory directory) {   // �X�ݥؿ��ɧY�I�s
        System.out.println(currentdir + "/" + directory);
        String savedir = currentdir;
        currentdir = currentdir + "/" + directory.getName();
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            entry.accept(this);
        }
        currentdir = savedir;
    }
}
