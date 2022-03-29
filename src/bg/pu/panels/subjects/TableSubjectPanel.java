package bg.pu.panels.subjects;

import bg.pu.buttons.ButtonEditor;
import bg.pu.buttons.ButtonRenderer;
import bg.pu.entity.Subjects;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TableSubjectPanel extends JPanel {
  JTable jtable;
  JLabel jLabel;
  String[] columnName = {"Subject Name", "Update subject", "Delete subject"};
  DataService dataService = new DataService();

  public TableSubjectPanel(SubjectPanel subjectPanel) {

    jLabel = new JLabel("All subjects");
    jLabel.setFont(new Font("Verdana", Font.ITALIC, 20));
    this.add(jLabel);
    ArrayList<Subjects> subjectsArrayList = dataService.getAllSubjects();
    Object[][] data = new Object[subjectsArrayList.size()][3];
    for (int i = 0; i < subjectsArrayList.size(); i++) {
      data[i][0] = subjectsArrayList.get(i).getName();
      data[i][1] = "Update subject";
      data[i][2] = "Delete subject";
    }
    this.jtable = new JTable(data, columnName);

    jtable.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
    jtable
        .getColumnModel()
        .getColumn(1)
        .setCellEditor(new ButtonEditor(new JTextField(), subjectsArrayList, subjectPanel));

    jtable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
    jtable
        .getColumnModel()
        .getColumn(2)
        .setCellEditor(new ButtonEditor(new JTextField(), subjectsArrayList, subjectPanel));

    JScrollPane pane = new JScrollPane(jtable);
    this.add(jtable);
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  }
}
