package bg.pu.panels.teacher;

import bg.pu.entity.Teacher;
import bg.pu.frames.teacher.FirstPage;
import bg.pu.frames.teacher.UpdateTeacherPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;

public class TeacherMenuPanel extends JPanel {
  private JButton buttonUpdateTeacher = new JButton("Update teacher");
  private JButton buttonDeleteTeacher = new JButton("Delete teacher");
  private JButton returnBackButton = new JButton("Back");
  DataService dataService = new DataService();

  public TeacherMenuPanel(Teacher teacher) {
    GridBagLayout layout = new GridBagLayout();
    this.setLayout(layout);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 0;
    this.add(buttonUpdateTeacher, gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 1;
    this.add(buttonDeleteTeacher, gbc);
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridwidth = 2;
    this.add(returnBackButton, gbc);
    buttonUpdateTeacher.addActionListener(
        e -> {
          UpdateTeacherPage updateTecherPage = new UpdateTeacherPage();
          updateTecherPage.displayUpdateTeacherPage(teacher);
          JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(TeacherMenuPanel.this);
          frame.dispose();
        });
    buttonDeleteTeacher.addActionListener(
        e -> {
          dataService.deleteTeacher(teacher);
          FirstPage firstPage = new FirstPage();
          firstPage.displayFirstPage(dataService.getAllTeachers(), dataService.getAllClass());
          JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(TeacherMenuPanel.this);
          frame.dispose();
        });
    returnBackButton.addActionListener(
        e -> {
          FirstPage firstPage = new FirstPage();
          firstPage.displayFirstPage(dataService.getAllTeachers(), dataService.getAllClass());
          JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(TeacherMenuPanel.this);
          frame.dispose();
        });
  }
}
