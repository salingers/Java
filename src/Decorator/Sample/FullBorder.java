package Decorator.Sample;

public class FullBorder extends Border {
    public FullBorder(Display display) {
        super(display);
    }
    public int getColumns() {                   // �r�ơפ��e�r�ơϤ��e���䪺�˹��r��
        return 1 + display.getColumns() + 1;
    }
    public int getRows() {                      // ��ơפ��e��ơϤW�U���˹��r��
        return 1 + display.getRows() + 1;
    }
    public String getRowText(int row) {         // ���w�Ӧ檺���e
        if (row == 0) {                                                 // �~�س���
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else if (row == display.getRows() + 1) {                      // �~�ة���
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else {                                                        // ��L����
            return "|" + display.getRowText(row - 1) + "|";
        }
    }
    private String makeLine(char ch, int count) {         // �H�r��ch�A�إ߭���count�����s��r��
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }
}
