package bg.pu;

import javax.swing.*;

public class TabbedPane extends JTabbedPane {
  private int indexStudent;

  public TabbedPane(int indexStudent) {
    super();
    this.indexStudent = indexStudent;
  }

  public int getIndexStudent() {
    return indexStudent;
  }

  public void setIndexStudent(int indexStudent) {
    this.indexStudent = indexStudent;
  }
}
