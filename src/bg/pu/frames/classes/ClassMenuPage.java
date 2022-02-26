package bg.pu.frames.classes;

import bg.pu.entity.ClassOfStudents;
import bg.pu.panels.classes.ClassMenuPanel;

import javax.swing.*;
import java.awt.*;

public class ClassMenuPage extends JFrame {
    public void displayClassMenuPage(ClassOfStudents classOfStudents){
        GridLayout gridLayout = new GridLayout(5, 1);
        this.setLayout(gridLayout);
        gridLayout.layoutContainer(this);
//        this.add(new ClassInfoPanel(teacherName, className));
//        this.add(new StudentsTablePanel(studentArrayList));
        this.add(new ClassMenuPanel(classOfStudents));
        //this.add(new UpdateTeacherPanel(teacher));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setVisible(true);
    }
}
