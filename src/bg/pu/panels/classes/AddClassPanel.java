package bg.pu.panels.classes;

import bg.pu.entity.Teacher;
import bg.pu.frames.teacher.FirstPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddClassPanel extends JPanel {
    private JLabel className = new JLabel("Class name");
    private JLabel teacherName = new JLabel("Teacher name");
    private JTextField nameField = new JTextField("Write the class name");
    private JComboBox comboBox;
    private JButton buttonAddClass = new JButton("Add class");
    public AddClassPanel(){
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(className, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        this.add(nameField, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(teacherName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.5;

        DataService dataService = new DataService();
        ArrayList<Teacher>  teacherArrayList = dataService.getAllTeachers();
        String[] teacherName = new String[teacherArrayList.size()];
        for (int i = 0; i < teacherArrayList.size(); i++) {
            teacherName[i] = teacherArrayList.get(i).getFirstName() + " " + teacherArrayList.get(i).getSecondName() + " " + teacherArrayList.get(i).getThirdName();
        }
        comboBox = new JComboBox(teacherName);
        this.add(comboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 0;
        this.add(buttonAddClass, gbc);
        buttonAddClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataService.addClass(nameField.getText(), teacherArrayList.get(comboBox.getSelectedIndex()).getTeacherId());
                FirstPage firstPage = new FirstPage();
                firstPage.displayFirstPage(dataService.getAllTeachers(), dataService.getAllClass());

            }
        });
    }
}
