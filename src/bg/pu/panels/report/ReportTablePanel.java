package bg.pu.panels.report;

import bg.pu.entity.StudentWithGrade;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ReportTablePanel extends JPanel {
  JTable jtable;
  JLabel jLabel;
  String[] columnName = {"Student number", "Student Name", "Grade", "Subject"};
  DataService dataService = new DataService();
  JComboBox classOfStudents, grade;

  public ReportTablePanel(int selectedGrade, int selectedClass) {

    Float[] gradeArr = {2.0f, 3.0f, 4.0f, 5.0f, 6.0f};
    String[] className = new String[dataService.getAllClass().size()];
    for (int i = 0; i < dataService.getAllClass().size(); i++) {
      className[i] = dataService.getAllClass().get(i).getName();
    }
    grade = new JComboBox(gradeArr);
    grade.setSelectedIndex(selectedGrade);
    classOfStudents = new JComboBox(className);
    classOfStudents.setSelectedIndex(selectedClass);

    GridBagConstraints gbc = new GridBagConstraints();
    GridBagLayout layout = new GridBagLayout();
    this.setLayout(layout);
    jLabel =
        new JLabel(
            "This is a report for students in "
                + dataService.getAllClass().get(classOfStudents.getSelectedIndex()).getName()
                + " for "
                + gradeArr[grade.getSelectedIndex()]);
    jLabel.setFont(new Font("Verdana", Font.ITALIC, 20));
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    this.add(jLabel, gbc);
    ArrayList<StudentWithGrade> studentArrayList =
        dataService.getReportForAStudents(
            dataService.getAllClass().get(classOfStudents.getSelectedIndex()),
            gradeArr[grade.getSelectedIndex()]);
    Object[][] data = new Object[studentArrayList.size()][4];
    for (int i = 0; i < studentArrayList.size(); i++) {
      data[i][0] = studentArrayList.get(i).getStudent().getStudentId();
      data[i][1] = studentArrayList.get(i).getStudent().getFullName();
      data[i][2] = studentArrayList.get(i).getGrade();
      data[i][3] = studentArrayList.get(i).getSubjectName();
    }

    this.jtable = new JTable(data, columnName);
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    gbc.weightx = 1;
    gbc.weighty = 1;
    gbc.fill = GridBagConstraints.BOTH;
    this.add(grade, gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 2;
    gbc.weightx = 1;
    gbc.weighty = 1;
    gbc.fill = GridBagConstraints.BOTH;
    this.add(classOfStudents, gbc);
    JScrollPane pane = new JScrollPane(jtable);
    this.add(pane);
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    grade.addActionListener(
        e -> {
          ReportTablePanel reportTablePanelNew =
              new ReportTablePanel(grade.getSelectedIndex(), classOfStudents.getSelectedIndex());
          this.removeAll();
          this.add(reportTablePanelNew);
          this.revalidate();
          this.repaint();
        });
    classOfStudents.addActionListener(
        e -> {
          ReportTablePanel reportTablePanelNew =
              new ReportTablePanel(grade.getSelectedIndex(), classOfStudents.getSelectedIndex());
          this.removeAll();
          this.add(reportTablePanelNew);
          this.revalidate();
          this.repaint();
        });
  }
}
