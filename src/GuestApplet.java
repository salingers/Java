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
				{ // 若尋找遠端主機的物件，就建立物件
						gb = (GuestBook) Naming.lookup("//" + getCodeBase().getHost() + "/gbookserver");
				} catch (Exception e)
				{
						System.err.println("無法連接" + e);
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
										ta.append("無法連接" + re);
								}
						}
				});
		}

}
