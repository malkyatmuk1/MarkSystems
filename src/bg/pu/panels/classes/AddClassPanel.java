package bg.pu.panels.classes;

import bg.pu.TextPrompt;
import bg.pu.entity.Teacher;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddClassPanel extends JPanel {
  private JLabel addClass = new JLabel("Add class", JLabel.CENTER);
  private JLabel className = new JLabel("Class name");
  private JLabel teacherName = new JLabel("Teacher name");
  private JTextField nameField = new JTextField();
  private JComboBox comboBox;
  private JButton buttonAddClass = new JButton("Add");
  private JButton returnBackButton = new JButton("Back");

  public AddClassPanel(ClassPanel classPanel) {
    addClass.setFont(new Font("Verdana", Font.ITALIC, 20));
    this.add(addClass);

    TextPrompt placeholderFirst = new TextPrompt("Write the class name", nameField);
    placeholderFirst.changeAlpha(0.75f);
    placeholderFirst.changeStyle(Font.ITALIC);

    GridBagLayout layout = new GridBagLayout();
    this.setLayout(layout);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 1;
    gbc.weightx = 0.5;
    this.add(className, gbc);
    gbc.gridx = 1;
    gbc.gridy = 2;
    this.add(nameField, gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.weightx = 0.5;
    this.add(teacherName, gbc);
    gbc.gridx = 1;
    gbc.gridy = 3;
    gbc.weightx = 0.5;

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
    this.add(comboBox, gbc);
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.fill = GridBagConstraints.CENTER;
    gbc.gridwidth = 0;
    this.add(buttonAddClass, gbc);

    buttonAddClass.addActionListener(
        e -> {
          dataService.addClass(
              nameField.getText(),
              teacherArrayList.get(comboBox.getSelectedIndex()).getTeacherId());
          ClassPanel classPanelNew = new ClassPanel(0);

          classPanel.removeAll();
          classPanel.add(classPanelNew);
          classPanel.revalidate();
          classPanel.repaint();
        });
  }
}
