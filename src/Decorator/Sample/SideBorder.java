package Decorator.Sample;

public class SideBorder extends Border {
    private char borderChar;                        // �˹��r��
    public SideBorder(Display display, char ch) {   // �H�غc�l���wDisplay�M�˹��r�� 
        super(display);
        this.borderChar = ch;
    }
    public int getColumns() {                       // �r�ƭn�A�[�W���e���䪺�˹��r��
        return 1 + display.getColumns() + 1;
    }
    public int getRows() {                          // ��ƦP���e�����
        return display.getRows();
    }
    public String getRowText(int row) {             // ���w�Ӧ檺���e�Y���b���e�����w�檺����[�W�˹��r��
        return borderChar + display.getRowText(row) + borderChar;
    }
}
