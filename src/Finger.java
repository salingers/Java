import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

class Finger extends Frame
{

		static TextField name;
		static TextField address;
		static TextArea ta;
		static Button ok;
		static Button ctu;
		static Button close;
		static Finger FingerFrame;

		public static void main(String args[]) throws Exception
		{
				FingerFrame = new Finger();
				FingerFrame.setTitle("Finger程式");
				FingerFrame.setSize(480, 300);
				FingerFrame.show();
		}

		public Finger()
		{

				name = new TextField(40);
				address = new TextField(40);
				ta = new TextArea(10, 63);
				ok = new Button("查詢");
				ctu = new Button("繼續");
				close = new Button("關閉");
				setLayout(new FlowLayout(FlowLayout.LEFT));
				add(new Label("請輸入查詢者ID："));
				add(name);
				add(new Label("請輸入主機位址："));
				add(address);
				add(ta);
				add(ok);
				add(ctu);
				add(close);

				ok.addActionListener(new ActionListener()
				{
						public void actionPerformed(ActionEvent event)
						{
								String id = name.getText();
								String add = address.getText();
								try
								{
										InetAddress server = InetAddress.getByName(add);
										Socket finger = new Socket(server, 79);
										BufferedReader s_in = new BufferedReader(
														new InputStreamReader(finger.getInputStream()));
										PrintWriter s_out = new PrintWriter(finger.getOutputStream());
										s_out.println(id);
										s_out.flush();
										while (s_in.readLine() != null)
										{
												ta.append(s_in.readLine() + "\n");
										}
										finger.close();
								} catch (IOException ioe)
								{
										ta.append("無法連接主機...");
								}
						}
				});

				ctu.addActionListener(new ActionListener()
				{
						public void actionPerformed(ActionEvent event)
						{
								name.setText("");
								address.setText("");
								ta.setText("");
						}
				});

				close.addActionListener(new ActionListener()
				{
						public void actionPerformed(ActionEvent event)
						{
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