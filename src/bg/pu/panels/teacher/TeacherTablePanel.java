package bg.pu.panels.teacher;

import bg.pu.buttons.ButtonEditor;
import bg.pu.buttons.ButtonRenderer;
import bg.pu.entity.Teacher;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TeacherTablePanel extends JPanel {
  JTable jtable;
  JLabel jLabel;
  String[] columnName = {"Teacher Name", "Update", "Delete"};
  DataService dataService = new DataService();

  public TeacherTablePanel(JPanel teacherPanel) {

    jLabel = new JLabel("All teachers");
    jLabel.setFont(new Font("Verdana", Font.ITALIC, 20));
    this.add(jLabel);
    ArrayList<Teacher> teacherArrayList = dataService.getAllTeachers();
    Object[][] data = new Object[teacherArrayList.size()][3];
    for (int i = 0; i < teacherArrayList.size(); i++) {
      data[i][0] = teacherArrayList.get(i).getFullName();
      data[i][1] = "Update teacher";
      data[i][2] = "Delete teacher";
    }
    this.jtable = new JTable(data, columnName);

    jtable.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
    jtable
        .getColumnModel()
        .getColumn(1)
        .setCellEditor(new ButtonEditor(new JTextField(), teacherArrayList, teacherPanel, true));

    jtable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
    jtable
        .getColumnModel()
        .getColumn(2)
        .setCellEditor(new ButtonEditor(new JTextField(), teacherArrayList, teacherPanel, true));

    JScrollPane pane = new JScrollPane(jtable);
    this.add(jtable);
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  }
}
