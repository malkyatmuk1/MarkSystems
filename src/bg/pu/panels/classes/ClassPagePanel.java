package bg.pu.panels.classes;

import bg.pu.entity.ClassOfStudents;
import bg.pu.frames.classes.ClassMenuPage;
import bg.pu.frames.classes.ClassPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClassPagePanel extends JPanel {
    private JLabel firstLable = new JLabel("");
    private JLabel secondLable = new JLabel("Pick a class.");
    private JComboBox comboBox;
    private JButton buttonAddTeacher = new JButton("Add class");
    DataService dataService = new DataService();

    public ClassPagePanel(ArrayList<ClassOfStudents> classOfStudentsArrayList){
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

        String[] className = new String[classOfStudentsArrayList.size()];
        for (int i = 0; i < classOfStudentsArrayList.size(); i++) {
            className[i] = classOfStudentsArrayList.get(i).getName();
        }
        comboBox = new JComboBox(className);
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
                System.out.println(comboBox.getSelectedItem().toString());
                ClassMenuPage classMenuPage = new ClassMenuPage();
                classMenuPage.displayClassMenuPage(dataService.getClassById(comboBox.getSelectedIndex()+1));
               // secondPage.displaySecondPage(dataService.getTeacherById(comboBox.getSelectedIndex()+1));
                // secondPage.displaySecondPage(comboBox.getSelectedItem().toString(), dataService.getClassByTeacher(dataService.getTeacherByName(comboBox.getSelectedItem().toString())).getGrade().getName(), dataService.getAllStudentByClassId(dataService.getClassByTeacher(dataService.getTeacherByName(comboBox.getSelectedItem().toString()))));
                //new bg.pu.panels.classes.ClassInfoPanel(comboBox.getSelectedItem().toString(), dataService.getClassByTeacher(dataService.getTeacherByName(comboBox.getSelectedItem().toString())).getGrade().getName());
            }
        });
        buttonAddTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ClassPage classPage= new ClassPage();
                classPage.displayClassPage();
            }
        });

    }
    public JComboBox getComboBox() {
        return comboBox;
    }
}