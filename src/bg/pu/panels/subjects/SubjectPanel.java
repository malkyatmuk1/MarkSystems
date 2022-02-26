package bg.pu.panels.subjects;

import bg.pu.entity.ClassOfStudents;
import bg.pu.entity.Subjects;
import bg.pu.frames.classes.ClassMenuPage;
import bg.pu.frames.classes.ClassPage;
import bg.pu.frames.subjects.AddSubjectPage;
import bg.pu.frames.subjects.SubjectMenuPage;
import bg.pu.frames.subjects.UpdateSubjectPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SubjectPanel extends JPanel {
    private JLabel firstLable = new JLabel("");
    private JLabel secondLable = new JLabel("Pick a subject");
    private JComboBox comboBox;
    private JButton buttonAddSubject = new JButton("Add subject");

    public SubjectPanel(ArrayList<Subjects> subjectsArrayList){
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

        String[] subjectName = new String[subjectsArrayList.size()];
        for (int i = 0; i < subjectsArrayList.size(); i++) {
            subjectName[i] = subjectsArrayList.get(i).getName();
        }
        comboBox = new JComboBox(subjectName);
        comboBox.setBounds(100, 100, 150, 40);
        this.add(comboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 4;
        this.add(buttonAddSubject, gbc);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //getSelectedIndex
                System.out.println(comboBox.getSelectedItem().toString());
                SubjectMenuPage subjectMenuPage = new SubjectMenuPage();
                subjectMenuPage.displaySubjectMenuPage(subjectsArrayList.get(comboBox.getSelectedIndex()));
                // secondPage.displaySecondPage(dataService.getTeacherById(comboBox.getSelectedIndex()+1));
                // secondPage.displaySecondPage(comboBox.getSelectedItem().toString(), dataService.getClassByTeacher(dataService.getTeacherByName(comboBox.getSelectedItem().toString())).getGrade().getName(), dataService.getAllStudentByClassId(dataService.getClassByTeacher(dataService.getTeacherByName(comboBox.getSelectedItem().toString()))));
                //new bg.pu.panels.classes.ClassInfoPanel(comboBox.getSelectedItem().toString(), dataService.getClassByTeacher(dataService.getTeacherByName(comboBox.getSelectedItem().toString())).getGrade().getName());
            }
        });
        buttonAddSubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddSubjectPage addSubjectPage = new AddSubjectPage();
                addSubjectPage.displayAddSubjectPage();
            }
        });

    }
    public JComboBox getComboBox() {
        return comboBox;
    }
}

