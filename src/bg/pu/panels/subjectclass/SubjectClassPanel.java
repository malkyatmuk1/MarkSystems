package bg.pu.panels.subjectclass;

import bg.pu.entity.Subjects;
import bg.pu.frames.subjectclass.SubjectClassTablePage;
import bg.pu.frames.subjects.AddSubjectPage;
import bg.pu.frames.subjects.SubjectMenuPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SubjectClassPanel extends JPanel {
    private JLabel firstLable = new JLabel("Manage subject to class");
    private JButton buttonAddSubject = new JButton("Subject to class");

    public SubjectClassPanel(){
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
        this.add(buttonAddSubject, gbc);
        buttonAddSubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubjectClassTablePage subjectClassTablePage = new SubjectClassTablePage();
                subjectClassTablePage.displaySubjectClassTablePage();
            }
        });

    }
}
