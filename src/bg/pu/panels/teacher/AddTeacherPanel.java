package bg.pu.panels.teacher;

import bg.pu.TextPrompt;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;

public class AddTeacherPanel extends JPanel {
  private JLabel addTeacher = new JLabel("Add teacher", JLabel.CENTER);
  private JLabel teacherFirstName = new JLabel("First name");
  private JLabel teacherSecondName = new JLabel("Second name");
  private JLabel teacherThirdName = new JLabel("Third name");
  private JTextField firstName = new JTextField();
  private JTextField secondName = new JTextField();
  private JTextField thirdName = new JTextField();
  private JButton addButton = new JButton("Add");
  DataService dataService = new DataService();

  public AddTeacherPanel(JPanel teacherPanel) {
    TextPrompt placeholderFirst = new TextPrompt("Write first name", firstName);
    placeholderFirst.changeAlpha(0.75f);
    placeholderFirst.changeStyle(Font.ITALIC);
    TextPrompt placeholderSecond = new TextPrompt("Write second name", secondName);
    placeholderSecond.changeAlpha(0.75f);
    placeholderSecond.changeStyle(Font.ITALIC);
    TextPrompt placeholderThird = new TextPrompt("Write third name", thirdName);
    placeholderThird.changeAlpha(0.75f);
    placeholderThird.changeStyle(Font.ITALIC);
    addTeacher.setFont(new Font("Verdana", Font.ITALIC, 20));
    this.add(addTeacher);
    GridBagLayout layout = new GridBagLayout();
    this.setLayout(layout);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 1;
    gbc.weightx = 0.5;
    this.add(teacherFirstName, gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 1;
    gbc.gridy = 2;
    this.add(firstName, gbc);
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.weightx = 0.5;
    this.add(teacherSecondName, gbc);
    gbc.gridx = 1;
    gbc.gridy = 3;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    this.add(secondName, gbc);
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.weightx = 0.5;
    this.add(teacherThirdName, gbc);
    gbc.gridx = 1;
    gbc.gridy = 4;
    gbc.fill = GridBagConstraints.HORIZONTAL;

    this.add(thirdName, gbc);
    gbc.gridwidth = 0;
    gbc.gridx = 0;
    gbc.gridy = 5;
    gbc.fill = GridBagConstraints.CENTER;
    this.add(addButton, gbc);
    addButton.addActionListener(
        e -> {
          dataService.addTeacher(firstName, secondName, thirdName);
          TeacherPanel teacherPanelNew = new TeacherPanel(0);

          teacherPanel.removeAll();
          teacherPanel.add(teacherPanelNew);
          teacherPanel.revalidate();
          teacherPanel.repaint();
        });
  }
}
