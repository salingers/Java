import java.io.*;
import java.net.*;

public class Send // UDP Send�Ϊk
{
		static final int port = 1024;

		public static void main(String args[]) throws Exception
		{
				System.out.print("�п�J���s�u��IP�G");
				BufferedReader inpt = new BufferedReader(new InputStreamReader(System.in));
				String addr = inpt.readLine();
				InetAddress address = InetAddress.getByName(addr);
				while (true)
				{
						System.out.print("Send>");
						String inp = inpt.readLine();
						int msglen = inp.length(); // �H���r�ꪺ����
						byte msg[] = new byte[msglen]; // �줸�հ}�Cmsg[]
						msg = inp.getBytes(); // �r���ର�줸�հ}�C
						DatagramPacket packet = // ��ƫʥ]����packet
						new DatagramPacket(msg, msglen, address, port); // ��msg[]
						DatagramSocket socket = new DatagramSocket(); // ���y����
						socket.send(packet); // ���y�e�X��ƫʥ]packet
						socket.close(); // ���y��������
				}
		}
}
