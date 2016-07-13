import java.io.*;
import java.net.*;

public class Client{

public static void main(String args[]){
	String data;
	Socket socket;
	int port=1024;
	InetAddress addr=null;
	BufferedReader key_in=new BufferedReader(new InputStreamReader(System.in));
	BufferedReader s_in;
	PrintWriter s_out;
	if(args.length!=1){
	System.out.println("java Client [server ip]");
	System.exit(0);
	}

	try{
		addr=InetAddress.getByName(args[0]);
	}
	catch(UnknownHostException uhe)
	{System.out.println("Server位址錯誤或未知...");}
	try{
		socket=new Socket(addr,port);
		s_in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		s_out=new PrintWriter(socket.getOutputStream());
		while(true){
			System.out.print("Client>");
			data=key_in.readLine();
			s_out.println(data);
			s_out.flush();
			if(data.equals("quit")) break;
			System.out.println(s_in.readLine());
		}

	socket.close();
	}
	catch(IOException ioe){System.out.println("無法連接主機...");}
 }
}
