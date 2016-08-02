package TemplateMethod.Sample;

public class Main {
    public static void main(String[] args) {
        AbstractDisplay d1 = new CharDisplay('H');                  // 建立1個有'H'的CharDisplay的物件個體。
        AbstractDisplay d2 = new StringDisplay("Hello, world.");    // 建立1個有"Hello, world."的StringDisplay的物件個體。
        AbstractDisplay d3 = new StringDisplay("你好。");     // 建立1個有"你好。"的StringDisplay的物件個體。
        d1.display();                                               // d1,d2,d3都是AbstractDisplay的子類別的物件個體，因此，
        d2.display();                                               // 可以呼叫繼承到的display方法。
        d3.display();                                               // 實際動作則規定在類別CharDisplay、StringDisplay。
    }
}
