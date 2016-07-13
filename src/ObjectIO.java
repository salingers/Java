

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ObjectIO extends Frame implements MouseListener {
   private Label id_Label, data_Label;
   private TextField id_TF, data_TF;
   private Button input_Button, output_Button;

  public ObjectIO(String title) {
    super(title);

    id_Label=new Label("",Label.CENTER);
    data_Label=new Label("",Label.CENTER);
    id_TF=new TextField("");
    data_TF=new TextField("");
    input_Button=new Button("讀出物件");
    output_Button=new Button("寫入物件");

    input_Button.addMouseListener(this);
    output_Button.addMouseListener(this);

    this.setLayout(new GridLayout(2,3,10,10));
//    this.add(new Label("ID"));
    this.add(id_Label);
    this.add(data_Label);
    this.add(input_Button);
//    this.add(new Label("Data"));
    this.add(id_TF);
    this.add(data_TF);
    this.add(output_Button);
  }


  public static void main(String[] args) {
     ObjectIO o=new ObjectIO("TEST");
     o.setSize(250,120);
     o.setVisible(true);
  }

  public Insets getInsets() {
    return new Insets(40,20,30,50);
  }

  private void readData() {
   PersonData pd=new PersonData();
   try {
     FileInputStream fis=new FileInputStream("test.txt");
     ObjectInputStream ois=new ObjectInputStream(fis);
     pd=(PersonData)ois.readObject();
     ois.close();
   }
   catch (OptionalDataException od) {}
   catch (ClassNotFoundException cfe) {}
   catch (IOException ioe) { System.out.println(ioe.toString());}
   id_Label.setText(String.valueOf(pd.getId()));
   data_Label.setText(pd.getData());
 }

  private void writeData() {
    PersonData pd=new PersonData();
    pd.setId(Integer.parseInt(id_TF.getText()));
    pd.setData(data_TF.getText());

   try {
    FileOutputStream fos=new FileOutputStream("test.txt");
    ObjectOutputStream oos=new ObjectOutputStream (fos);
      oos.writeObject(pd);
      oos.close();
   }
   catch (IOException ioe) { System.out.println(ioe.toString());}
  }

  public void mouseClicked(MouseEvent e) {
    Button b=(Button)e.getSource();
    if(b.getLabel()==input_Button.getLabel()) {
     readData();
    }
    else if (b.getLabel()==output_Button.getLabel()){
     writeData();
    }
  }
  public void mousePressed(MouseEvent e) { }
  public void mouseReleased(MouseEvent e) { }
  public void mouseEntered(MouseEvent e) { }
  public void mouseExited(MouseEvent e) { }
}

class PersonData implements Serializable{
  int id=1;
  String data="A";
  public void setId(int id) { this.id=id; }
  public int getId() {return id;}
  public void setData(String s) {this.data=s; }
  public String getData() { return data; }
}

