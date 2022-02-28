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
        this.add(new ClassMenuPanel(classOfStudents));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setVisible(true);
    }
}
