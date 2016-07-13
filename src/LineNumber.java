
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class LineNumber extends Frame implements ActionListener
{
		TextArea textArea = new TextArea();
		FileDialog file_dialog = new FileDialog(new Frame(), "ÀÉ®×");
		File file;
		Button btn = new Button("¶}±ÒÀÉ®×");

		public LineNumber()
		{
				btn.addActionListener(this);
				this.setLayout(new BorderLayout());
				this.add("Center", textArea);
				this.add("South", btn);
		}

		public static void main(String[] args)
		{
				LineNumber ln = new LineNumber();
				ln.setSize(300, 300);
				ln.setVisible(true);
		}

		public void callLineNumberReader()
		{ // Ok for read file
				file_dialog.setMode(FileDialog.LOAD);
				file_dialog.setVisible(true);
				file = new File(file_dialog.getFile());

				try
				{
						FileInputStream fileIn = new FileInputStream(file);
						InputStreamReader filereader = new InputStreamReader(fileIn);
						LineNumberReader linereader = new LineNumberReader(filereader);
						boolean iseof = false;
						try
						{
								while (!iseof)
								{
										try
										{
												textArea.append(linereader.readLine());
												textArea.append("\n");
										} catch (EOFException eof)
										{
												iseof = true;
										}
								}
						} catch (IOException io)
						{
						}
						fileIn.close();
				} catch (FileNotFoundException f)
				{
				} catch (IOException io)
				{
				}
		}

		public void actionPerformed(ActionEvent e)
		{
				callLineNumberReader();
		}
}
