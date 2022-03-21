package bg.pu.panels.teacher;

import bg.pu.entity.Teacher;

import javax.swing.*;
import java.util.ArrayList;

public class TeacherPickerPanel extends JPanel {

  //  private JLabel firstLable = new JLabel("Welcome to CMS");
  //  private JLabel secondLable = new JLabel("Pick your name.");
  //  private JComboBox comboBox;
  //  private JButton buttonAddTeacher = new JButton("Add teacher");
  //  DataService dataService = new DataService();

  public TeacherPickerPanel(ArrayList<Teacher> teacherArrayList, JFrame frame) {
    //    GridBagLayout layout = new GridBagLayout();
    //    this.setLayout(layout);
    //    GridBagConstraints gbc = new GridBagConstraints();
    //    gbc.fill = GridBagConstraints.HORIZONTAL;
    //    gbc.gridx = 0;
    //    gbc.gridy = 0;
    //    this.add(firstLable, gbc);
    //    gbc.fill = GridBagConstraints.HORIZONTAL;
    //    gbc.ipady = 20;
    //    gbc.gridx = 0;
    //    gbc.gridy = 1;
    //    this.add(secondLable, gbc);
    //    gbc.gridx = 0;
    //    gbc.gridy = 2;
    //    gbc.fill = GridBagConstraints.HORIZONTAL;
    //    gbc.gridwidth = 2;
    //
    //    String[] teacherName = new String[teacherArrayList.size()];
    //    for (int i = 0; i < teacherArrayList.size(); i++) {
    //      teacherName[i] =
    //          teacherArrayList.get(i).getFirstName()
    //              + " "
    //              + teacherArrayList.get(i).getSecondName()
    //              + " "
    //              + teacherArrayList.get(i).getThirdName();
    //    }
    //    comboBox = new JComboBox(teacherName);
    //    comboBox.setBounds(100, 100, 150, 40);
    //    this.add(comboBox, gbc);
    //    gbc.gridx = 0;
    //    gbc.gridy = 4;
    //    gbc.fill = GridBagConstraints.HORIZONTAL;
    //    gbc.gridwidth = 4;
    //    this.add(buttonAddTeacher, gbc);
    //    comboBox.addActionListener(
    //        e -> {
    //          TeacherMenuPage teacherMenuPAge = new TeacherMenuPage();
    //          teacherMenuPAge.displaySecondPage(
    //              dataService.getTeacherById(
    //                  teacherArrayList.get(comboBox.getSelectedIndex()).getTeacherId()));
    //          JFrame frame1 = (JFrame) SwingUtilities.getWindowAncestor(TeacherPickerPanel.this);
    //          frame1.dispose();
    //        });
    //    buttonAddTeacher.addActionListener(
    //        e -> {
    //          AddTeacherPage addTeacherPage = new AddTeacherPage();
    //          addTeacherPage.displayAddTeacherPage();
    //          frame.dispose();
    //        });
  }
}
