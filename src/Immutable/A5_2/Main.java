package Immutable.A5_2;

public class Main {
    public static void main(String[] args) {
        // 建立實體
        Point p1 = new Point(0, 0);
        Point p2 = new Point(100, 0);
        Line line = new Line(p1, p2);

        // 顯示
        System.out.println("line = " + line);

        // 狀態變更
        p1.x = 150;
        p2.x = 150;
        p2.y = 250;

        // 再度顯示
        System.out.println("line = " + line);
    }
}
