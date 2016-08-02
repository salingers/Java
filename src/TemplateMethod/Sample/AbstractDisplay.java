package TemplateMethod.Sample;

public abstract class AbstractDisplay { //��H���OAbstractDisplay
    public abstract void open();        // �Ѥl���O��@����H��k�]1�^open
    public abstract void print();       // �Ѥl���O��@����H��k�]2�^print
    public abstract void close();       // �Ѥl���O��@����H��k�]3�^close
    public final void display() {       // �b����H���O����@����kdisplay
        open();                             // ��open�K
        for (int i = 0; i < 5; i++) {       // ����5��print�K
            print();                    
        }
        close();                            //�K�̫�close�_�ӡC�o�N�O��@display��k�ɪ����e���e�B
    }
}
