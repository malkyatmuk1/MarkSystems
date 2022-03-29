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
  private JComboBox comboBoxSubject;
  private JLabel subject = new JLabel("Subject");
  private JLabel gradeLabel = new JLabel("grade");
  private JLabel title = new JLabel("Update grade");
  private JButton addButton = new JButton("Update");
  private Grade grade;
  private String[] subjectArray;

  public UpdateGradePanel(Student student, MarksPanel marksPanel) {

    title.setFont(new Font("Verdana", Font.ITALIC, 20));
    title.setText(title.getText() + " - " + student.getFullName());
    this.add(title);
    Float[] gradeValue = {2f, 3f, 4f, 5f, 6f};
    comboBoxGrade = new JComboBox(gradeValue);
    comboBoxGrade.setBounds(100, 100, 150, 40);
    ArrayList<SubjectClass> subjectArrayList =
        dataService.getAllSubjectClass(student.getClassStudent());

    if (subjectArrayList.size() != 0 && dataService.getAllGradesByStudent(student).size() != 0) {
      grade = dataService.getAllGradesByStudent(student).get(0);
      subjectArray = new String[subjectArrayList.size()];
      for (int i = 0; i < subjectArrayList.size(); i++) {
        subjectArray[i] = subjectArrayList.get(i).getSubject().getName();
        comboBoxSubject = new JComboBox(subjectArray);
        comboBoxSubject.setSelectedIndex(
            getIndexOfTheSubject(subjectArrayList, grade.getSubject().getName()));
      }
    } else {
      subjectArray = new String[1];
      subjectArray[0] = "-";
      comboBoxSubject = new JComboBox(subjectArray);
      addButton.setEnabled(false);
    }

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
          dataService.updateGrade(
              gradeValue[comboBoxGrade.getSelectedIndex()],
              subjectArrayList.get(comboBoxSubject.getSelectedIndex()).getSubject().getSubjectId(),
              grade.getStudent().getStudentId(),
              grade.getGradeId());
          MarksPanel marksPanelNew = new MarksPanel(student);
          marksPanel.removeAll();
          marksPanel.add(marksPanelNew);
          marksPanel.revalidate();
          marksPanel.repaint();
        });
  }

  private int getIndexOfTheSubject(ArrayList<SubjectClass> classArrayList, String subjectName) {
    for (int i = 0; i < classArrayList.size(); i++)
      if (classArrayList.get(i).getSubject().getName().equals(subjectName)) return i;
    return -1;
  }
}
