package bg.pu.frames.subjects;

import bg.pu.entity.Subjects;
import bg.pu.panels.classes.UpdateSubjectPanel;
import bg.pu.panels.students.AddStudentPanel;

import javax.swing.*;
import java.awt.*;

public class UpdateSubjectPage extends JFrame {
    public void displayUpdateSubjecPage(Subjects subjects) {
        GridLayout gridLayout = new GridLayout(5, 1);
        this.setLayout(gridLayout);
        gridLayout.layoutContainer(this);
        this.add(new UpdateSubjectPanel(subjects));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setVisible(true);
    }
}
