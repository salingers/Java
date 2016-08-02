
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class HexIO extends Frame
{
	MenuBar menuBar = new MenuBar();
	Menu menuFile = new Menu("檔案");
	MenuItem fileOpen = new MenuItem("開啟舊檔");
	MenuItem fileExit = new MenuItem("結束");

	TextArea textArea;
	FileDialog file_dialog;
	File file;

	public static void main(String args[])
	{
		HexIO h = new HexIO("十六進位的檔案編輯器");
		h.setSize(300, 300);
		h.show();
	}

	public HexIO(String title)
	{
		super(title);

		textArea = new TextArea("", 10, 15, TextArea.SCROLLBARS_BOTH);
		file_dialog = new FileDialog(new Frame(), "檔案");

		menuFile.add(fileOpen);
		menuFile.add(fileExit);
		menuBar.add(menuFile);
		this.setMenuBar(menuBar);
		this.add(textArea);

		fileOpen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				callRandomAccessFileRead();
			}
		});

		fileExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				System.exit(0);
			}
		});

	}

	public void callRandomAccessFileRead()
	{
		StringWriter sWriter = new StringWriter();
		PrintWriter pWriter = new PrintWriter(sWriter);

		file_dialog.setMode(FileDialog.LOAD);
		file_dialog.setVisible(true);
		file = new File(file_dialog.getDirectory() + file_dialog.getFile());

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
			textArea.setText(sWriter.toString());
			raf.close();
		}
		catch (IOException ioe)
		{
		}
	}
}
