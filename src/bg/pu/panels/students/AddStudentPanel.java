package bg.pu.panels.students;

import bg.pu.TabbedPane;
import bg.pu.TextPrompt;
import bg.pu.entity.ClassOfStudents;
import bg.pu.panels.grade.MarksPanel;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddStudentPanel extends JPanel {
  private JLabel studentFirstName = new JLabel("First name");
  private JLabel studentSecondName = new JLabel("Second name");
  private JLabel studentThirdName = new JLabel("Third name");
  private JLabel classOfStudentsLabel = new JLabel("Class");
  private JLabel title = new JLabel("Add new student");
  private JTextField firstName = new JTextField();
  private JTextField secondName = new JTextField();
  private JTextField thirdName = new JTextField();
  private JButton addButton = new JButton("Add");
  private JComboBox comboBoxClass = new JComboBox();

  DataService dataService = new DataService();

  public AddStudentPanel(StudentsPanel jpanel, TabbedPane tabbedPane, MarksPanel marksPanel) {
    TextPrompt placeholderFirst = new TextPrompt("Write first name", firstName);
    placeholderFirst.changeAlpha(0.75f);
    placeholderFirst.changeStyle(Font.ITALIC);
    placeholderFirst = new TextPrompt("Write second name", secondName);
    placeholderFirst.changeAlpha(0.75f);
    placeholderFirst.changeStyle(Font.ITALIC);
    placeholderFirst = new TextPrompt("Write third name", thirdName);
    placeholderFirst.changeAlpha(0.75f);
    placeholderFirst.changeStyle(Font.ITALIC);
    title.setFont(new Font("Verdana", Font.ITALIC, 20));
    this.add(title);
    ArrayList<ClassOfStudents> classArrayList = dataService.getAllClass();
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
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.weightx = 0.5;
    this.add(firstName, gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    this.add(studentFirstName, gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.weightx = 0.5;
    this.add(secondName, gbc);
    gbc.gridx = 0;
    gbc.gridy = 2;
    this.add(studentSecondName, gbc);
    gbc.gridx = 1;
    gbc.gridy = 3;
    gbc.weightx = 0.5;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    this.add(thirdName, gbc);
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.weightx = 0;
    this.add(studentThirdName, gbc);
    gbc.gridx = 1;
    gbc.gridy = 4;
    gbc.weightx = 0.5;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    this.add(comboBoxClass, gbc);
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.weightx = 0;
    this.add(classOfStudentsLabel, gbc);
    gbc.gridx = 1;
    gbc.gridy = 5;
    gbc.weightx = 0.5;
    gbc.gridx = 0;
    gbc.gridy = 6;
    gbc.fill = GridBagConstraints.CENTER;
    gbc.gridwidth = 0;
    this.add(addButton, gbc);

    addButton.addActionListener(
        e -> {
          ClassOfStudents classOfStudents =
              dataService.getAllClass().get(comboBoxClass.getSelectedIndex());
          dataService.addStudent(firstName, secondName, thirdName, classOfStudents);
          StudentsPanel studentsPanelNew =
              new StudentsPanel(comboBoxClass.getSelectedIndex(), tabbedPane, marksPanel, 0);
          jpanel.removeAll();
          jpanel.add(studentsPanelNew);
          jpanel.revalidate();
          jpanel.repaint();
        });
  }
}
