package bg.pu.panels.subjects;

import bg.pu.TextPrompt;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;

public class AddSubjectPanel extends JPanel {

  private JLabel subjectLabel = new JLabel("Subject name");
  private JLabel title = new JLabel("Add subject");
  private JTextField subjectField = new JTextField();
  private JButton addButton = new JButton("Add subject");
  DataService dataService = new DataService();

  public AddSubjectPanel(JPanel subjectPanel) {
    TextPrompt placeholderFirst = new TextPrompt("Write the name of the subject", subjectField);
    placeholderFirst.changeAlpha(0.75f);
    placeholderFirst.changeStyle(Font.ITALIC);
    title.setFont(new Font("Verdana", Font.ITALIC, 20));
    this.add(title);
    GridBagLayout layout = new GridBagLayout();
    this.setLayout(layout);
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.weightx = 0.5;
    this.add(subjectField, gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.weightx = 0.5;
    this.add(subjectLabel, gbc);
    gbc.fill = GridBagConstraints.CENTER;
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 0;
    this.add(addButton, gbc);

    addButton.addActionListener(
        e -> {
          dataService.addSubject(subjectField.getText());
          SubjectPanel subjectPanelNew = new SubjectPanel(0);

          subjectPanel.removeAll();
          subjectPanel.add(subjectPanelNew);
          subjectPanel.revalidate();
          subjectPanel.repaint();
        });
  }
}
