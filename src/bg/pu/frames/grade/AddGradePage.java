package bg.pu.frames.grade;

import bg.pu.entity.Student;
//import bg.pu.panels.grade.AddGradePanel;
import bg.pu.panels.grade.AddGradePanel;
import bg.pu.panels.grade.MarksPanel;

import javax.swing.*;
import java.awt.*;

public class AddGradePage extends JFrame {
    public void displayAddGradePage(Student student){
        GridLayout gridLayout = new GridLayout(5, 1);
        this.setLayout(gridLayout);
        gridLayout.layoutContainer(this);
        this.add(new AddGradePanel(student));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setVisible(true);
    }
}
