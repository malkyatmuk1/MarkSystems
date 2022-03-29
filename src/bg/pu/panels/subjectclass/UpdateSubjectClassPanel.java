package bg.pu.panels.subjectclass;

import bg.pu.entity.ClassOfStudents;
import bg.pu.entity.SubjectClass;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UpdateSubjectClassPanel extends JPanel {
  DataService dataService = new DataService();
  private JComboBox comboBoxClass;
  private JLabel subject = new JLabel("Subject");
  private JLabel subjectName;
  private JLabel classLabel = new JLabel("class");
  private JButton updateButton = new JButton("Update");
  private JLabel title = new JLabel("Update class");

  public UpdateSubjectClassPanel(SubjectClass subjectClass, SubjectClassPanel subjectClassPanel) {
    title.setFont(new Font("Verdana", Font.ITALIC, 20));
    this.add(title);
    subjectName = new JLabel(subjectClass.getSubject().getName());

    ArrayList<ClassOfStudents> classArrayList =
        dataService.getAllSubjectClassWithoutSubject(subjectClass.getSubject());
    System.out.println(classArrayList.size());
    String[] className = new String[classArrayList.size() + 1];
    for (int i = 0; i < classArrayList.size(); i++) {
      className[i] = classArrayList.get(i).getName();
    }
    className[classArrayList.size()] = subjectClass.getClassId().getName();
    comboBoxClass = new JComboBox(className);
    comboBoxClass.setBounds(100, 100, 150, 40);
    comboBoxClass.setSelectedIndex(classArrayList.size());
    GridBagLayout layout = new GridBagLayout();
    this.setLayout(layout);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 1;
    this.add(subject, gbc);
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.weightx = 0.5;
    this.add(subjectName, gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 2;
    this.add(classLabel, gbc);
    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.weightx = 0.5;
    this.add(comboBoxClass, gbc);
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.fill = GridBagConstraints.CENTER;
    gbc.gridwidth = 0;
    this.add(updateButton, gbc);

    updateButton.addActionListener(
        e -> {
          subjectClass.setClassId(
              classArrayList.get(
                  getIndexOfTheClass(
                      classArrayList,
                      dataService
                          .getAllClass()
                          .get(comboBoxClass.getSelectedIndex())
                          .getClassId())));
          dataService.updateSubjectClass(subjectClass);
          SubjectClassPanel subjectClassPanelNew = new SubjectClassPanel(0, 0, 0);

          subjectClassPanel.removeAll();
          subjectClassPanel.add(subjectClassPanelNew);
          subjectClassPanel.revalidate();
          subjectClassPanel.repaint();
        });
  }

  private int getIndexOfTheClass(ArrayList<ClassOfStudents> classArrayList, int id) {
    for (int i = 0; i < classArrayList.size(); i++)
      if (classArrayList.get(i).getClassId() == id) return i;
    return -1;
  }
}
