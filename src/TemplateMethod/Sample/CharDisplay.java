package TemplateMethod.Sample;

public class CharDisplay extends AbstractDisplay {  // CharDisplay�OAbstractDisplay ���l���O�C
    private char ch;                                // ����X���r���C
    public CharDisplay(char ch) {                   // ��H�غc�l�ǻ��L�Ӫ��r��ch
        this.ch = ch;                               // �x�s�b��줺�C
    }
    public void open() {                            //���Ӧb�����O�ɬO��H��k�C�o���мg�]override�^���@�C        System.out.print("<<");                     // ��X"<<"�����}�l�r��C
    }
    public void print() {                           // print��k�]�O�b����@�C���O�qdisplay�Q���ƩI�s�X�ӡC
        System.out.print(ch);                       // ��X1���x�s�b��쪺�r���C
    }
    public void close() {                           //close��k�]�O�b����@�C
        System.out.println(">>");                   // ��X�����r��">>"�C
    }
}
