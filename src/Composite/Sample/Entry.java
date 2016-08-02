package Composite.Sample;

public abstract class Entry {
    public abstract String getName();                               // ���o�ɦW
    public abstract int getSize();                                  // ���o�ɮ׮e�q
    public Entry add(Entry entry) throws FileTreatmentException {   // �s�W�i�J�I
        throw new FileTreatmentException();
    }
    public void printList() {                                       // ��X�`��
        printList("");
    }
    protected abstract void printList(String prefix);               // �b�e���[�Wprefix���X�`��
    public String toString() {                                      // �r���X�榡
        return getName() + " (" + getSize() + ")";
    }
}
