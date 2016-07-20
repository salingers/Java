import java.io.*;
import java.net.*;

public class UDP
{

	public static void main(String args[]) throws Exception
	{
		send();
	}

	private static void send() throws IOException
	{

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String name = reader.readLine();

		InetAddress address = null;
		int port = 0;

		address = InetAddress.getByName(name);
		port = 1024;

		while (true)
		{
			String line = reader.readLine();

			int length = line.length();
			byte message[] = new byte[line.length()];

			message = line.getBytes();

			DatagramPacket packet = new DatagramPacket(message, length, address, port);
			DatagramSocket socket = new DatagramSocket();

			socket.send(packet);
			socket.close();
		}
	}

	private static void receive() throws IOException
	{
		final int port = 1024;

		byte buf[] = new byte[1024];
		String str;

		for (;;) // �L���j��
		{
			DatagramPacket packet = // ��ƫʥ]����packet
					new DatagramPacket(buf, buf.length); // �ϥ�buf�w�ľ�
			DatagramSocket socket = new DatagramSocket(port); // ���y

			socket.receive(packet); // ���y������ƫʥ]packet

			str = new String(buf, 0, packet.getLength()); // �ର�r��
			System.out.println("Receive>" + str); // �L�X
			socket.close(); // ���y��������
		}
	}
}
