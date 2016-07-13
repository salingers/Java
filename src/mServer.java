import java.io.*;
import java.net.*;

public class mServer extends Thread // TCP���A��
{
		public final static int port = 1024; // �w�]��1024
		ServerSocket sc; // ���A��socket
		Socket socket;
		int count = 0;

		public static void main(String args[])
		{
				new mServer(port); // �إ�mServer����
		}

		public mServer(int port) // �غc�l,port���Ѽ�
		{
				try
				{
						sc = new ServerSocket(port);
				} // ���A��socket
				catch (IOException e)
				{
						System.out.println(e);
				} // ���~
				System.out.println("Listening on port " + port);
				this.start(); // �Ұʰ����
		}

		public void run()
		{
				try
				{
						while (true)
						{
								socket = sc.accept(); // ����
								Conn client = new Conn(socket, ++count); // �s�u
						}
				} catch (IOException e2)
				{
						System.out.println(e2);
				} // ���~
		}
}

class Conn extends Thread // �s�����OConn
{
		Socket csocket; // �Ȥ��socket��client
		BufferedReader in; // ��J��Ƭy
		PrintWriter out;
		int id;

		public Conn(Socket socket, int count) // �غc�lsocket���Ȥ��
		{
				csocket = socket; // client�N�Osocket
				id = count;
				try
				{
						in = new BufferedReader(new InputStreamReader(csocket.getInputStream())); // ��J
						out = new PrintWriter(csocket.getOutputStream()); // ��X
				} catch (IOException e3)
				{ // ���~
						System.err.println("get socket streams err: " + e3);
				}
				this.start(); // �Ұ�
		}

		public void run()
		{
				System.out.println("��" + id + "��ϥΪ̳s�u");
				try
				{
						while (true)
						{
								String msg = in.readLine(); // ��socketŪ�J���r��msg
								if (msg.equals("quit"))
										break;
								System.out.println("��" + id + "��ϥΪ̰T��:" + msg);
								String remsg = new String("Server������T��:" + msg);
								out.println(remsg);
								out.flush();
						}
						csocket.close();
						System.out.println("��" + id + "��ϥΪ����u");
				} catch (IOException e4)
				{
						System.out.println(e4);
				} // �ҥ~��
		}
}