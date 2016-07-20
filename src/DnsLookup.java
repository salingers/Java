import java.io.*;
import java.net.*;

class DnsLookup
{

	public static void main(String args[])
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		InetAddress address;
		
		String site = null;
		
		try
		{
			System.out.print("請輸入欲查詢的名字: ");
			site = reader.readLine();
		}
		catch (IOException e)
		{
		}

		try
		{
			if (site == null)
			{
				address = InetAddress.getLocalHost();
			}
			else
			{
				address = InetAddress.getByName(site);
			}
			System.out.println("名稱'" + address.getHostName() + "'的IP位址是:" + address.getHostAddress());
		}
		catch (UnknownHostException e)
		{
			System.out.println("查詢錯誤");
		}
	}
}