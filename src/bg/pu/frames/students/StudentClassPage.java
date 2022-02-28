package bg.pu.frames.students;

import bg.pu.entity.ClassOfStudents;
import bg.pu.panels.students.StudentsTablePanel;

import javax.swing.*;
import java.awt.*;

public class StudentClassPage extends JFrame {
  public void displayStudentClassPage(ClassOfStudents classOfStudents) {

    GridLayout gridLayout = new GridLayout(5, 1);
    this.setLayout(gridLayout);
    gridLayout.layoutContainer(this);
    this.add(new StudentsTablePanel(classOfStudents));
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(screenSize.width, screenSize.height);
    this.setVisible(true);
  }
}
