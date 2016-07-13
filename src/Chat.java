import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

public class Chat extends Frame          //UDP Receive用法
  { 
	static Chat MyFrame;
	static byte buf[]=new byte[1024];        //1024個位元組的緩衝器
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
	MyFrame.setTitle("聊天");
	MyFrame.setSize(400,400);
	MyFrame.show();

for (; ;)                                     //無限迴圈
      {
      DatagramPacket packet =           //資料封包物件packet
        new DatagramPacket(buf,buf.length);  //使用buf緩衝器
      socket=new DatagramSocket(port); //插座
      socket.receive(packet);       //插座接收資料封包packet
      str=new String(buf,0,packet.getLength()); //轉為字串
      ta.append("\n"+str);
      socket.close();                         //插座物件關閉
    }
    }

 public Chat(){
	setLayout(new BorderLayout());
	MenuBar menubar=new MenuBar();
	setMenuBar(menubar);
	Menu connect=new Menu("連線");
	menubar.add(connect);
        MenuItem connItem = new MenuItem("開始連線",new MenuShortcut('o'));
        MenuItem exitItem = new MenuItem("結束",new MenuShortcut('e'));
	connect.add(connItem);
	connect.add(exitItem);
	tf=new TextField(30);
	ta=new TextArea(20,20);
	add("South",tf);
	add("North",ta);
	connDialog=new MyDialog(this,"遠端連線",true);	
	tf.addKeyListener(new KeyAdapter(){

 	public void keyPressed(KeyEvent ke){
	if(ke.getKeyCode()==KeyEvent.VK_ENTER)
	{
	String out=na+">"+tf.getText();
	ta.append("\n"+out);
        int msglen=out.length();            //信息字串的長度
        byte msg[]=new byte[msglen];           //位元組陣列msg[]
        msg=out.getBytes();   //字串轉為位元組陣列
	try{
	InetAddress address=InetAddress.getByName(ip);
	DatagramPacket opacket=              //資料封包物件packet
        new DatagramPacket(msg,msglen,address,port); //用msg[]
        socket.send(opacket);            //插座送出資料封包packet
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
	add(new Label("請輸入你的代號"));
	final TextField nameTxt=new TextField(20);
	add(nameTxt);
	add(new Label("請輸入對方IP"));
	final TextField ipTxt=new TextField(20);
	add(ipTxt);
	Button ok=new Button("確定");
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