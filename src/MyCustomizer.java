
import java.beans.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCustomizer extends Panel implements Customizer, ItemListener, ActionListener{
  private TextField tf;
  private CheckboxGroup cbg;
  private Checkbox cb[]=new Checkbox[4];
  private BasicCustomer myBean;
  private String title[]={"一般體","粗體","斜體","粗斜體",};

  public static void main(String s[]) {
    Frame f=new Frame("TEST");
    f.setSize(200,200);
    f.add(new MyCustomizer());
    f.setVisible(true);
  }

  public MyCustomizer() {
    Panel p1=new Panel();
    p1.setLayout(new GridLayout(3, 1,10,10));
    cbg = new CheckboxGroup();
    for(int i=0;i<cb.length;i++) {
     cb[i]= new Checkbox(title[i], cbg, false);
     cb[i].addItemListener(this);
     p1.add(cb[i]);
    }

    Panel p2=new Panel();
    tf=new TextField("text",10);
    tf.addActionListener(this);
    
    p2.setLayout(new GridLayout(2,1,10,10));
    p2.add(new Label("請輸入文字"));
    p2.add(tf);

    this.setLayout(new BorderLayout());
    this.add("North",p1);
    this.add("Center",p2);
  }

  public void setObject(Object bean) {
    myBean=(BasicCustomer)bean;

    int s=myBean.getStyle();
    if(s<cb.length)
      cb[s].setState(true);
    tf.setText(myBean.getText());
  }
  public void addPropertyChangeListener(PropertyChangeListener listener) {}
  public void removePropertyChangeListener(PropertyChangeListener listener) {}

  public void itemStateChanged(ItemEvent e) {
    Checkbox c=(Checkbox)e.getSource();
    if(c.getName()==cb[0].getName()) {
     myBean.setStyle(0);
    }
    else if(c.getName()==cb[1].getName()) {
     myBean.setStyle(1);
    }
    else if(c.getName()==cb[2].getName()) {
     myBean.setStyle(2);
    }
    else if(c.getName()==cb[3].getName()) {
     myBean.setStyle(3);
    }
  }

  public void actionPerformed(ActionEvent e) {
    myBean.setText(tf.getText());
  }
}