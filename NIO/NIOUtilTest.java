package NIO;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;

public class NIOUtilTest
{
	public static void main(String[] args) throws IOException
	{
		URL url = new URL("http://openhome.cc");

		NIOUtil.dump(Channels.newChannel(url.openStream())//
				, new FileOutputStream("c:\\workspace\\index.html")//
						.getChannel());
	}
}
