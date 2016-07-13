import java.net.*;
import java.io.*;

public class GetUrl
{
		public static void main(String args[])
		{
				URL url = null;
				try
				{
						url = new URL(args[0]);
				} // URL�ѩR�O�C��J�إ�
				catch (MalformedURLException mue) // �ҥ~
				{
						System.out.println("error: " + mue);
				}
				System.out.println("url:" + url.toExternalForm());

				System.out.println("Protocol:" + url.getProtocol());
				System.out.println("Host:" + url.getHost());
				System.out.println("Port:" + url.getPort());
				System.out.println("File:" + url.getFile());
				System.out.println("Ref:" + url.getRef());
				try
				{
						System.out.println("Content:" + url.getContent());
				} catch (IOException ioe)
				{
				}
		}
}
