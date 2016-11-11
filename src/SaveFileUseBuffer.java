
import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveFileUseBuffer extends Frame implements ActionListener
{
	TextArea textArea = new TextArea();
	FileDialog file_dialog = new FileDialog(new Frame(), "檔案");
	File file;
	Button btn = new Button("儲存檔案");

	public SaveFileUseBuffer(String s)
	{
		super(s);
		btn.addActionListener(this);
		this.setLayout(new BorderLayout());
		this.add("Center", textArea);
		this.add("South", btn);
	}

	public static void main(String[] args)
	{
		SaveFileUseBuffer sfub = new SaveFileUseBuffer("使用暫存區存檔");
		sfub.setSize(300, 300);
		sfub.setVisible(true);
	}

	public void callBufferedWriter()
	{ // Ok for save file!
		file_dialog.setMode(FileDialog.SAVE);
		file_dialog.setVisible(true);
		file = new File(file_dialog.getFile());
		try
		{
			BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));
			String s = textArea.getText();
			bWriter.write(s, 0, s.length());
			bWriter.flush();
			bWriter.close();
		}
		catch (IOException ioe)
		{
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		callBufferedWriter();
	}
}