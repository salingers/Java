import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class Mail extends Frame
{
		static TextArea ta;
		static TextField fromtf, totf, srvtf, subtf;
		static Button ok;
		static Mail MyFrame;

		public static void main(String args[]) throws Exception
		{
				MyFrame = new Mail();
				MyFrame.setTitle("電子郵件系統");
				MyFrame.setSize(400, 450);
				MyFrame.show();
		}

		public Mail()
		{
				fromtf = new TextField(20);
				totf = new TextField(20);
				srvtf = new TextField(20);
				subtf = new TextField(20);
				ta = new TextArea(15, 50);
				ok = new Button("傳送");
				setLayout(new FlowLayout(FlowLayout.LEFT));
				add(new Label("請輸入你的電子信箱位址："));
				add(fromtf);
				add(new Label("請輸入對方的電子信箱位址："));
				add(totf);
				add(new Label("請輸入SMTP郵件伺服器位址："));
				add(srvtf);
				add(new Label("請輸入你的信件主題："));
				add(subtf);
				add(ta);
				add(ok);

				ok.addActionListener(new ActionListener()
				{
						public void actionPerformed(ActionEvent event)
						{
								String from = fromtf.getText();
								String to = totf.getText();
								String srv = srvtf.getText();
								String sub = subtf.getText();
								String content = ta.getText();
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
								} catch (UnknownHostException ue)
								{
								} catch (Throwable e)
								{
										System.out.println(" Error SMTP: " + e);
								}
								System.out.println("電子郵件傳送完畢......");
								dispose();
								System.exit(0);

						}
				});

				addWindowListener(new WindowAdapter()
				{
						public void windowClosing(WindowEvent e)
						{
								dispose();
								System.exit(0);
						}
				});

		}

}