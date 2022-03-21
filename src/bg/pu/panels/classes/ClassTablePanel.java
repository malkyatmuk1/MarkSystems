package bg.pu.panels.classes;

import bg.pu.buttons.ButtonEditor;
import bg.pu.buttons.ButtonRenderer;
import bg.pu.entity.ClassOfStudents;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ClassTablePanel extends JPanel {
  JTable jtable;
  JLabel jLabel;
  String[] columnName = {"Class Name", "Update class", "Delete class"};
  DataService dataService = new DataService();

  public ClassTablePanel(ClassPanel classPanel) {
    jLabel = new JLabel("All class");
    jLabel.setFont(new Font("Verdana", Font.ITALIC, 20));
    this.add(jLabel);
    ArrayList<ClassOfStudents> classOfStudentsArrayList = dataService.getAllClass();
    Object[][] data = new Object[classOfStudentsArrayList.size()][3];
    for (int i = 0; i < classOfStudentsArrayList.size(); i++) {
      data[i][0] = classOfStudentsArrayList.get(i).getName();
      data[i][1] = "Update class";
      data[i][2] = "Delete class";
    }
    this.jtable = new JTable(data, columnName);

    jtable.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());
    jtable
        .getColumnModel()
        .getColumn(1)
        .setCellEditor(new ButtonEditor(new JTextField(), classOfStudentsArrayList, classPanel));

    jtable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
    jtable
        .getColumnModel()
        .getColumn(2)
        .setCellEditor(new ButtonEditor(new JTextField(), classOfStudentsArrayList, classPanel));

    JScrollPane pane = new JScrollPane(jtable);
    this.add(jtable);
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  }
}
