package bg.pu.panels.classes;
import bg.pu.entity.ClassOfStudents;
import bg.pu.frames.classes.ClassMenuPage;
import bg.pu.frames.classes.UpdateClassPage;
import bg.pu.frames.students.StudentClassPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassMenuPanel extends JPanel {
    private JButton buttonClassStudents = new JButton("View Students of the class");
    private JButton buttonUpdateClass = new JButton("Update class");
    private JButton buttonDeleteClass = new JButton("Delete class");

    DataService dataService = new DataService();
    public ClassMenuPanel(ClassOfStudents classOfStudents){
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(buttonClassStudents, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(buttonUpdateClass, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        this.add(buttonDeleteClass, gbc);
        buttonUpdateClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ClassMenuPanel.this);
                frame.dispose();
                UpdateClassPage classPage = new UpdateClassPage();
                classPage.displayUpdateClassPage(classOfStudents);
            }
        });
        buttonDeleteClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO ask if is the user is sure to delete the teacher
                dataService.deleteClass(classOfStudents);
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ClassMenuPanel.this);
                frame.dispose();
                ClassMenuPage classMenuPage = new ClassMenuPage();
                classMenuPage.displayClassMenuPage(classOfStudents);
            }
        });
        buttonClassStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentClassPage studentClassPage = new StudentClassPage();
                studentClassPage.displayStudentClassPage(classOfStudents);
            }
        });
    }

}

