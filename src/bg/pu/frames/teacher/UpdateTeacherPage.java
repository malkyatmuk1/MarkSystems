package bg.pu.frames.teacher;

import bg.pu.entity.Teacher;
import bg.pu.panels.teacher.UpdateTeacherPanel;

import javax.swing.*;
import java.awt.*;

public class UpdateTeacherPage extends JFrame {
  public void displayUpdateTeacherPage(Teacher teacher) {

    GridLayout gridLayout = new GridLayout(5, 1);
    this.setLayout(gridLayout);
    gridLayout.layoutContainer(this);
    this.add(new UpdateTeacherPanel(teacher));
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(screenSize.width, screenSize.height);
    this.setVisible(true);
  }
}
