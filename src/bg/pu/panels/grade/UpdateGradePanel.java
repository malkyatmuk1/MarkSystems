package bg.pu.panels.grade;

import bg.pu.entity.Grade;
import bg.pu.entity.Student;
import bg.pu.entity.SubjectClass;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UpdateGradePanel extends JPanel {
  DataService dataService = new DataService();
  private JComboBox comboBoxGrade;
  private JLabel subjectLabel;
  private JLabel subject = new JLabel("Subject");
  private JLabel gradeLabel = new JLabel("grade");
  private JLabel title = new JLabel("Update grade");
  private JButton addButton = new JButton("Update");
  private Grade grade;
  private String[] subjectArray;

  public UpdateGradePanel(Student student, MarksPanel marksPanel, int updateIndex) {

    title.setFont(new Font("Verdana", Font.ITALIC, 20));
    title.setText(title.getText() + " - " + student.getFullName());
    this.add(title);
    Float[] gradeValue = {2f, 3f, 4f, 5f, 6f};
    comboBoxGrade = new JComboBox(gradeValue);
    comboBoxGrade.setBounds(100, 100, 150, 40);
    ArrayList<SubjectClass> subjectArrayList =
        dataService.getAllSubjectClass(student.getClassStudent());

    if (subjectArrayList.size() != 0 && dataService.getAllGradesByStudent(student).size() != 0) {
      grade = dataService.getAllGradesByStudent(student).get(updateIndex);
      subjectArray = new String[subjectArrayList.size()];
      for (int i = 0; i < subjectArrayList.size(); i++) {
        subjectArray[i] = subjectArrayList.get(i).getSubject().getName();
        subjectLabel = new JLabel(grade.getSubject().getName());
      }
      comboBoxGrade.setSelectedItem(grade.getGradeValue());
    } else {
      subjectArray = new String[1];
      subjectArray[0] = "-";
      subjectLabel = new JLabel("-");
      addButton.setEnabled(false);
    }

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
    this.add(subjectLabel, gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 2;
    this.add(gradeLabel, gbc);
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
          grade = dataService.getAllGradesByStudent(student).get(updateIndex);
          dataService.updateGrade(
              gradeValue[comboBoxGrade.getSelectedIndex()],
              grade.getSubject().getSubjectId(),
              grade.getStudent().getStudentId(),
              grade.getGradeId());
          MarksPanel marksPanelNew = new MarksPanel(student, 0);
          marksPanel.removeAll();
          marksPanel.add(marksPanelNew);
          marksPanel.revalidate();
          marksPanel.repaint();
        });
  }

  private int getIndexOfTheSubject(ArrayList<SubjectClass> classArrayList, int id) {
    for (int i = 0; i < classArrayList.size(); i++)
      if (classArrayList.get(i).getSubject().getSubjectId() == id) return i;
    return -1;
  }
}
