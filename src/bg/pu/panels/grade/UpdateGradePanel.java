package bg.pu.panels.grade;

import bg.pu.entity.Grade;
import bg.pu.entity.SubjectClass;
import bg.pu.frames.grade.GradeTablePage;
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
  private JButton returnBackButton = new JButton("Back");

  public UpdateGradePanel(Grade grade) {
    Float[] gradeValue = {2f, 3f, 4f, 5f, 6f};
    comboBoxGrade = new JComboBox(gradeValue);
    comboBoxGrade.setBounds(100, 100, 150, 40);
    ArrayList<SubjectClass> subjectArrayList =
        dataService.getAllSubjectClass(grade.getStudent().getClassStudent());
    String[] subjectArray = new String[subjectArrayList.size()];
    for (int i = 0; i < subjectArrayList.size(); i++) {
      subjectArray[i] = subjectArrayList.get(i).getSubject().getName();
    }
    comboBoxSubject = new JComboBox(subjectArray);
    comboBoxSubject.setSelectedIndex(
        getIndexOfTheSubject(subjectArrayList, grade.getSubject().getName()));
    comboBoxSubject.setBounds(100, 100, 150, 40);
    GridBagLayout layout = new GridBagLayout();
    this.setLayout(layout);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 0;
    this.add(subject, gbc);
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.weightx = 0.5;
    comboBoxSubject.setSelectedIndex(
        getIndexOfTheSubject(subjectArrayList, grade.getSubject().getName()));
    this.add(comboBoxSubject, gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 1;
    this.add(gradeLabel, gbc);
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.weightx = 0.5;
    this.add(comboBoxGrade, gbc);
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridwidth = 2;
    this.add(addButton, gbc);
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridwidth = 2;
    this.add(returnBackButton, gbc);
    addButton.addActionListener(
        e -> {
          dataService.updateGrade(
              gradeValue[comboBoxGrade.getSelectedIndex()],
              subjectArrayList.get(comboBoxSubject.getSelectedIndex()).getSubject().getSubjectId(),
              grade.getStudent().getStudentId(),
              grade.getGradeId());
          GradeTablePage gradeTablePage = new GradeTablePage();
          gradeTablePage.displayGradePage(grade.getStudent());
          JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(UpdateGradePanel.this);
          frame.dispose();
        });
    //    returnBackButton.addActionListener(
    //        e -> {
    //           subjectMenuPage = new SubjectMenuPage();
    //          subjectMenuPage.displaySubjectMenuPage(subject);
    //          JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(UpdateGradePanel.this);
    //          frame.dispose();
    //        });
  }

  private int getIndexOfTheSubject(ArrayList<SubjectClass> classArrayList, String subjectName) {
    for (int i = 0; i < classArrayList.size(); i++)
      if (classArrayList.get(i).getSubject().getName().equals(subjectName)) return i;
    return -1;
  }
}
