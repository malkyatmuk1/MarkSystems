package bg.pu.panels.subjects;

import bg.pu.frames.teacher.FirstPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;

public class AddSubjectPanel extends JPanel {

    private JLabel subjectLabel = new JLabel("Subject name");
    private JLabel title = new JLabel("Add subject");
    private JTextField subjectField = new JTextField("Write subject name");
    private JButton updateButton = new JButton("Add subject");
    private JButton returnBackButton = new JButton("Back");
    DataService dataService = new DataService();

    public AddSubjectPanel() {
        {
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
            gbc.weightx = 0.5;
            this.add(subjectLabel, gbc);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            this.add(updateButton, gbc);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = 3;
            this.add(returnBackButton, gbc);

            updateButton.addActionListener(e -> {
                dataService.addSubject(subjectField.getText());
                FirstPage firstPage = new FirstPage();
                firstPage.displayFirstPage(dataService.getAllTeachers(), dataService.getAllClass());
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(AddSubjectPanel.this);
                frame.dispose();
            });
            returnBackButton.addActionListener(e -> {
                FirstPage firstPage = new FirstPage();
                firstPage.displayFirstPage(dataService.getAllTeachers(), dataService.getAllClass());
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(AddSubjectPanel.this);
                frame.dispose();
            });
        }
    }
}
