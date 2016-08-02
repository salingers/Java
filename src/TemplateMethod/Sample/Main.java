package TemplateMethod.Sample;

public class Main {
    public static void main(String[] args) {
        AbstractDisplay d1 = new CharDisplay('H');                  // �إ�1�Ӧ�'H'��CharDisplay���������C
        AbstractDisplay d2 = new StringDisplay("Hello, world.");    // �إ�1�Ӧ�"Hello, world."��StringDisplay���������C
        AbstractDisplay d3 = new StringDisplay("�A�n�C");     // �إ�1�Ӧ�"�A�n�C"��StringDisplay���������C
        d1.display();                                               // d1,d2,d3���OAbstractDisplay���l���O���������A�]���A
        d2.display();                                               // �i�H�I�s�~�Ө쪺display��k�C
        d3.display();                                               // ��ڰʧ@�h�W�w�b���OCharDisplay�BStringDisplay�C
    }
}
