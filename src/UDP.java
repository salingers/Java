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

		for (;;) // 無限迴圈
		{
			DatagramPacket packet = // 資料封包物件packet
					new DatagramPacket(buf, buf.length); // 使用buf緩衝器
			DatagramSocket socket = new DatagramSocket(port); // 插座

			socket.receive(packet); // 插座接收資料封包packet

			str = new String(buf, 0, packet.getLength()); // 轉為字串
			System.out.println("Receive>" + str); // 印出
			socket.close(); // 插座物件關閉
		}
	}
}
