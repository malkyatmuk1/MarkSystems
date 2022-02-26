package bg.pu.panels.teacher;

import bg.pu.entity.Teacher;
import bg.pu.frames.classes.ClassPage;
import bg.pu.frames.teacher.FirstPage;
import bg.pu.frames.teacher.UpdateTeacherPage;
import bg.pu.panels.classes.ClassMenuPanel;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherMenuPanel extends JPanel {
    private JButton buttonGradeStudents = new JButton("View grades of the students");
    private JButton buttonUpdateTeacher = new JButton("Update teacher");
    private JButton buttonDeleteTeacher = new JButton("Delete teacher");
    DataService dataService = new DataService();
    public TeacherMenuPanel(Teacher teacher){
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(buttonGradeStudents, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(buttonUpdateTeacher, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        this.add(buttonDeleteTeacher, gbc);
        buttonUpdateTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateTeacherPage updateTecherPage = new UpdateTeacherPage();
                updateTecherPage.displayUpdateTeacherPage(teacher);
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(TeacherMenuPanel.this);
                frame.dispose();
            }
        });
        buttonDeleteTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO ask if is the user is sure to delete the teacher
                dataService.deleteTeacher(teacher);
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(TeacherMenuPanel.this);
                frame.dispose();
                FirstPage firstPage = new FirstPage();
                firstPage.displayFirstPage(dataService.getAllTeachers(), dataService.getAllClass());
            }
        });
        buttonGradeStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //TODO to the grade of students
            }
        });
    }

}
