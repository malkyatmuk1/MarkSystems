package bg.pu.frames.teacher;

import bg.pu.panels.classes.ClassPanel;
import bg.pu.panels.report.ReportPanel;
import bg.pu.panels.subjectclass.SubjectClassPanel;
import bg.pu.panels.subjects.SubjectPanel;
import bg.pu.panels.teacher.TeacherPanel;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;

public class FirstPage extends JFrame {
  DataService dataService = new DataService();

  public void displayFirstPage() {
    JTabbedPane tabbedPane = new JTabbedPane();
    tabbedPane.add("Teachers", new TeacherPanel(0));
    tabbedPane.add("Classes", new ClassPanel(0));
    tabbedPane.add("Subject", new SubjectPanel(dataService.getAllSubjects()));
    tabbedPane.add("Subject to Class", new SubjectClassPanel());
    tabbedPane.add("Report", new ReportPanel());
    this.add(tabbedPane);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(screenSize.width / 2, screenSize.height / 2);
    this.setVisible(true);
  }
}
