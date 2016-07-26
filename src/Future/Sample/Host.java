package Future.Sample;

public class Host {
    public Data request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");

        // (1) �إ�FutureData������
        final FutureData future = new FutureData();

        // (2) ���F�إ�RealData������A�Ұʷs�������
        new Thread() {                                      
            public void run() {                             
                RealData realdata = new RealData(count, c);
                future.setRealData(realdata);
            }                                               
        }.start();                                          

        System.out.println("    request(" + count + ", " + c + ") END");

        // (3) ���^FutureData����A�@���Ǧ^��
        return future;
    }
}
