package bg.pu.panels.grade;

import bg.pu.entity.Student;
import bg.pu.service.DataService;

import javax.swing.*;
import java.util.ArrayList;

public class ChooseStudentMarkPanel extends JPanel {
  JComboBox allStudents = new JComboBox();
  DataService dataService = new DataService();

  public ChooseStudentMarkPanel(int studentId, MarksPanel marksPanel) {
    ArrayList<Student> studentArrayList = dataService.getAllStudents();
    String[] studentsName = new String[studentArrayList.size()];
    for (int i = 0; i < studentArrayList.size(); i++) {
      studentsName[i] = studentArrayList.get(i).getFullName();
    }
    allStudents = new JComboBox(studentsName);
    allStudents.setSelectedIndex(getIndexOfStudent(studentArrayList, studentId));
    allStudents.setBounds(100, 100, 150, 40);
    this.add(allStudents);
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    allStudents.addActionListener(
        e -> {
          MarksPanel marksPanelNew =
              new MarksPanel(dataService.getAllStudents().get(allStudents.getSelectedIndex()), 0);

          marksPanel.removeAll();
          marksPanel.add(marksPanelNew);
          marksPanel.revalidate();
          marksPanel.repaint();
        });
  }

  private int getIndexOfStudent(ArrayList<Student> students, int studentId) {
    for (int i = 0; i < students.size(); i++) {
      if (students.get(i).getStudentId() == studentId) return i;
    }
    return 0;
  }
}
