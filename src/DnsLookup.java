import java.io.*;
import java.net.*;

class DnsLookup
{

		public static void main(String args[])
		{
				BufferedReader inpt = new BufferedReader(new InputStreamReader(System.in));
				InetAddress host;
				String site = null;
				try
				{
						System.out.print("請輸入欲查詢的名字: ");
						site = inpt.readLine();
				} catch (IOException ioe)
				{
				}

				try
				{
						if (site == null)
						{
								host = InetAddress.getLocalHost();
						} else
						{
								host = InetAddress.getByName(site);
						}
						System.out.println("名稱'" + host.getHostName() + "'的IP位址是:" + host.getHostAddress());
				} catch (UnknownHostException e)
				{
						System.out.println("查詢錯誤");
				}
		}
}