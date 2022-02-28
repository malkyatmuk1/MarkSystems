package bg.pu.panels.teacher;

import bg.pu.frames.teacher.FirstPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;

public class AddTeacherPanel extends JPanel {
  private JLabel teacherFirstName = new JLabel("First name");
  private JLabel teacherSecondName = new JLabel("Second name");
  private JLabel teacherThirdName = new JLabel("Third name");
  private JTextField firstName = new JTextField("Write first name");
  private JTextField secondName = new JTextField("Write second name");
  private JTextField thirdName = new JTextField("Write third name");
  private JButton addButton = new JButton("Add");
  private JButton returnBackButton = new JButton("Back");
  DataService dataService = new DataService();

  public AddTeacherPanel() {
    GridBagLayout layout = new GridBagLayout();
    this.setLayout(layout);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 0;
    this.add(teacherFirstName, gbc);
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.weightx = 0.5;
    this.add(firstName, gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 1;
    this.add(teacherSecondName, gbc);
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.weightx = 0.5;
    this.add(secondName, gbc);
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridwidth = 2;
    this.add(teacherThirdName, gbc);
    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.weightx = 0.5;
    this.add(thirdName, gbc);
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridwidth = 0;
    this.add(addButton, gbc);
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridwidth = 0;
    this.add(returnBackButton, gbc);
    addButton.addActionListener(
        e -> {
          dataService.addTeacher(firstName, secondName, thirdName);
          FirstPage firstPage = new FirstPage();
          firstPage.displayFirstPage(dataService.getAllTeachers(), dataService.getAllClass());
          JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(AddTeacherPanel.this);
          frame.dispose();
        });
    returnBackButton.addActionListener(
        e -> {
          FirstPage firstPage = new FirstPage();
          firstPage.displayFirstPage(dataService.getAllTeachers(), dataService.getAllClass());
          JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(AddTeacherPanel.this);
          frame.dispose();
        });
  }
}
