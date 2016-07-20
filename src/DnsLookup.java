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
			System.out.print("�п�J���d�ߪ��W�r: ");
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
			System.out.println("�W��'" + address.getHostName() + "'��IP��}�O:" + address.getHostAddress());
		}
		catch (UnknownHostException e)
		{
			System.out.println("�d�߿��~");
		}
	}
}