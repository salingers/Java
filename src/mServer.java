import java.io.*;
import java.net.*;

public class mServer extends Thread // TCP伺服端
{
		public final static int port = 1024; // 預設埠號1024
		ServerSocket sc; // 伺服端socket
		Socket socket;
		int count = 0;

		public static void main(String args[])
		{
				new mServer(port); // 建立mServer物件
		}

		public mServer(int port) // 建構子,port為參數
		{
				try
				{
						sc = new ServerSocket(port);
				} // 伺服端socket
				catch (IOException e)
				{
						System.out.println(e);
				} // 錯誤
				System.out.println("Listening on port " + port);
				this.start(); // 啟動執行緒
		}

		public void run()
		{
				try
				{
						while (true)
						{
								socket = sc.accept(); // 接收
								Conn client = new Conn(socket, ++count); // 連線
						}
				} catch (IOException e2)
				{
						System.out.println(e2);
				} // 錯誤
		}
}

class Conn extends Thread // 連結類別Conn
{
		Socket csocket; // 客戶端socket為client
		BufferedReader in; // 輸入資料流
		PrintWriter out;
		int id;

		public Conn(Socket socket, int count) // 建構子socket為客戶端
		{
				csocket = socket; // client就是socket
				id = count;
				try
				{
						in = new BufferedReader(new InputStreamReader(csocket.getInputStream())); // 輸入
						out = new PrintWriter(csocket.getOutputStream()); // 輸出
				} catch (IOException e3)
				{ // 錯誤
						System.err.println("get socket streams err: " + e3);
				}
				this.start(); // 啟動
		}

		public void run()
		{
				System.out.println("第" + id + "位使用者連線");
				try
				{
						while (true)
						{
								String msg = in.readLine(); // 由socket讀入的字串msg
								if (msg.equals("quit"))
										break;
								System.out.println("第" + id + "位使用者訊息:" + msg);
								String remsg = new String("Server接收到訊息:" + msg);
								out.println(remsg);
								out.flush();
						}
						csocket.close();
						System.out.println("第" + id + "位使用者離線");
				} catch (IOException e4)
				{
						System.out.println(e4);
				} // 例外時
		}
}