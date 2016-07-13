

import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UseBuffer extends Frame implements ActionListener
{
		TextArea textArea = new TextArea();
		FileDialog file_dialog = new FileDialog(new Frame(), "檔案");
		File file;
		Button btn = new Button("開啟檔案");

		public UseBuffer(String s)
		{
				super(s);
				btn.addActionListener(this);
				this.setLayout(new BorderLayout());
				this.add("Center", textArea);
				this.add("South", btn);
		}

		public static void main(String[] args)
		{
				UseBuffer ub = new UseBuffer("使用暫存區開啟檔案");
				ub.setSize(300, 300);
				ub.setVisible(true);
		}

		public void callFileReader()
		{ // OK for read File!
				StringWriter sWriter = new StringWriter();
				PrintWriter pWriter = new PrintWriter(sWriter);
				file_dialog.setMode(FileDialog.LOAD);
				file_dialog.setVisible(true);
				file = new File(file_dialog.getFile());
				try
				{
						FileReader fReader = new FileReader(file);
						BufferedReader bReader = new BufferedReader(fReader);
						String s;
						while ((s = bReader.readLine()) != null)
						{
								pWriter.println(s);
						}
						bReader.close();
				} catch (IOException ioe)
				{
				}
				textArea.setText(sWriter.toString());
		}

		public void actionPerformed(ActionEvent e)
		{
				callFileReader();
		}
}
