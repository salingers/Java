import java.io.*;
import java.net.*;

public class Send // UDP Send用法
{
		static final int port = 1024;

		public static void main(String args[]) throws Exception
		{
				System.out.print("請輸入欲連線的IP：");
				BufferedReader inpt = new BufferedReader(new InputStreamReader(System.in));
				String addr = inpt.readLine();
				InetAddress address = InetAddress.getByName(addr);
				while (true)
				{
						System.out.print("Send>");
						String inp = inpt.readLine();
						int msglen = inp.length(); // 信息字串的長度
						byte msg[] = new byte[msglen]; // 位元組陣列msg[]
						msg = inp.getBytes(); // 字串轉為位元組陣列
						DatagramPacket packet = // 資料封包物件packet
						new DatagramPacket(msg, msglen, address, port); // 用msg[]
						DatagramSocket socket = new DatagramSocket(); // 插座物件
						socket.send(packet); // 插座送出資料封包packet
						socket.close(); // 插座物件關閉
				}
		}
}
