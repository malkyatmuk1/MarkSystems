package bg.pu.panels.students;

import bg.pu.TabbedPane;
import bg.pu.buttons.ButtonEditor;
import bg.pu.buttons.ButtonRenderer;
import bg.pu.entity.ClassOfStudents;
import bg.pu.entity.Student;
import bg.pu.panels.grade.MarksPanel;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StudentsTablePanel extends JPanel {
  DataService dataService = new DataService();

  JTable jtable;
  JLabel jLabel;
  String[] columnName = {"Name", "View marks", "Delete student", "Update student"};
  private JComboBox comboBoxClass = new JComboBox();

  public StudentsTablePanel(
      StudentsPanel jpanel, int updateIndexClass, TabbedPane tabbedPane, MarksPanel marksPanel) {
    jLabel = new JLabel("All students");
    jLabel.setFont(new Font("Verdana", Font.ITALIC, 20));
    this.add(jLabel);
    ArrayList<ClassOfStudents> classArrayList = dataService.getAllClass();
    String[] className = new String[classArrayList.size()];
    for (int i = 0; i < classArrayList.size(); i++) {
      className[i] = classArrayList.get(i).getName();
    }
    comboBoxClass = new JComboBox(className);
    comboBoxClass.setBounds(100, 100, 150, 40);
    comboBoxClass.setSelectedIndex(updateIndexClass);
    GridBagLayout layout = new GridBagLayout();
    this.setLayout(layout);
    ClassOfStudents classOfStudents =
        dataService.getAllClass().get(comboBoxClass.getSelectedIndex());
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
        .setCellEditor(
            new ButtonEditor(
                new JTextField(),
                studentArrayList,
                jpanel,
                tabbedPane,
                marksPanel,
                comboBoxClass.getSelectedIndex()));
    jtable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());

    jtable
        .getColumnModel()
        .getColumn(2)
        .setCellEditor(
            new ButtonEditor(
                new JTextField(),
                studentArrayList,
                jpanel,
                tabbedPane,
                marksPanel,
                comboBoxClass.getSelectedIndex()));
    jtable.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());

    jtable
        .getColumnModel()
        .getColumn(3)
        .setCellEditor(
            new ButtonEditor(
                new JTextField(),
                studentArrayList,
                jpanel,
                tabbedPane,
                marksPanel,
                comboBoxClass.getSelectedIndex()));

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    gbc.weightx = 1;
    gbc.weighty = 1;
    gbc.fill = GridBagConstraints.BOTH;
    this.add(comboBoxClass, gbc);
    this.add(jtable);
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    comboBoxClass.addActionListener(
        e -> {
          StudentsPanel studentsPanelNew =
              new StudentsPanel(comboBoxClass.getSelectedIndex(), tabbedPane, marksPanel, 0);
          jpanel.removeAll();
          jpanel.add(studentsPanelNew);
          jpanel.revalidate();
          jpanel.repaint();
        });
  }
}
