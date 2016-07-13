

import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveFile extends Frame implements ActionListener {
  TextArea textArea=new TextArea();
  FileDialog  file_dialog=new  FileDialog(new Frame(),"ÀÉ®×");
  File file;
  Button btn=new Button("Àx¦sÀÉ®×");

  public SaveFile() {
    btn.addActionListener(this);
    this.setLayout(new BorderLayout());
    this.add("Center",textArea);
    this.add("South",btn);
  }

  public static void main(String[] args) {
    SaveFile sf=new SaveFile();
    sf.setSize(300,300);
    sf.setVisible(true);
  }

 public void callFileOutputStream() {  //Ok for save file!
       file_dialog.setMode(FileDialog.SAVE);
       file_dialog.setVisible(true);
       file=new File(file_dialog.getFile());
       FileOutputStream  fileOut;
       OutputStreamWriter  Osw;
       
     try { 
          fileOut=new  FileOutputStream(file); 
          String s=textArea.getText();
           int l=s.length();
           int i=0;
           try { Osw=new  OutputStreamWriter (fileOut);
                   while (i<l) {
                   Osw.write(s,i,1);
                    i++; }
                   Osw.flush(); 
                  }         
           catch (IOException io) {} 
 
           try {fileOut.close(); }
           catch (IOException io) {}
          }
       catch (IOException io) {}
  }

  public void actionPerformed(ActionEvent e) {
     callFileOutputStream();
  }
}
