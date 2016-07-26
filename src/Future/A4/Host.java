package Future.A4;

public class Host {
    public Data request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");

        // (1) �إ�FutureData������
        final FutureData future = new FutureData();         

        // (2) ���F�إ�RealData������A�Ұʷs�������
        new Thread() {                                      
            public void run() {                             
                try {
                    RealData realdata = new RealData(count, c);
                    future.setRealData(realdata);
                } catch (Exception e) {
                    future.setException(e);
                }
            }                                               
        }.start();                                          

        System.out.println("    request(" + count + ", " + c + ") END");

        // (3) ���^FutureData����A�@���Ǧ^��
        return future;                                      
    }
}
