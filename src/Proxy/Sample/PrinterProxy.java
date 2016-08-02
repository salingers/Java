package Proxy.Sample;

public class PrinterProxy implements Printable {
    private String name;            // �R�W
    private Printer real;           // �u���H�v
    public PrinterProxy() {
    }
    public PrinterProxy(String name) {      // �غc�l
        this.name = name;
    }
    public synchronized void setPrinterName(String name) {  // �R�W
        if (real != null) {
            real.setPrinterName(name);  // �u���H�v�]�n�R�W
        }
        this.name = name;
    }
    public String getPrinterName() {    // ���o�W��
        return name;
    }
    public void print(String string) {  // ��X
        realize();
        real.print(string);
    }
    private synchronized void realize() {   // ���͡u���H�v
        if (real == null) {
            real = new Printer(name);
        }
    }
}
