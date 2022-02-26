package bg.pu.panels.classes;

import bg.pu.entity.Subjects;
import bg.pu.frames.classes.ClassMenuPage;
import bg.pu.frames.teacher.FirstPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateSubjectPanel extends JPanel {
    private JLabel subjectLabel = new JLabel("Subject name");
    private JLabel title = new JLabel("Update subject");
    private JTextField subjectField = new JTextField("Write subject name");
    private JButton updateButton = new JButton("Update");
    DataService dataService = new DataService();

    public UpdateSubjectPanel(Subjects subject) {

        subjectField.setText(subject.getName());

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(title, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.5;
        this.add(subjectField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(subjectLabel, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(updateButton, gbc);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(UpdateSubjectPanel.this);
                frame.dispose();
                subject.setName(subjectField.getText());
                dataService.updateSubject(subject);
                FirstPage firstPage = new FirstPage();
                firstPage.displayFirstPage(dataService.getAllTeachers(), dataService.getAllClass());
            }
        });
    }
}


