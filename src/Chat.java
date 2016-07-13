import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

public class Chat extends Frame          //UDP Receive�Ϊk
  { 
	static Chat MyFrame;
	static byte buf[]=new byte[1024];        //1024�Ӧ줸�ժ��w�ľ�
	static String str;
	static int port=1024; 
	static TextField tf;
	static TextArea ta;
	static DatagramSocket socket;
	static MyDialog connDialog;
	static String ip=null;
	static String na=null;

 public static void main(String args[]) throws Exception
    {
	MyFrame=new Chat();
	MyFrame.setTitle("���");
	MyFrame.setSize(400,400);
	MyFrame.show();

for (; ;)                                     //�L���j��
      {
      DatagramPacket packet =           //��ƫʥ]����packet
        new DatagramPacket(buf,buf.length);  //�ϥ�buf�w�ľ�
      socket=new DatagramSocket(port); //���y
      socket.receive(packet);       //���y������ƫʥ]packet
      str=new String(buf,0,packet.getLength()); //�ର�r��
      ta.append("\n"+str);
      socket.close();                         //���y��������
    }
    }

 public Chat(){
	setLayout(new BorderLayout());
	MenuBar menubar=new MenuBar();
	setMenuBar(menubar);
	Menu connect=new Menu("�s�u");
	menubar.add(connect);
        MenuItem connItem = new MenuItem("�}�l�s�u",new MenuShortcut('o'));
        MenuItem exitItem = new MenuItem("����",new MenuShortcut('e'));
	connect.add(connItem);
	connect.add(exitItem);
	tf=new TextField(30);
	ta=new TextArea(20,20);
	add("South",tf);
	add("North",ta);
	connDialog=new MyDialog(this,"���ݳs�u",true);	
	tf.addKeyListener(new KeyAdapter(){

 	public void keyPressed(KeyEvent ke){
	if(ke.getKeyCode()==KeyEvent.VK_ENTER)
	{
	String out=na+">"+tf.getText();
	ta.append("\n"+out);
        int msglen=out.length();            //�H���r�ꪺ����
        byte msg[]=new byte[msglen];           //�줸�հ}�Cmsg[]
        msg=out.getBytes();   //�r���ର�줸�հ}�C
	try{
	InetAddress address=InetAddress.getByName(ip);
	DatagramPacket opacket=              //��ƫʥ]����packet
        new DatagramPacket(msg,msglen,address,port); //��msg[]
        socket.send(opacket);            //���y�e�X��ƫʥ]packet
	}
	catch(Exception ex){}
	tf.setText("");
		}
	}
	});
	
	connItem.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent cae){
	connDialog.setSize(200,180);	
	connDialog.show();
	}
	});

	exitItem.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent eae){
		dispose();
		System.exit(0);
	}
	});


	addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
		dispose();
		System.exit(0);
		}
	});
 }

	class MyDialog extends Dialog{
	MyDialog(Frame parent,String title,boolean modal){
	super(parent,title,modal);
	setLayout(new FlowLayout());
	add(new Label("�п�J�A���N��"));
	final TextField nameTxt=new TextField(20);
	add(nameTxt);
	add(new Label("�п�J���IP"));
	final TextField ipTxt=new TextField(20);
	add(ipTxt);
	Button ok=new Button("�T�w");
	add(ok);
	ok.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae){
	na=nameTxt.getText();
	ip=ipTxt.getText();
	dispose();
	}
	});
	}
	}
}
