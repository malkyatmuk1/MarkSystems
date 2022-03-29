package bg.pu.panels.grade;

import bg.pu.entity.Student;
import bg.pu.entity.SubjectClass;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddGradePanel extends JPanel {
  DataService dataService = new DataService();
  private JComboBox comboBoxGrade;
  private JComboBox comboBoxSubject;
  private JLabel subject = new JLabel("Subject");
  private JLabel grade = new JLabel("Grade");
  private JButton addButton = new JButton("Add");
  private JLabel title = new JLabel("Add new Grade");
  String[] subjectName;

  public AddGradePanel(Student student, MarksPanel marksPanel) {
    title.setFont(new Font("Verdana", Font.ITALIC, 20));
    title.setText(title.getText() + " - " + student.getFullName());
    this.add(title);
    Float[] gradeValue = {2f, 3f, 4f, 5f, 6f};
    comboBoxGrade = new JComboBox(gradeValue);
    comboBoxGrade.setBounds(100, 100, 150, 40);
    ArrayList<SubjectClass> subjectClassArrayList =
        dataService.getAllSubjectClass(student.getClassStudent());
    if (subjectClassArrayList.size() != 0) {
      subjectName = new String[subjectClassArrayList.size()];
      for (int i = 0; i < subjectClassArrayList.size(); i++) {
        subjectName[i] = subjectClassArrayList.get(i).getSubject().getName();
      }
    } else {
      subjectName = new String[1];
      subjectName[0] = "-";
      addButton.setEnabled(false);
    }

    comboBoxSubject = new JComboBox(subjectName);
    comboBoxSubject.setBounds(100, 100, 150, 40);
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
    this.add(comboBoxSubject, gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 2;
    this.add(grade, gbc);
    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.weightx = 0.5;
    this.add(comboBoxGrade, gbc);
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.fill = GridBagConstraints.CENTER;
    gbc.gridwidth = 0;
    this.add(addButton, gbc);

    addButton.addActionListener(
        e -> {
          dataService.addGrade(
              gradeValue[comboBoxGrade.getSelectedIndex()],
              subjectClassArrayList.get(comboBoxSubject.getSelectedIndex()).getSubject(),
              student);
          MarksPanel marksPanelNew = new MarksPanel(student, 0);
          marksPanel.removeAll();
          marksPanel.add(marksPanelNew);
          marksPanel.revalidate();
          marksPanel.repaint();
        });
  }
}
