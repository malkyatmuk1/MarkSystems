package bg.pu.panels.classes;

import bg.pu.entity.ClassOfStudents;
import bg.pu.entity.Teacher;
import bg.pu.frames.classes.ClassMenuPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UpdateClassPanel extends JPanel {

  private JLabel className = new JLabel("Class name");
  private JLabel title = new JLabel("Update class");
  private JTextField classField = new JTextField("Write class name");
  private JButton addButton = new JButton("Update");
  private JLabel teacherNameLabel = new JLabel("Teacher name");
  private JButton returnBackButton = new JButton("Back");
  private JComboBox comboBox;

  public UpdateClassPanel(ClassOfStudents classOfStudents) {

    classField.setText(classOfStudents.getName());

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
    this.add(classField, gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    this.add(className, gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 1;
    gbc.gridy = 2;

    DataService dataService = new DataService();
    ArrayList<Teacher> teacherArrayList = dataService.getAllTeachers();
    String[] teacherName = new String[teacherArrayList.size()];
    for (int i = 0; i < teacherArrayList.size(); i++) {
      teacherName[i] =
          teacherArrayList.get(i).getFirstName()
              + " "
              + teacherArrayList.get(i).getSecondName()
              + " "
              + teacherArrayList.get(i).getThirdName();
    }
    comboBox = new JComboBox(teacherName);
    comboBox.setSelectedItem(classOfStudents.getTeacher());
    this.add(comboBox, gbc);
    gbc.gridx = 0;
    gbc.gridy = 2;
    this.add(teacherNameLabel, gbc);
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    this.add(addButton, gbc);
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.gridwidth = 0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    this.add(returnBackButton, gbc);

    addButton.addActionListener(
        e -> {
          dataService.updateClass(
              classOfStudents,
              classField.getText(),
              teacherArrayList.get(comboBox.getSelectedIndex()));
          ClassMenuPage classMenuPage = new ClassMenuPage();
          classMenuPage.displayClassMenuPage(classOfStudents);
          JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(UpdateClassPanel.this);
          frame.dispose();
        });
    returnBackButton.addActionListener(
        e -> {
          ClassMenuPage classMenuPage = new ClassMenuPage();
          classMenuPage.displayClassMenuPage(classOfStudents);
          JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(UpdateClassPanel.this);
          frame.dispose();
        });
  }
}
