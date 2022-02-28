package bg.pu.panels.students;

import bg.pu.entity.ClassOfStudents;
import bg.pu.entity.Student;
import bg.pu.frames.students.StudentClassPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UpdateStudentPanel extends JPanel {

  private JLabel teacherFirstName = new JLabel("First name");
  private JLabel teacherSecondName = new JLabel("Second name");
  private JLabel teacherThirdName = new JLabel("Third name");
  private JLabel classOfStudent = new JLabel("Class of the student");
  private JLabel title = new JLabel("Update student");
  private JTextField firstName = new JTextField("Write first name");
  private JTextField secondName = new JTextField("Write second name");
  private JTextField thirdName = new JTextField("Write third name");
  private JButton addButton = new JButton("Update");
  private JButton returnBackButton = new JButton("Back");
  DataService dataService = new DataService();
  private JComboBox comboBox;

  public UpdateStudentPanel(Student student) {

    firstName.setText(student.getFirstName());
    secondName.setText(student.getSecondName());
    thirdName.setText(student.getThirdName());
    GridBagLayout layout = new GridBagLayout();
    this.setLayout(layout);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 0;
    this.add(title, gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.weightx = 0.5;
    this.add(firstName, gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    this.add(teacherFirstName, gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.weightx = 0.5;
    this.add(secondName, gbc);
    gbc.gridx = 0;
    gbc.gridy = 2;
    this.add(teacherSecondName, gbc);
    gbc.gridx = 1;
    gbc.gridy = 3;
    gbc.weightx = 0.5;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    this.add(thirdName, gbc);
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.weightx = 0;
    this.add(teacherThirdName, gbc);
    ArrayList<ClassOfStudents> classOfStudentsArrayList = dataService.getAllClass();
    String[] className = new String[classOfStudentsArrayList.size()];
    for (int i = 0; i < classOfStudentsArrayList.size(); i++) {
      className[i] = classOfStudentsArrayList.get(i).getName();
    }
    comboBox = new JComboBox(className);
    comboBox.setSelectedIndex(student.getClassStudent().getClassId() - 1);
    comboBox.setBounds(100, 100, 150, 40);

    gbc.gridx = 1;
    gbc.gridy = 4;
    gbc.weightx = 0.5;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    this.add(comboBox, gbc);
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.weightx = 0;
    this.add(classOfStudent, gbc);
    gbc.gridx = 1;
    gbc.gridy = 5;
    gbc.weightx = 0.5;
    gbc.gridx = 0;
    gbc.gridy = 6;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridwidth = 0;
    this.add(addButton, gbc);
    gbc.gridx = 0;
    gbc.gridy = 7;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridwidth = 0;
    this.add(returnBackButton, gbc);
    addButton.addActionListener(
        e -> {
          dataService.updateStudent(
              firstName,
              secondName,
              thirdName,
              classOfStudentsArrayList.get(comboBox.getSelectedIndex()).getClassId(),
              student.getStudentId());

          StudentClassPage studentClassPage = new StudentClassPage();
          studentClassPage.displayStudentClassPage(
              classOfStudentsArrayList.get(comboBox.getSelectedIndex()));
          JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(UpdateStudentPanel.this);
          frame.dispose();
        });
    returnBackButton.addActionListener(
        e -> {
          StudentClassPage studentClassPage = new StudentClassPage();
          studentClassPage.displayStudentClassPage(
              classOfStudentsArrayList.get(comboBox.getSelectedIndex()));
          JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(UpdateStudentPanel.this);
          frame.dispose();
        });
  }
}
