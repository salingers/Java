package Decorator.Sample;

public abstract class Display {
    public abstract int getColumns();               // ���o��V���r��
    public abstract int getRows();                  // ���o���V�����
    public abstract String getRowText(int row);     // ���o��row�Ӧr��
    public void show() {                            // �C�L�Ҧ����e
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}
