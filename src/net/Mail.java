package net;

import java.net.*;
import java.io.*;

public class Mail
{

	public static void main(String args[]) throws Exception
	{
	}

	public Mail()
	{

		String from = "";
		String to = "";
		String srv = "";
		String sub = "";
		String content = "";
		try
		{
			InetAddress server = InetAddress.getByName(srv);
			InetAddress myip = InetAddress.getLocalHost();
			Socket smtps = new Socket(server, 25);
			PrintWriter smtpsOutput = new PrintWriter(smtps.getOutputStream());
			smtpsOutput.println("HELO " + myip.getHostAddress());
			smtpsOutput.println("MAIL FROM:<" + from + ">"); // 寄
																// 信
																// 人
			smtpsOutput.println("RCPT TO:<" + to + ">"); // 收
															// 信
															// 人
			smtpsOutput.println("DATA"); // 信 件 開 始
			smtpsOutput.println("Subject:" + sub); // 標
													// 題
			smtpsOutput.println(content);
			smtpsOutput.println(".");
			smtpsOutput.println("QUIT");
			smtpsOutput.flush();
		}
		catch (UnknownHostException ue)
		{
		}
		catch (Throwable e)
		{
			System.out.println(" Error SMTP: " + e);
		}
		System.out.println("電子郵件傳送完畢......");
		System.exit(0);

	};

}
