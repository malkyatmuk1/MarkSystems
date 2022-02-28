package bg.pu.frames.students;

import bg.pu.entity.ClassOfStudents;
import bg.pu.panels.students.AddStudentPanel;

import javax.swing.*;
import java.awt.*;

public class AddStudentPage extends JFrame {

  public void displayAddStudentPage(ClassOfStudents classOfStudents) {
    GridLayout gridLayout = new GridLayout(5, 1);
    this.setLayout(gridLayout);
    gridLayout.layoutContainer(this);
    this.add(new AddStudentPanel(classOfStudents));
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(screenSize.width, screenSize.height);
    this.setVisible(true);
  }
}
