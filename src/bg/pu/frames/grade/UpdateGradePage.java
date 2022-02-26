package bg.pu.frames.grade;

import bg.pu.entity.Grade;
import bg.pu.entity.Student;
import bg.pu.panels.grade.MarksPanel;
import bg.pu.panels.grade.UpdateGradePanel;

import javax.swing.*;
import java.awt.*;

public class UpdateGradePage extends JFrame {
    public void displayUpdateGradePage(Grade grade){
        GridLayout gridLayout = new GridLayout(5, 1);
        this.setLayout(gridLayout);
        gridLayout.layoutContainer(this);
        this.add(new UpdateGradePanel(grade));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setVisible(true);
    }
}
