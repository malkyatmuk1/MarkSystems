package bg.pu.panels.subjectclass;

import bg.pu.entity.ClassOfStudents;
import bg.pu.entity.SubjectClass;
import bg.pu.frames.subjectclass.SubjectClassTablePage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UpdateSubjectClassPanel extends JPanel {
    DataService dataService = new DataService();
    private JComboBox comboBoxClass;
    private JLabel subject = new JLabel("Subject");
    private JLabel subjectName;
    private JLabel classLabel = new JLabel("class");
    private JButton updateButton = new JButton("Update");
    private JButton returnBackButton = new JButton("Back");

    public UpdateSubjectClassPanel(SubjectClass subjectClass) {
        subjectName = new JLabel(subjectClass.getSubject().getName());

        ArrayList<ClassOfStudents> classArrayList = dataService.getAllSubjectClassWithoutSubject(subjectClass.getSubject());
        String[] className = new String[classArrayList.size()];
        for (int i = 0; i < classArrayList.size(); i++) {
            className[i] = classArrayList.get(i).getName();
        }
        comboBoxClass = new JComboBox(className);
        comboBoxClass.setBounds(100, 100, 150, 40);
        comboBoxClass.setSelectedIndex(0);
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(subject, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        this.add(subjectName, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(classLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.5;
        this.add(comboBoxClass, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        this.add(updateButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        this.add(returnBackButton, gbc);
        updateButton.addActionListener(e -> {
            subjectClass.setClassId(classArrayList.get(getIndexOfTheClass(classArrayList, className[comboBoxClass.getSelectedIndex()])));
            dataService.updateSubjectClass(subjectClass);
            SubjectClassTablePage subjectClassTablePage = new SubjectClassTablePage();
            subjectClassTablePage.displaySubjectClassTablePage();
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(UpdateSubjectClassPanel.this);
            frame.dispose();

        });
        returnBackButton.addActionListener(e -> {
            SubjectClassTablePage subjectClassTablePage = new SubjectClassTablePage();
            subjectClassTablePage.displaySubjectClassTablePage();
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(UpdateSubjectClassPanel.this);
            frame.dispose();
        });
    }

    private int getIndexOfTheClass(ArrayList<ClassOfStudents> classArrayList, String className) {
        for (int i = 0; i < classArrayList.size(); i++) if (classArrayList.get(i).getName().equals(className)) return i;
        return -1;
    }
}

