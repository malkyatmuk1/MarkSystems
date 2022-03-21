package bg.pu.panels.subjectclass;

import bg.pu.buttons.ButtonEditor;
import bg.pu.buttons.ButtonRenderer;
import bg.pu.entity.SubjectClass;
import bg.pu.frames.teacher.FirstPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SubjectClassTablePanel extends JPanel {
  DataService dataService = new DataService();

  JTable jtable;
  String[] columnName = {"Subject name", "Class", "Update subject class ", "Delete subject class"};
  private JButton buttonAddStudent = new JButton("Update subject class");
  private JButton returnBackButton = new JButton("Back");

  public SubjectClassTablePanel() {
    BorderLayout layout = new BorderLayout();
    this.setLayout(layout);
    ArrayList<SubjectClass> subjectClassArrayList = dataService.getAllSubjectClass();
    Object[][] data = new Object[subjectClassArrayList.size()][4];
    for (int i = 0; i < subjectClassArrayList.size(); i++) {
      data[i][0] = subjectClassArrayList.get(i).getSubject().getName();
      data[i][1] = subjectClassArrayList.get(i).getClassId().getName();
      data[i][2] = "Update subject class";
      data[i][3] = "Delete subject class";
    }
    this.jtable = new JTable(data, columnName);

    jtable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());

    jtable
        .getColumnModel()
        .getColumn(2)
        .setCellEditor(new ButtonEditor(new JTextField(), subjectClassArrayList, 1, this));
    jtable.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());

    jtable
        .getColumnModel()
        .getColumn(3)
        .setCellEditor(new ButtonEditor(new JTextField(), subjectClassArrayList, 1, this));
    JScrollPane pane = new JScrollPane(jtable);
    this.add(pane, BorderLayout.CENTER);
    this.add(returnBackButton, BorderLayout.PAGE_END);
    returnBackButton.addActionListener(
        e -> {
          FirstPage firstPage = new FirstPage();
          firstPage.displayFirstPage();
          JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(SubjectClassTablePanel.this);
          frame.dispose();
        });
  }
}
