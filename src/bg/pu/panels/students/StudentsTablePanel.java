package bg.pu.panels.students;

import bg.pu.buttons.ButtonEditor;
import bg.pu.buttons.ButtonRenderer;
import bg.pu.entity.ClassOfStudents;
import bg.pu.entity.Student;
import bg.pu.frames.classes.ClassMenuPage;
import bg.pu.frames.students.AddStudentPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StudentsTablePanel extends JPanel {
  DataService dataService = new DataService();

  JTable jtable;
  String[] columnName = {"Name", "View marks", "Delete student", "Update student"};
  private JButton buttonAddStudent = new JButton("Add Student");
  private JButton returnBackButton = new JButton("Back");

  public StudentsTablePanel(ClassOfStudents classOfStudents) {
    GridBagLayout layout = new GridBagLayout();
    this.setLayout(layout);
    ArrayList<Student> studentArrayList = dataService.getAllStudentsByClassId(classOfStudents);
    Object[][] data = new Object[studentArrayList.size()][4];
    for (int i = 0; i < studentArrayList.size(); i++) {
      data[i][0] =
          studentArrayList.get(i).getFirstName()
              + " "
              + studentArrayList.get(i).getSecondName()
              + " "
              + studentArrayList.get(i).getThirdName();
      data[i][1] = "View marks";
      data[i][2] = "Delete student";
      data[i][3] = "Update student";
    }

    this.jtable = new JTable(data, columnName);
    jtable.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());

    jtable
        .getColumnModel()
        .getColumn(1)
        .setCellEditor(new ButtonEditor(new JTextField(), studentArrayList, this));
    jtable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());

    jtable
        .getColumnModel()
        .getColumn(2)
        .setCellEditor(new ButtonEditor(new JTextField(), studentArrayList, this));
    jtable.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());

    jtable
        .getColumnModel()
        .getColumn(3)
        .setCellEditor(new ButtonEditor(new JTextField(), studentArrayList, this));

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
    this.add(buttonAddStudent, gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 2;
    this.add(returnBackButton, gbc);

    buttonAddStudent.addActionListener(
        e -> {
          AddStudentPage addStudentPage = new AddStudentPage();
          addStudentPage.displayAddStudentPage(classOfStudents);
          JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(StudentsTablePanel.this);
          frame.dispose();
        });
    returnBackButton.addActionListener(
        e -> {
          ClassMenuPage classMenuPage = new ClassMenuPage();
          classMenuPage.displayClassMenuPage(classOfStudents);
          JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(StudentsTablePanel.this);
          frame.dispose();
        });
  }
}
