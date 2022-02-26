package bg.pu.frames.students;

import bg.pu.entity.Student;
import bg.pu.panels.classes.UpdateClassPanel;
import bg.pu.panels.students.UpdateStudentPanel;

import javax.swing.*;
import java.awt.*;
import java.util.jar.JarFile;

public class UpdateStudentPage extends JFrame {
    public void displayStudentPage(Student student) {
        GridLayout gridLayout = new GridLayout(4, 1);
        this.setLayout(gridLayout);
        gridLayout.layoutContainer(this);
        this.add(new UpdateStudentPanel(student));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setVisible(true);
    }
}
