package bg.pu.panels.classes;

import javax.swing.*;

public class ClassInfoPanel extends JPanel {
    private JLabel firstLable;
    private JLabel secondLable;
    public ClassInfoPanel(String teacherName, String className){
        firstLable = new JLabel("Class " + className);
        secondLable = new JLabel("bg.pu.entity.Teacher - " + teacherName);
        this.add(firstLable);
        this.add(secondLable);
    }

}
