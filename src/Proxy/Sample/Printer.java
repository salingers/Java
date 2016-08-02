package Proxy.Sample;

public class Printer implements Printable {
    private String name;
    public Printer() {
        heavyJob("���b����Printer���������");
    }
    public Printer(String name) {                   // �غc�l
        this.name = name;
        heavyJob("���b����Printer���������(" + name + ")");
    }
    public void setPrinterName(String name) {       // �R�W
        this.name = name;
    }
    public String getPrinterName() {                // ���o�W��
        return name;
    }
    public void print(String string) {              // ��X�W��
        System.out.println("=== " + name + " ===");
        System.out.println(string);
    }
    private void heavyJob(String msg) {             // �������u�@�]���]�^
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.print(".");
        }
        System.out.println("�����C");
    }
}
