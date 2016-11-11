package io;

import java.io.*;

public class HexIO
{
	File file;

	public static void main(String args[])
	{
		HexIO h = new HexIO("十六進位的檔案編輯器");
	}

	public HexIO(String title)
	{

	}

	public void callRandomAccessFileRead()
	{
		StringWriter sWriter = new StringWriter();
		PrintWriter pWriter = new PrintWriter(sWriter);

		try
		{

			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			int l = 0, isend = 0;
			String buffers = "", ascii = "", s = "";
			int v = 0;
			while (isend < raf.length())
			{
				v = raf.readByte();
				s = Integer.toHexString(v);
				if (s.length() == 1)
					s = "0" + s;
				buffers = buffers + s + " ";
				if (v != 10 && v != 13)
					ascii = ascii + String.valueOf((char) v);
				else
					ascii = ascii + ".";
				l++;
				isend++;
				if (l >= 16)
				{
					l = 0;
					pWriter.println(buffers + " " + ascii);
					buffers = "";
					ascii = "";
				}
			}
			pWriter.println(buffers + " " + ascii);

			raf.close();
		}
		catch (IOException ioe)
		{
		}
	}
}
