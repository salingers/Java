
//Title:        Your Product Name
//Version:      
//Copyright:    Copyright (c) 1998
//Author:       REX
//Company:      
//Description:  Your description



import java.beans.*;

public class Bean1BeanInfo extends SimpleBeanInfo {
/*
  Class beanClass = Bean1.class;
  String iconColor16x16Filename;
  String iconColor32x32Filename;
  String iconMono16x16Filename;
  String iconMono32x32Filename;*/


  public Bean1BeanInfo() {}

  public BeanDescriptor getBeanDescriptor() {
     return new BeanDescriptor(Bean1.class,
                    Bean1Customizer.class);
  }
/*
  public PropertyDescriptor[] getPropertyDescriptors() {
    try  {
      PropertyDescriptor _data = new PropertyDescriptor("data", beanClass, "getData", "setData");

      PropertyDescriptor _dataTitle = new PropertyDescriptor("dataTitle", beanClass, "getDataTitle", "setDataTitle");

      PropertyDescriptor _preferredSize = new PropertyDescriptor("preferredSize", beanClass, "getPreferredSize", null);

      PropertyDescriptor _showColor = new PropertyDescriptor("showColor", beanClass, "getShowColor", "setShowColor");

      PropertyDescriptor _title = new PropertyDescriptor("title", beanClass, "getTitle", "setTitle");

      PropertyDescriptor[] pds = new PropertyDescriptor[] {
        _data,
        _dataTitle,
        _preferredSize,
        _showColor,
        _title,
      };
      return pds;
    }
    catch (IntrospectionException ex) {
      ex.printStackTrace();
      return null;
    }
  }

 static {PropertyEditorManager.registerEditor(MyDate.class,MyDateEditor.class);}

  public java.awt.Image getIcon(int iconKind) {
    switch (iconKind) {
    case BeanInfo.ICON_COLOR_16x16:
      return iconColor16x16Filename != null ? loadImage(iconColor16x16Filename) : null;
    case BeanInfo.ICON_COLOR_32x32:
      return iconColor32x32Filename != null ? loadImage(iconColor32x32Filename) : null;
    case BeanInfo.ICON_MONO_16x16:
      return iconMono16x16Filename != null ? loadImage(iconMono16x16Filename) : null;
    case BeanInfo.ICON_MONO_32x32:
      return iconMono32x32Filename != null ? loadImage(iconMono32x32Filename) : null;
    }
    return null;
  }*/
}


 