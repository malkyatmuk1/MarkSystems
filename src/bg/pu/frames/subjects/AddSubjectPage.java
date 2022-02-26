package bg.pu.frames.subjects;

import bg.pu.entity.Subjects;
import bg.pu.panels.students.AddStudentPanel;
import bg.pu.panels.subjects.AddSubjectPanel;

import javax.security.auth.Subject;
import javax.swing.*;
import java.awt.*;

public class AddSubjectPage extends JFrame {
    public void displayAddSubjectPage() {
        GridLayout gridLayout = new GridLayout(5, 1);
        this.setLayout(gridLayout);
        gridLayout.layoutContainer(this);
        this.add(new AddSubjectPanel());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setVisible(true);
    }
}
