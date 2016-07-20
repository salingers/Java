import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

class Finger extends Frame
{

	static TextField send;
	static TextField address;
	static TextArea receive;

	static Button ok;
	static Button proceed;
	static Button close;

	static Finger frame;

	public static void main(String args[]) throws Exception
	{
		frame = new Finger();
		frame.setTitle("Finger�{��");
		frame.setSize(480, 300);
		frame.show();

	}

	public Finger()
	{

		send = new TextField(40);
		address = new TextField(40);
		receive = new TextArea(10, 63);

		//
		ok = new Button("�d��");
		proceed = new Button("�~��");
		close = new Button("����");

		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new Label("�п�J�ǰe�T���G"));
		add(send);
		add(new Label("�п�J�D����}�G"));
		add(address);
		add(receive);

		add(ok);
		add(proceed);
		add(close);

		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				String message = send.getText();

				String name = address.getText();

				int port = 79;

				try
				{
					InetAddress address = InetAddress.getByName(name);
					Socket socket = new Socket(address, port);

					BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					PrintWriter writer = new PrintWriter(socket.getOutputStream());

					writer.println(message);
					writer.flush();

					while (reader.readLine() != null)
					{
						receive.append(reader.readLine() + "\n");
					}

					socket.close();
				}
				catch (IOException ioe)
				{
					receive.append("�L�k�s���D��...");
				}
			}
		});

		proceed.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				send.setText("");
				address.setText("");
				receive.setText("");
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