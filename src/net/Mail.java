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
			smtpsOutput.println("MAIL FROM:<" + from + ">"); // �H
																// �H
																// �H
			smtpsOutput.println("RCPT TO:<" + to + ">"); // ��
															// �H
															// �H
			smtpsOutput.println("DATA"); // �H �� �} �l
			smtpsOutput.println("Subject:" + sub); // ��
													// �D
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
		System.out.println("�q�l�l��ǰe����......");
		System.exit(0);

	};

}
