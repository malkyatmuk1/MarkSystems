package bg.pu.frames.grade;

import bg.pu.entity.Student;
import bg.pu.panels.grade.MarksPanel;

import javax.swing.*;
import java.awt.*;

public class GradeTablePage extends JFrame {
  public void displayGradePage(Student student) {

    GridLayout gridLayout = new GridLayout(4, 1);
    this.setLayout(gridLayout);
    gridLayout.layoutContainer(this);
    this.add(new MarksPanel(student));
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(screenSize.width, screenSize.height);
    this.setVisible(true);
  }
}
