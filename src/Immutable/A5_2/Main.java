package Immutable.A5_2;

public class Main {
    public static void main(String[] args) {
        // �إ߹���
        Point p1 = new Point(0, 0);
        Point p2 = new Point(100, 0);
        Line line = new Line(p1, p2);

        // ���
        System.out.println("line = " + line);

        // ���A�ܧ�
        p1.x = 150;
        p2.x = 150;
        p2.y = 250;

        // �A�����
        System.out.println("line = " + line);
    }
}
