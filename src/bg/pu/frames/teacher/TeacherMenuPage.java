package bg.pu.frames.teacher;

import bg.pu.entity.Teacher;
import bg.pu.panels.teacher.TeacherMenuPanel;

import javax.swing.*;
import java.awt.*;

public class TeacherMenuPage extends JFrame {
  public void displaySecondPage(Teacher teacher) {

    GridLayout gridLayout = new GridLayout(5, 1);
    this.setLayout(gridLayout);
    gridLayout.layoutContainer(this);
    this.add(new TeacherMenuPanel(teacher));
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(screenSize.width, screenSize.height);
    this.setVisible(true);
  }
}
