
import java.beans.*;

public class BasicCustomerBeanInfo extends SimpleBeanInfo {
  Class beanClass = BasicCustomer.class;

  public BasicCustomerBeanInfo() {}

  public BeanDescriptor getBeanDescriptor() {
     return new BeanDescriptor(BasicCustomer.class,
                    MyCustomizer.class);
  }

  public PropertyDescriptor[] getPropertyDescriptors() {
    try  {
      PropertyDescriptor style = new PropertyDescriptor("style", beanClass, "getStyle", "setStyle");
      style.setDisplayName("字形模式");
      style.setShortDescription("style");
      style.setBound(true);

      PropertyDescriptor text = new PropertyDescriptor("text", beanClass, "getText", "setText");
      text.setDisplayName("文字");
      text.setShortDescription("text");
      text.setBound(true);

      PropertyDescriptor textColor = new PropertyDescriptor("textColor", beanClass, "getTextColor", "setTextColor");
      textColor.setDisplayName("顏色");
      textColor.setShortDescription("textColor");

     return  new PropertyDescriptor[] { style,text,textColor, };
    }
    catch (IntrospectionException ex) {
      ex.printStackTrace();
      return null;
    }
  }
}


 