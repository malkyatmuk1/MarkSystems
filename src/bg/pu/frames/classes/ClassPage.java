package bg.pu.frames.classes;

import bg.pu.panels.classes.AddClassPanel;

import javax.swing.*;
import java.awt.*;

public class ClassPage extends JFrame {
    public void displayClassPage(){

        GridLayout gridLayout = new GridLayout(5, 1);
        this.setLayout(gridLayout);
        gridLayout.layoutContainer(this);
        this.add(new AddClassPanel());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setVisible(true);
    }
}
