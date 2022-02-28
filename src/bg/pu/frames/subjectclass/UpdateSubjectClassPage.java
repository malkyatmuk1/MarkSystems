package bg.pu.frames.subjectclass;

import bg.pu.entity.SubjectClass;
import bg.pu.panels.subjectclass.UpdateSubjectClassPanel;

import javax.swing.*;
import java.awt.*;

public class UpdateSubjectClassPage extends JFrame {
  public void displayUpdateSubjectClassPage(SubjectClass subjectClass) {
    GridLayout gridLayout = new GridLayout(4, 1);
    this.setLayout(gridLayout);
    gridLayout.layoutContainer(this);
    this.add(new UpdateSubjectClassPanel(subjectClass));
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(screenSize.width, screenSize.height);
    this.setVisible(true);
  }
}
