import java.io.*;
import java.net.*;

public class Receive                         //UDP Receive用法
  {
  static final int port=1024;                   //埠號為1024
  public static void main(String args[]) throws Exception
    {
    byte buf[]=new byte[1024];        //1024個位元組的緩衝器
    String str;
    System.out.println("Listening Port ("+port+")......");
    for (;;)                                     //無限迴圈
      {
      DatagramPacket packet =           //資料封包物件packet
        new DatagramPacket(buf,buf.length);  //使用buf緩衝器
      DatagramSocket socket=new DatagramSocket(port); //插座
      socket.receive(packet);       //插座接收資料封包packet
      str=new String(buf,0,packet.getLength()); //轉為字串
      System.out.println("Receive>"+str);               //印出
      socket.close();                         //插座物件關閉
      }
    }
  }
