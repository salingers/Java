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
				MyFrame.setTitle("�q�l�l��t��");
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
				ok = new Button("�ǰe");
				setLayout(new FlowLayout(FlowLayout.LEFT));
				add(new Label("�п�J�A���q�l�H�c��}�G"));
				add(fromtf);
				add(new Label("�п�J��誺�q�l�H�c��}�G"));
				add(totf);
				add(new Label("�п�JSMTP�l����A����}�G"));
				add(srvtf);
				add(new Label("�п�J�A���H��D�D�G"));
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
								} catch (UnknownHostException ue)
								{
								} catch (Throwable e)
								{
										System.out.println(" Error SMTP: " + e);
								}
								System.out.println("�q�l�l��ǰe����......");
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