package bg.pu.frames.subjectclass;

import bg.pu.panels.subjectclass.SubjectClassTablePanel;

import javax.swing.*;
import java.awt.*;

public class SubjectClassTablePage extends JFrame {
  public void displaySubjectClassTablePage() {
    GridLayout gridLayout = new GridLayout(4, 1);
    this.setLayout(gridLayout);
    gridLayout.layoutContainer(this);
    this.add(new SubjectClassTablePanel());
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(screenSize.width, screenSize.height);
    this.setVisible(true);
  }
}
