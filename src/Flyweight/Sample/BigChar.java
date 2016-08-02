package Flyweight.Sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BigChar
{
	// �r���W��
	private char charname;
	// ��X���j����r���r��]��'#' '.' '\n'����^
	private String fontdata;

	// �غc�l
	public BigChar(char charname)
	{
		this.charname = charname;
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("big" + charname + ".txt"));
			String line;
			StringBuffer buf = new StringBuffer();
			while ((line = reader.readLine()) != null)
			{
				buf.append(line);
				buf.append("\n");
			}
			reader.close();
			this.fontdata = buf.toString();
		}
		catch (IOException e)
		{
			this.fontdata = charname + "?";
		}
	}

	// ��X�j����r
	public void print()
	{
		System.out.print(fontdata);
	}
}
