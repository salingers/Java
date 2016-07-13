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
						System.out.print("�п�J���d�ߪ��W�r: ");
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
						System.out.println("�W��'" + host.getHostName() + "'��IP��}�O:" + host.getHostAddress());
				} catch (UnknownHostException e)
				{
						System.out.println("�d�߿��~");
				}
		}
}