package Builder.Sample;

public class Director {
    private Builder builder;
    public Director(Builder builder) {      // ����Builder���l���O������A 
        this.builder = builder;             // �x�s�bbuilder���
    }
    public void construct() {             // �إߤ��
        builder.makeTitle("Greeting");              // ���D
        builder.makeString("�q���W��դѵ���");     // �r��
        builder.makeItems(new String[]{             // ����
            "���w�C",
            "�Ȧw�C",
        });
        builder.makeString("��F�ߤW");                 // �t�@�Ӧr��
        builder.makeItems(new String[]{             // �t�@�Ӷ���
            "�ߦw�C",
            "���A���Ӧn�ڡC",
            "�A���C",
        });
        builder.close();                 // �������
    }
}
