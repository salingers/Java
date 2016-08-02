package Decorator.Sample;

public abstract class Border extends Display {
    protected Display display;          // 指裝飾外框裡面的「內容」
    protected Border(Display display) { // 在產生物件個體時，以引數指定「內容」
        this.display = display;
    }
}
