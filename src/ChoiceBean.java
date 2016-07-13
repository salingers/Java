

import java.awt.*;

public class ChoiceBean extends java.awt.Choice {
  public ChoiceBean() {
  }

  String selectItem[];
  
   public String[] getSelectItem() {
    return selectItem;
  }

  public void setSelectItem(String[] newSelectItem) {
    selectItem = newSelectItem;
    this.removeAll();
    for(int i=0;i<selectItem.length;i++) {
      this.addItem(selectItem[i]);
    }
  }

}

