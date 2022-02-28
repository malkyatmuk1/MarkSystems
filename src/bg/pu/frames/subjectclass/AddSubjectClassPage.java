package bg.pu.frames.subjectclass;

import bg.pu.entity.Subjects;
import bg.pu.panels.subjectclass.AddSubjectClassPanel;

import javax.swing.*;
import java.awt.*;

public class AddSubjectClassPage extends JFrame {
  public void displayAddSubjectClassPage(Subjects subject) {
    GridLayout gridLayout = new GridLayout(4, 1);
    this.setLayout(gridLayout);
    gridLayout.layoutContainer(this);
    this.add(new AddSubjectClassPanel(subject));
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(screenSize.width, screenSize.height);
    this.setVisible(true);
  }
}
