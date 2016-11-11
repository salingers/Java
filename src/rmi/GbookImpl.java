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
				+ msg + "</p>" // �d�����e
				+ cal.getTime().toString() + "<hr>"; // �ɶ�
		try
		{
			// �إ�RandomAccessFile����A�ó]�w�Q�g�J���ɮצW�٬�"gbook.htm"
			RandomAccessFile fileOut = new RandomAccessFile("gbook.htm", "rw");
			// �]�w�̫�@��Ū�g�ʧ@�q�̫�@�줸�}�l
			fileOut.seek(fileOut.length());
			fileOut.writeBytes(x); // �N��Ƽg�J
			fileOut.close(); // ��������
		}
		catch (IOException ioe) // IO�ҥ~
		{
			System.out.println("IO���~");
		} // ��X���~�T��
	}

	public static void main(String args[])
	{
		// �إߦw������޲z��
		System.setSecurityManager(new RMISecurityManager());
		try
		{
			GbookImpl gBook = new GbookImpl(); // �إ߻��ݪ���
			// �n�O����W�٬�gbookserver
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
