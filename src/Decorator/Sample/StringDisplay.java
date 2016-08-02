package Decorator.Sample;

public class StringDisplay extends Display {
    private String string;                          // �C�L���r��
    public StringDisplay(String string) {           // �H�޼ƫ��w�C�L���r��
        this.string = string;
    }
    public int getColumns() {                       // �r��
        return string.getBytes().length;
    }
    public int getRows() {                          // ��Ƭ�1
        return 1;
    }
    public String getRowText(int row) {             // �Ȧbrow��0�ɤ~�Ǧ^
        if (row == 0) {
            return string;
        } else {
            return null;
        }
    }
}
