

import java.beans.*;
import java.awt.*;
import java.awt.event.*;

public class Bean1Customizer extends Panel implements Customizer, MouseListener, ActionListener, AdjustmentListener{
   private Panel pLeft, pRight, pButtom;
   private Button preBtn, nextBtn, addBtn, removeBtn,okBtn;
   private Scrollbar rScroll, gScroll, bScroll, dataScroll;
   private TextField titleTF;
   private Label colorLab, dataLab;
   private Bean1 bean;
   private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
   private String titleData[];
   private Color colorData[];
   private int valueData[];
   private int curData=0;
   private int len=2;

  public Bean1Customizer() {

   preBtn=new Button("pre");
   nextBtn=new Button("next");
   addBtn=new Button("add");
   removeBtn=new Button("remove");
   okBtn=new Button("update");
   preBtn.addActionListener(this);
   nextBtn.addActionListener(this);
   addBtn.addActionListener(this);
   removeBtn.addActionListener(this);
   okBtn.addActionListener(this);

   pButtom=new Panel(new GridLayout(1,5));
   pButtom.add(preBtn);
   pButtom.add(nextBtn);
   pButtom.add(addBtn);
   pButtom.add(removeBtn);
   pButtom.add(okBtn);

   colorLab=new Label("setCOLOR",Label.CENTER);
   rScroll=new Scrollbar(Scrollbar.HORIZONTAL,0,0,0,256);
   gScroll=new Scrollbar(Scrollbar.HORIZONTAL,0,0,0,256);
   bScroll=new Scrollbar(Scrollbar.HORIZONTAL,0,0,0,256);
   rScroll.addAdjustmentListener(this);
   gScroll.addAdjustmentListener(this);
   bScroll.addAdjustmentListener(this);

   pRight=new Panel(new GridLayout(4,1));
   pRight.add(colorLab);
   pRight.add(rScroll);
   pRight.add(gScroll);
   pRight.add(bScroll);

   titleTF=new TextField("");
   dataLab=new Label("Data",Label.CENTER);
   dataScroll=new Scrollbar(Scrollbar.HORIZONTAL,0,0,1,1000);
   dataScroll.addAdjustmentListener(this);

   pLeft=new Panel(new GridLayout(3,1));
   pLeft.add(titleTF);
   pLeft.add(dataLab);
   pLeft.add(dataScroll);

   this.setLayout(new BorderLayout());
   add("Center",pLeft);
   add("East",pRight);
   add("South",pButtom);

 /*  len=10;
    valueData=new int[len];
    colorData=new Color[len];
    titleData=new String[len];
   for(int i=0;i<len;i++) {
     valueData[i]=i+1;
     colorData[i]=new Color(0,0,i*255/10);
     titleData[i]=String.valueOf((i+1)*(i+1));
   }
   setData(curData);*/
  }

  public static void main(String args[]) {
    Frame f=new Frame("TEST");
    f.add(new Bean1Customizer());
    f.setSize(200,100);
    f.setVisible(true);
  }

  public void setObject(Object obj) {
    bean=(Bean1)obj;
    titleData=bean.getDataTitle();
    colorData=bean.getShowColor();
    valueData=bean.getData();
    len=titleData.length;
    setData(curData);
  }

  private void setData(int id) {
   if(0<=id &&id<valueData.length) {
    titleTF.setText(titleData[id]);
    dataLab.setText(String.valueOf(valueData[id]));
    dataScroll.setValue(valueData[id]);

    rScroll.setValue(colorData[id].getRed());
    gScroll.setValue(colorData[id].getGreen());
    bScroll.setValue(colorData[id].getBlue());
    colorLab.setBackground(colorData[id]);
   }
  }

  private void updateData() {
    titleData[curData]=titleTF.getText();
    valueData[curData]=dataScroll.getValue();
    colorData[curData]=colorLab.getBackground();
    saveData();
  }

  private void saveData() {
    int oldData[]=bean.getData();
    bean.setData(valueData);
    pcs.firePropertyChange("Data", oldData, valueData);

    String oldTitle[]=bean.getDataTitle();
    bean.setDataTitle(titleData);
    pcs.firePropertyChange("DataTitle",oldTitle,titleData);

    Color oldColor[]=bean.getShowColor();
    bean.setShowColor(colorData);
    pcs.firePropertyChange("ShowColor",oldColor,colorData);
  }

  public void addData() {
     String titleTemp[]=new String[len];
     Color colorTemp[]=new Color[len];
     int valueTemp[]=new int[len];

     titleTemp=titleData;
     colorTemp=colorData;
     valueTemp=valueData;

     len++;
     titleData=new String[len];
     valueData=new int[len];
     colorData=new Color[len];

     for(int i=0;i<len-1;i++) {
      titleData[i]=titleTemp[i];
      colorData[i]=colorTemp[i];
      valueData[i]=valueTemp[i];
     }

      curData=len-1;
      titleData[curData]="New Data";
      valueData[curData]=1;
      colorData[curData]=Color.red;

      setData(curData);
      saveData();
  }

  public void removeData() {
     String titleTemp[]=new String[titleData.length];
     Color colorTemp[]=new Color[colorData.length];
     int valueTemp[]=new int[valueData.length];

     titleTemp=titleData;
     colorTemp=colorData;
     valueTemp=valueData;

     len--;
     titleData=null;
     valueData=null;
     colorData=null;

     titleData=new String[len];
     valueData=new int[len];
     colorData=new Color[len];

     for(int i=0;i<len+1;i++) {
      if(i<curData) {
        titleData[i]=titleTemp[i];
        colorData[i]=colorTemp[i];
        valueData[i]=valueTemp[i];
      }
     else if(i==curData) {
        System.out.println("Delete "+i);
     }
     else if(i>curData) {
        titleData[i-1]=titleTemp[i];
        colorData[i-1]=colorTemp[i];
        valueData[i-1]=valueTemp[i];
      }
     }
      if (curData>=valueData.length) curData=0;
      setData(curData);
      saveData();
  }

 public void addPropertyChangeListener (PropertyChangeListener l) {
    pcs.addPropertyChangeListener(l);
 }

 public void removePropertyChangeListener (PropertyChangeListener l) {
    pcs.removePropertyChangeListener(l);
 }
  public void mouseClicked(MouseEvent e) {}
  public void mousePressed(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}
  public void actionPerformed(ActionEvent e) {
   Button b;
    b=(Button)e.getSource();

    if(b.getLabel()==preBtn.getLabel()) {
      curData=curData-1;
      if (curData<0) curData=len-1;
      setData(curData);
    }
    else if(b.getLabel()==nextBtn.getLabel()) {
      curData=curData+1;
      if (curData>=len) curData=0;
      setData(curData);
    }
    else if(b.getLabel()==addBtn.getLabel()) {
      addData();
    }
    else if(b.getLabel()==removeBtn.getLabel()) {
     if(len>1)  removeData();
    }
    else if(b.getLabel()==okBtn.getLabel()) {
     updateData();
    }
  }
  public void adjustmentValueChanged(AdjustmentEvent e) {
    Scrollbar sb;
    sb=(Scrollbar)e.getSource();

    if(sb.getName()==rScroll.getName()) {
     Color c=colorLab.getBackground();
     colorLab.setBackground(new Color(e.getValue(),c.getGreen(),c.getBlue()));
    }
    else if(sb.getName()==gScroll.getName()) {
     Color c=colorLab.getBackground();
     colorLab.setBackground(new Color(c.getRed(),e.getValue(),c.getBlue()));
    }
    else if(sb.getName()==bScroll.getName()) {
     Color c=colorLab.getBackground();
     colorLab.setBackground(new Color(c.getRed(),c.getGreen(),e.getValue()));
    }
    else if(sb.getName()==dataScroll.getName()) {
     dataLab.setText(String.valueOf(e.getValue()));
    }
  }
}