package bg.pu.panels.students;

import bg.pu.TabbedPane;
import bg.pu.panels.grade.MarksPanel;
import bg.pu.service.DataService;

import javax.swing.*;

public class StudentsPanel extends JPanel {
  DataService dataService = new DataService();

  public StudentsPanel(
      int updateIndexClass, TabbedPane tabbedPane, MarksPanel marksPanel, int studentIndex) {
    UpdateStudentPanel updateStudentPanel =
        new UpdateStudentPanel(updateIndexClass, studentIndex, this, tabbedPane, marksPanel);
    StudentsTablePanel tablePanel =
        new StudentsTablePanel(this, updateIndexClass, tabbedPane, marksPanel);
    this.add(tablePanel);
    this.add(updateStudentPanel);
    this.add(new AddStudentPanel(this, tabbedPane, marksPanel));

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  }
}
