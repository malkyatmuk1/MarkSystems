package bg.pu.panels.grade;

import bg.pu.buttons.ButtonEditor;
import bg.pu.buttons.ButtonRenderer;
import bg.pu.entity.Grade;
import bg.pu.entity.Student;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MarkTablePanel extends JPanel {
  Student student;
  JTable jtable;
  JLabel jLabel, title;
  String[] columnName = {"Subject", "Mark", "Update grade", "Delete grade"};
  DataService dataService = new DataService();

  public MarkTablePanel(Student student, MarksPanel marksPanel) {
    title = new JLabel("All marks");
    title.setFont(new Font("Verdana", Font.ITALIC, 20));
    this.add(title);
    this.student = student;
    GridBagLayout layout = new GridBagLayout();
    this.setLayout(layout);
    jLabel =
        new JLabel(
            student.getFirstName()
                + " "
                + student.getSecondName()
                + " "
                + student.getThirdName()
                + "'s marks");
    ArrayList<Grade> gradeArrayList = dataService.getAllGradesByStudent(student);
    Object[][] data = new Object[gradeArrayList.size()][4];
    for (int i = 0; i < gradeArrayList.size(); i++) {
      data[i][0] = gradeArrayList.get(i).getSubject().getName();
      data[i][1] = gradeArrayList.get(i).getGradeValue();
      data[i][2] = "Update grade";
      data[i][3] = "Delete grade";
    }

    this.jtable = new JTable(data, columnName);
    jtable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());

    jtable
        .getColumnModel()
        .getColumn(2)
        .setCellEditor(new ButtonEditor(new JTextField(), gradeArrayList, student, marksPanel));
    jtable.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());

    jtable
        .getColumnModel()
        .getColumn(3)
        .setCellEditor(new ButtonEditor(new JTextField(), gradeArrayList, student, marksPanel));

    JScrollPane pane = new JScrollPane(jtable);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    gbc.weightx = 1;
    gbc.weighty = 1;
    gbc.fill = GridBagConstraints.BOTH;
    this.add(pane, gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridwidth = 2;
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.weightx = 0.5;
    gbc.weightx = 0;
    gbc.weighty = 0;
    this.add(jtable);
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }
}
