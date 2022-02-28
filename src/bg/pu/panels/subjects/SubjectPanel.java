package bg.pu.panels.subjects;

import bg.pu.entity.Subjects;
import bg.pu.frames.subjects.AddSubjectPage;
import bg.pu.frames.subjects.SubjectMenuPage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SubjectPanel extends JPanel {
    private JLabel firstLable = new JLabel("");
    private JLabel secondLable = new JLabel("Pick a subject");
    private JComboBox comboBox;
    private JButton buttonAddSubject = new JButton("Add subject");

    public SubjectPanel(ArrayList<Subjects> subjectsArrayList) {
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
        comboBox.addActionListener(e -> {
            System.out.println(comboBox.getSelectedItem().toString());
            SubjectMenuPage subjectMenuPage = new SubjectMenuPage();
            subjectMenuPage.displaySubjectMenuPage(subjectsArrayList.get(comboBox.getSelectedIndex()));
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(SubjectPanel.this);
            frame.dispose();
        });
        buttonAddSubject.addActionListener(e -> {
            AddSubjectPage addSubjectPage = new AddSubjectPage();
            addSubjectPage.displayAddSubjectPage();
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(SubjectPanel.this);
            frame.dispose();
        });

    }
}

