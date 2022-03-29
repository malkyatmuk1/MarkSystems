package bg.pu.panels.subjectclass;

import bg.pu.entity.ClassOfStudents;
import bg.pu.entity.Subjects;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddSubjectClassPanel extends JPanel {
  private JLabel classLabel = new JLabel("Class");
  private JLabel subjectLabel = new JLabel("Subject");
  private JLabel title = new JLabel("Add subject to a class", JLabel.CENTER);
  private JComboBox comboBoxClass;
  private JComboBox comboBoxSubject;
  private JButton addButton = new JButton("Add subject to a class");

  DataService dataService = new DataService();

  public AddSubjectClassPanel(
      SubjectClassPanel subjectClassPanel, int subjectIndex, int classIndex) {
    title.setFont(new Font("Verdana", Font.ITALIC, 20));
    this.add(title);
    GridBagLayout layout = new GridBagLayout();
    this.setLayout(layout);
    GridBagConstraints gbc = new GridBagConstraints();

    ArrayList<Subjects> subjectsArrayList = dataService.getAllSubjects();

    String[] subjectName = new String[subjectsArrayList.size()];
    for (int i = 0; i < subjectsArrayList.size(); i++) {
      subjectName[i] = subjectsArrayList.get(i).getName();
    }

    comboBoxSubject = new JComboBox(subjectName);
    comboBoxSubject.setSelectedIndex(subjectIndex);

    ArrayList<ClassOfStudents> classArrayList =
        dataService.getAllSubjectClassWithoutSubject(subjectsArrayList.get(subjectIndex));
    String[] className = new String[classArrayList.size()];
    for (int i = 0; i < classArrayList.size(); i++) {
      className[i] = classArrayList.get(i).getName();
    }
    comboBoxClass = new JComboBox(className);
    if (className.length != 0) comboBoxClass.setSelectedIndex(classIndex);
    else {
      className = new String[1];
      className[0] = "-";
      comboBoxClass = new JComboBox(className);
      addButton.setEnabled(false);
    }
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 2;
    this.add(subjectLabel, gbc);
    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.weightx = 1;
    this.add(comboBoxSubject, gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 3;
    this.add(classLabel, gbc);
    gbc.gridx = 1;
    gbc.gridy = 3;
    gbc.weightx = 0.5;
    this.add(comboBoxClass, gbc);
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.fill = GridBagConstraints.CENTER;
    gbc.gridwidth = 0;
    this.add(addButton, gbc);
    comboBoxSubject.addActionListener(
        e -> {
          SubjectClassPanel subjectClassPanelNew =
              new SubjectClassPanel(
                  0, comboBoxClass.getSelectedIndex(), comboBoxSubject.getSelectedIndex());

          subjectClassPanel.removeAll();
          subjectClassPanel.add(subjectClassPanelNew);
          subjectClassPanel.revalidate();
          subjectClassPanel.repaint();
        });
    comboBoxClass.addActionListener(
        e -> {
          SubjectClassPanel subjectClassPanelNew =
              new SubjectClassPanel(
                  0, comboBoxClass.getSelectedIndex(), comboBoxSubject.getSelectedIndex());

          subjectClassPanel.removeAll();
          subjectClassPanel.add(subjectClassPanelNew);
          subjectClassPanel.revalidate();
          subjectClassPanel.repaint();
        });
    addButton.addActionListener(
        e -> {
          dataService.addSubjectClass(
              subjectsArrayList.get(comboBoxSubject.getSelectedIndex()),
              classArrayList.get(comboBoxClass.getSelectedIndex()));
          SubjectClassPanel subjectClassPanelNew = new SubjectClassPanel(0, 0, 0);

          subjectClassPanel.removeAll();
          subjectClassPanel.add(subjectClassPanelNew);
          subjectClassPanel.revalidate();
          subjectClassPanel.repaint();
        });
  }
}
