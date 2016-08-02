package Visitor.Sample;

import java.util.Iterator;

public abstract class Entry implements Element {
    public abstract String getName();                                   // ���o�ɦW
    public abstract int getSize();                                      // ���o�ɮ׮e�q
    public Entry add(Entry entry) throws FileTreatmentException {       // �s�W�i�J�I
        throw new FileTreatmentException();
    }
    public Iterator iterator() throws FileTreatmentException {    // ����Iterator
        throw new FileTreatmentException();
    }
    public String toString() {                                          // �L�X�r��
        return getName() + " (" + getSize() + ")";
    }
}
