package bg.pu.panels.classes;
import bg.pu.entity.ClassOfStudents;
import bg.pu.frames.classes.UpdateClassPage;
import bg.pu.frames.students.StudentClassPage;
import bg.pu.frames.teacher.FirstPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;

public class ClassMenuPanel extends JPanel {
    private JButton buttonClassStudents = new JButton("View Students of the class");
    private JButton buttonUpdateClass = new JButton("Update class");
    private JButton buttonDeleteClass = new JButton("Delete class");
    private JButton returnBackButton = new JButton("Back");

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
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        this.add(returnBackButton, gbc);
        buttonUpdateClass.addActionListener(e -> {
            UpdateClassPage classPage = new UpdateClassPage();
            classPage.displayUpdateClassPage(classOfStudents);
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ClassMenuPanel.this);
            frame.dispose();
        });
        buttonDeleteClass.addActionListener(e -> {
            //TODO ask if is the user is sure to delete the teacher
            dataService.deleteClass(classOfStudents);
            FirstPage firstPage = new FirstPage();
            firstPage.displayFirstPage(dataService.getAllTeachers(), dataService.getAllClass());
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ClassMenuPanel.this);
            frame.dispose();
        });
        buttonClassStudents.addActionListener(e -> {
            StudentClassPage studentClassPage = new StudentClassPage();
            studentClassPage.displayStudentClassPage(classOfStudents);
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ClassMenuPanel.this);
            frame.dispose();
        });
        returnBackButton.addActionListener(e -> {
            FirstPage firstPage = new FirstPage();
            firstPage.displayFirstPage(dataService.getAllTeachers(), dataService.getAllClass());
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ClassMenuPanel.this);
            frame.dispose();
        });
    }

}

