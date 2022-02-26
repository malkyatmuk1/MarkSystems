package bg.pu.panels.teacher;

import bg.pu.entity.Teacher;
import bg.pu.frames.teacher.FirstPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateTeacherPanel extends JPanel {


    private JLabel teacherFirstName = new JLabel("First name");
    private JLabel teacherSecondName = new JLabel("Second name");
    private JLabel teacherThirdName = new JLabel("Third name");
    private JLabel gradeLabel = new JLabel("bg.pu.entity.Grade");
    private JLabel title = new JLabel("Update teacher");
    private JTextField firstName = new JTextField("Write first name");
    private JTextField secondName = new JTextField("Write second name");
    private JTextField thirdName = new JTextField("Write third name");
    private JButton addButton = new JButton("Update");
    DataService dataService = new DataService();

    public UpdateTeacherPanel(Teacher teacher) {

        firstName.setText(teacher.getFirstName());
        secondName.setText(teacher.getSecondName());
        thirdName.setText(teacher.getThirdName());
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(title, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.5;
        this.add(firstName, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(teacherFirstName, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.5;
        this.add(secondName, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(teacherSecondName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(thirdName, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        this.add(teacherThirdName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 0;
        this.add(addButton, gbc);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataService.updateTeacher(firstName, secondName, thirdName, teacher.getTeacherId());
                FirstPage firstPage = new FirstPage();
                firstPage.displayFirstPage(dataService.getAllTeachers(), dataService.getAllClass());

            }
        });
    }
}

