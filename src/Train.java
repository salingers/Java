// ���������d��(Train.java)
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Train extends Applet implements ItemListener
{
  CheckboxGroup myCheckboxGroup;
  Checkbox myCheckbox1,myCheckbox2,myCheckbox3,myCheckbox4;
  Choice myChoice1,myChoice2;
  Panel myPanel,myPanel2;
  Label myLabel;
   public void init()
   {
    this.setLayout(new GridLayout(1,2));
    Color c = new Color(150,150,150);
    myPanel = new Panel();
    myPanel2 = new Panel();
    myPanel.setLayout(new GridLayout(4,1));
    myPanel2.setLayout(new GridLayout(6,1));
    myCheckboxGroup = new CheckboxGroup();
    myCheckbox1 = new Checkbox("�۱j��",myCheckboxGroup,true);  //Checkbox(���ئW��,�s�զW��,������A)
    myCheckbox2 = new Checkbox("������",myCheckboxGroup,false);
    myCheckbox3 = new Checkbox("�_����",myCheckboxGroup,false);
    myCheckbox4 = new Checkbox("����",myCheckboxGroup,false);
    myChoice1 = new Choice();
    myChoice2 = new Choice();
    myLabel = new Label("0��");
    myPanel.add(myCheckbox1);
    myPanel.add(myCheckbox2);
    myPanel.add(myCheckbox3);
    myPanel.add(myCheckbox4);
    myCheckbox1.setBackground(c);
    myCheckbox2.setBackground(c);
    myCheckbox3.setBackground(c);
    myCheckbox4.setBackground(c);
    myChoice1.addItem("�x�_");
    myChoice1.addItem("�s��");
    myChoice1.addItem("�x��");
    myChoice1.addItem("�x�n");
    myChoice1.addItem("����");
    myChoice2.addItem("�x�_");
    myChoice2.addItem("�s��");
    myChoice2.addItem("�x��");
    myChoice2.addItem("�x�n");
    myChoice2.addItem("����");
    myPanel2.add(new Label("�_�I:"));
    myPanel2.add(myChoice1);
    myPanel2.add(new Label("���I:"));
    myPanel2.add(myChoice2);
    myPanel2.add(new Label("����:"));
    myPanel2.add(myLabel);
    add(myPanel);
    add(myPanel2);
    myCheckbox1.addItemListener(this);
    myCheckbox2.addItemListener(this);
    myCheckbox3.addItemListener(this);
    myCheckbox4.addItemListener(this);
    myChoice1.addItemListener(this);
    myChoice2.addItemListener(this);
   }
  public void itemStateChanged(ItemEvent theEv)
  {
    int start;  //�_�I���ޭ�
    int target; //���I���ޭ�
    double x=0; //�����B���
    int y=0;    //�_�I�P���I�t�Z��
    start = myChoice1.getSelectedIndex();
    target = myChoice2.getSelectedIndex();
    y = Math.abs(start-target);
    if (myCheckboxGroup.getSelectedCheckbox()==myCheckbox1)
    {
      x=1.8;
    }
    if (myCheckboxGroup.getSelectedCheckbox()==myCheckbox2)
    {
      x=1.5;
    }
    if (myCheckboxGroup.getSelectedCheckbox()==myCheckbox3)
    {
      x=1.3;
    }
    if (myCheckboxGroup.getSelectedCheckbox()==myCheckbox4)
    {
      x=1.0;
    }
    if (y!=0)
    {
      myLabel.setText(String.valueOf(50*x+100*y+20*x) + "��");
    }
    else
    {
      myLabel.setText("0��");
    }
  }
}
