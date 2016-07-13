import java.awt.*;
import java.awt.event.*;
import java.rmi.*;

public class GuestApplet extends java.applet.Applet
{
		TextField name;
		TextField mail;
		TextArea ta;
		Button send;
		
		GuestBook gb;

		public void init()
		{
				try
				{ // �Y�M�价�ݥD��������A�N�إߪ���
						gb = (GuestBook) Naming.lookup("//" + getCodeBase().getHost() + "/gbookserver");
				} catch (Exception e)
				{
						System.err.println("�L�k�s��" + e);
				}
				name = new TextField(30);
				mail = new TextField(30);
				ta = new TextArea(10, 40);
				send = new Button("send");
				Label na = new Label("name:");
				Label email = new Label("E-Mail:");
				Label content = new Label("Content:");
				setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
				add(na);
				add(name);
				add(email);
				add(mail);
				add(content);
				add(ta);
				add(send);
				send.addActionListener(new ActionListener()
				{
						public void actionPerformed(ActionEvent event)
						{
								try
								{
										gb.getMsg(name.getText(), mail.getText(), ta.getText());
										name.setText("");
										mail.setText("");
										ta.setText("");
								} catch (RemoteException re)
								{
										ta.append("�L�k�s��" + re);
								}
						}
				});
		}

}
