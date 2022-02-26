package bg.pu.panels.teacher;

import bg.pu.frames.teacher.FirstPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTeacherPanel extends JPanel {
    private JLabel teacherFirstName = new JLabel("First name");
    private JLabel teacherSecondName = new JLabel("Second name");
    private JLabel teacherThirdName = new JLabel("Third name");
    private JLabel title = new JLabel("Add new teacher");
    private JTextField firstName = new JTextField("Write first name");
    private JTextField secondName = new JTextField("Write second name");
    private JTextField thirdName = new JTextField("Write third name");
    private JButton addButton = new JButton("Add");
    DataService dataService = new DataService();
    public AddTeacherPanel() {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(teacherFirstName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        this.add(firstName, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(teacherSecondName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.5;
        this.add(secondName, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        this.add(teacherThirdName, gbc);
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
                dataService.addTeacher(firstName, secondName, thirdName);
                //dataService.addClass(dataService.getTeacherByName(firstName.getText() + " " + secondName.getText() + " " + thirdName.getText()).getTeacherId(), comboBox.getSelectedIndex()+1);
                FirstPage firstPage = new FirstPage();
                firstPage.displayFirstPage(dataService.getAllTeachers(), dataService.getAllClass());

            }
        });
    }
}
