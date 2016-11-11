package rmi;

import java.io.*;
import java.util.*;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class GbookImpl extends UnicastRemoteObject
{
	private String message;
	GregorianCalendar cal = new GregorianCalendar();

	public GbookImpl() throws RemoteException
	{
		super();
	}

	public void getMsg(String id, String mail, String msg) throws RemoteException
	{
		String x = "<a href=mailto:" + mail + ">" // E-mail
				+ id + "</a> write: <br><p>" // ID
				+ msg + "</p>" // 留言內容
				+ cal.getTime().toString() + "<hr>"; // 時間
		try
		{
			// 建立RandomAccessFile物件，並設定被寫入的檔案名稱為"gbook.htm"
			RandomAccessFile fileOut = new RandomAccessFile("gbook.htm", "rw");
			// 設定最後一個讀寫動作從最後一位元開始
			fileOut.seek(fileOut.length());
			fileOut.writeBytes(x); // 將資料寫入
			fileOut.close(); // 關閉物件
		}
		catch (IOException ioe) // IO例外
		{
			System.out.println("IO錯誤");
		} // 輸出錯誤訊息
	}

	public static void main(String args[])
	{
		// 建立安全機制管理員
		System.setSecurityManager(new RMISecurityManager());
		try
		{
			GbookImpl gBook = new GbookImpl(); // 建立遠端物件
			// 登記物件名稱為gbookserver
			Naming.rebind("gbookserver", gBook);
			System.out.println("server ok~");
		}
		catch (Exception e)
		{
			System.out.println("Server erroe" + e);
			System.exit(0);
		}
	}
}
