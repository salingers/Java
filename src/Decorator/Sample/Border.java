package Decorator.Sample;

public abstract class Border extends Display {
    protected Display display;          // ���˹��~�ظ̭����u���e�v
    protected Border(Display display) { // �b���ͪ������ɡA�H�޼ƫ��w�u���e�v
        this.display = display;
    }
}
