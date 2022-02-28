package bg.pu.panels.subjectclass;

import bg.pu.frames.subjectclass.SubjectClassTablePage;

import javax.swing.*;
import java.awt.*;

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
        buttonAddSubject.addActionListener(e -> {
            SubjectClassTablePage subjectClassTablePage = new SubjectClassTablePage();
            subjectClassTablePage.displaySubjectClassTablePage();
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(SubjectClassPanel.this);
            frame.dispose();
        });

    }
}
