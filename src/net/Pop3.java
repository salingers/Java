package net;

import java.io.*;
import java.net.*;

public class Pop3
{

	public static void main(String args[])
	{
		String m = null;
		Socket socket;
		BufferedReader s_in;
		PrintWriter s_out;

		try
		{
			BufferedReader key_in = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("請輸入POP3主機位址:");
			String server = key_in.readLine();
			System.out.print("請輸入帳號:");
			String account = key_in.readLine();
			System.out.print("請輸入密碼:");
			String passwd = key_in.readLine();

			InetAddress addr = InetAddress.getByName(server);
			int port = 110;
			socket = new Socket(addr, port);
			s_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			s_out = new PrintWriter(socket.getOutputStream());
			System.out.println(s_in.readLine());
			s_out.println("USER " + account);
			s_out.flush();
			System.out.println(s_in.readLine());
			s_out.println("PASS " + passwd);
			s_out.flush();
			System.out.println(s_in.readLine());
			s_out.println("STAT");
			s_out.flush();
			int x = Integer.parseInt(String.valueOf(s_in.readLine().charAt(4)));
			System.out.println("您有" + x + "封新信件");
			if ((int) x == 0)
			{
				s_out.println("QUIT");
				s_out.flush();
				socket.close();
				System.exit(0);
			}
			System.out.print("請輸入：");
			try
			{
				m = key_in.readLine();
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
			if (Integer.parseInt(m) > x)
			{
				System.out.println("輸入錯誤...");
			}
			else
			{
				s_out.println("RETR " + m);
				s_out.flush();
				while (true)
				{
					String data = s_in.readLine();
					if (data.startsWith("."))
					{
						break;
					}
					System.out.println(data);
				}
			}
			s_out.println("QUIT");
			s_out.flush();
			socket.close();
		}
		catch (UnknownHostException uhe)
		{
			System.out.println("Server位址錯誤...");
		}
		catch (IOException ioe)
		{
			System.out.println("IO錯誤...");
		}
	}
}
