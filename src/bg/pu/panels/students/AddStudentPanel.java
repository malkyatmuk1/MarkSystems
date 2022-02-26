package bg.pu.panels.students;

import bg.pu.entity.ClassOfStudents;
import bg.pu.frames.students.StudentClassPage;
import bg.pu.frames.teacher.FirstPage;
import bg.pu.panels.classes.ClassMenuPanel;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentPanel extends JPanel {
    private JLabel studentFirstName = new JLabel("First name");
    private JLabel studentSecondName = new JLabel("Second name");
    private JLabel studentThirdName = new JLabel("Third name");
    private JLabel title = new JLabel("Add new student");
    private JTextField firstName = new JTextField("Write first name");
    private JTextField secondName = new JTextField("Write second name");
    private JTextField thirdName = new JTextField("Write third name");
    private JButton addButton = new JButton("Add");
    DataService dataService = new DataService();

    public AddStudentPanel(ClassOfStudents classOfStudents) {

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(studentFirstName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        this.add(firstName, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(studentSecondName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.5;
        this.add(secondName, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        this.add(studentThirdName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.5;
        this.add(thirdName, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 0;
        this.add(addButton, gbc);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataService.addStudent(firstName, secondName, thirdName, classOfStudents);
                //dataService.addClass(dataService.getTeacherByName(firstName.getText() + " " + secondName.getText() + " " + thirdName.getText()).getTeacherId(), comboBox.getSelectedIndex()+1);
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(AddStudentPanel.this);
                frame.dispose();
                StudentClassPage studentClassPage = new StudentClassPage();
                studentClassPage.displayStudentClassPage(classOfStudents);
            }

        });
    }
}

