package bg.pu.panels.teacher;

import bg.pu.entity.Teacher;
import bg.pu.frames.teacher.AddTeacherPage;
import bg.pu.frames.teacher.TeacherMenuPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TeacherPickerPanel extends JPanel {

    private JLabel firstLable = new JLabel("Welcome to CMS");
    private JLabel secondLable = new JLabel("Pick your name.");
    private JComboBox comboBox;
    private JButton buttonAddTeacher = new JButton("Add teacher");
    DataService dataService = new DataService();

    public TeacherPickerPanel(ArrayList<Teacher> teacherArrayList, JFrame frame) {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(firstLable, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(secondLable, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;

        String[] teacherName = new String[teacherArrayList.size()];
        for (int i = 0; i < teacherArrayList.size(); i++) {
            teacherName[i] = teacherArrayList.get(i).getFirstName() + " " + teacherArrayList.get(i).getSecondName() + " " + teacherArrayList.get(i).getThirdName();
        }
        comboBox = new JComboBox(teacherName);
        comboBox.setBounds(100, 100, 150, 40);
        this.add(comboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 4;
        this.add(buttonAddTeacher, gbc);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //getSelectedIndex
                TeacherMenuPage teacherMenuPAge = new TeacherMenuPage();
                System.out.println(comboBox.getSelectedItem().toString());
                teacherMenuPAge.displaySecondPage(dataService.getTeacherById(comboBox.getSelectedIndex()+1));
               // secondPage.displaySecondPage(comboBox.getSelectedItem().toString(), dataService.getClassByTeacher(dataService.getTeacherByName(comboBox.getSelectedItem().toString())).getGrade().getName(), dataService.getAllStudentByClassId(dataService.getClassByTeacher(dataService.getTeacherByName(comboBox.getSelectedItem().toString()))));
                //new bg.pu.panels.classes.ClassInfoPanel(comboBox.getSelectedItem().toString(), dataService.getClassByTeacher(dataService.getTeacherByName(comboBox.getSelectedItem().toString())).getGrade().getName());
            }
        });
        buttonAddTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddTeacherPage addTeacherPage = new AddTeacherPage();
                addTeacherPage.displayAddTeacherPage();
                frame.dispose();

            }
        });

    }

    public JComboBox getComboBox() {
        return comboBox;
    }
}
