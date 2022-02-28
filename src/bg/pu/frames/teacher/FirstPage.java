package bg.pu.frames.teacher;

import bg.pu.entity.ClassOfStudents;
import bg.pu.entity.Teacher;
import bg.pu.panels.classes.ClassPagePanel;
import bg.pu.panels.subjectclass.SubjectClassPanel;
import bg.pu.panels.subjects.SubjectPanel;
import bg.pu.panels.teacher.TeacherPickerPanel;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FirstPage extends JFrame {
  DataService dataService = new DataService();

  public void displayFirstPage(
      ArrayList<Teacher> teacherArrayList, ArrayList<ClassOfStudents> classOfStudentsArrayList) {
    GridLayout gridLayout = new GridLayout(1, 2);
    this.setLayout(gridLayout);
    gridLayout.layoutContainer(this);
    this.add(new TeacherPickerPanel(teacherArrayList, this));
    this.add(new ClassPagePanel(classOfStudentsArrayList));
    this.add(new SubjectPanel(dataService.getAllSubjects()));
    this.add(new SubjectClassPanel());
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(screenSize.width, screenSize.height);
    this.setVisible(true);
  }
}
