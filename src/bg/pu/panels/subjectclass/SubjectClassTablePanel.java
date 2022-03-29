package bg.pu.panels.subjectclass;

import bg.pu.buttons.ButtonEditor;
import bg.pu.buttons.ButtonRenderer;
import bg.pu.entity.SubjectClass;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SubjectClassTablePanel extends JPanel {
  DataService dataService = new DataService();

  JTable jtable;
  JLabel jLabel;
  String[] columnName = {"Subject name", "Class", "Update subject class ", "Delete subject class"};
  private JButton buttonAddStudent = new JButton("Update subject class");
  private JButton returnBackButton = new JButton("Back");

  public SubjectClassTablePanel(SubjectClassPanel jpanel) {

    jLabel = new JLabel("All subjects");
    jLabel.setFont(new Font("Verdana", Font.ITALIC, 20));
    this.add(jLabel);
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
        .setCellEditor(new ButtonEditor(new JTextField(), subjectClassArrayList, 1, jpanel));
    jtable.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());

    jtable
        .getColumnModel()
        .getColumn(3)
        .setCellEditor(new ButtonEditor(new JTextField(), subjectClassArrayList, 1, jpanel));
    this.add(jtable);
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  }
}
