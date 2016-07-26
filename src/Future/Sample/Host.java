package Future.Sample;

public class Host {
    public Data request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");

        // (1) 建立FutureData的實體
        final FutureData future = new FutureData();

        // (2) 為了建立RealData的實體，啟動新的執行緒
        new Thread() {                                      
            public void run() {                             
                RealData realdata = new RealData(count, c);
                future.setRealData(realdata);
            }                                               
        }.start();                                          

        System.out.println("    request(" + count + ", " + c + ") END");

        // (3) 取回FutureData實體，作為傳回值
        return future;
    }
}
