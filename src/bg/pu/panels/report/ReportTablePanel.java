package bg.pu.panels.report;

import bg.pu.entity.StudentWithGrade;
import bg.pu.frames.teacher.FirstPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ReportTablePanel extends JPanel {
  JTable jtable;
  JLabel jLabel;
  String[] columnName = {"Student number", "Student Name", "Grade", "Subject"};
  DataService dataService = new DataService();
  private JButton returnBackButton = new JButton("Back");

  public ReportTablePanel() {
    BorderLayout layout = new BorderLayout();
    this.setLayout(layout);
    jLabel = new JLabel("This is a report for excellent students in 1A");
    this.add(jLabel, BorderLayout.PAGE_START);
    ArrayList<StudentWithGrade> studentArrayList = dataService.getReportForAStudents();
    Object[][] data = new Object[studentArrayList.size()][4];
    for (int i = 0; i < studentArrayList.size(); i++) {
      data[i][0] = studentArrayList.get(i).getStudent().getStudentId();
      data[i][1] = studentArrayList.get(i).getStudent().getFullName();
      data[i][2] = studentArrayList.get(i).getGrade();
      data[i][3] = studentArrayList.get(i).getSubjectName();
    }

    this.jtable = new JTable(data, columnName);
    JScrollPane pane = new JScrollPane(jtable);
    this.add(pane, BorderLayout.CENTER);
    this.add(returnBackButton, BorderLayout.PAGE_END);

    returnBackButton.addActionListener(
        e -> {
          FirstPage firstPage = new FirstPage();
          firstPage.displayFirstPage();
          JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ReportTablePanel.this);
          frame.dispose();
        });
  }
}
