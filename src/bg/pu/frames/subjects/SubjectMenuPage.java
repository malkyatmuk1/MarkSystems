package bg.pu.frames.subjects;

import bg.pu.entity.Subjects;
import bg.pu.panels.subjects.SubjectMenuPanel;

import javax.swing.*;
import java.awt.*;

public class SubjectMenuPage extends JFrame {
    public void displaySubjectMenuPage(Subjects subjects) {
        GridLayout gridLayout = new GridLayout(5, 1);
        this.setLayout(gridLayout);
        gridLayout.layoutContainer(this);
        this.add(new SubjectMenuPanel(subjects));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setVisible(true);
    }
}
