import java.io.*;
import java.net.*;

public class Receive                         //UDP Receive�Ϊk
  {
  static final int port=1024;                   //�𸹬�1024
  public static void main(String args[]) throws Exception
    {
    byte buf[]=new byte[1024];        //1024�Ӧ줸�ժ��w�ľ�
    String str;
    System.out.println("Listening Port ("+port+")......");
    for (;;)                                     //�L���j��
      {
      DatagramPacket packet =           //��ƫʥ]����packet
        new DatagramPacket(buf,buf.length);  //�ϥ�buf�w�ľ�
      DatagramSocket socket=new DatagramSocket(port); //���y
      socket.receive(packet);       //���y������ƫʥ]packet
      str=new String(buf,0,packet.getLength()); //�ର�r��
      System.out.println("Receive>"+str);               //�L�X
      socket.close();                         //���y��������
      }
    }
  }
