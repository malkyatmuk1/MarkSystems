package bg.pu.frames.teacher;

import bg.pu.panels.teacher.AddTeacherPanel;

import javax.swing.*;
import java.awt.*;

public class AddTeacherPage extends JFrame {
  public void displayAddTeacherPage() {
    GridLayout gridLayout = new GridLayout(5, 1);
    this.setLayout(gridLayout);
    gridLayout.layoutContainer(this);
    this.add(new AddTeacherPanel());
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(screenSize.width, screenSize.height);
    this.setVisible(true);
  }
}
