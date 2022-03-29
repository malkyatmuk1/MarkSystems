package bg.pu.frames.teacher;

import bg.pu.TabbedPane;
import bg.pu.panels.classes.ClassPanel;
import bg.pu.panels.grade.MarksPanel;
import bg.pu.panels.report.ReportTablePanel;
import bg.pu.panels.students.StudentsPanel;
import bg.pu.panels.subjectclass.SubjectClassPanel;
import bg.pu.panels.subjects.SubjectPanel;
import bg.pu.panels.teacher.TeacherPanel;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FirstPage extends JFrame {
  DataService dataService = new DataService();

  public void displayFirstPage() {
    TabbedPane tabbedPane = new TabbedPane(1);
    MarksPanel marksPanel =
        new MarksPanel(dataService.getStudentById(tabbedPane.getIndexStudent()));
    tabbedPane.add("Teachers", new TeacherPanel(0));
    tabbedPane.add("Classes", new ClassPanel(0));
    tabbedPane.add("Subject", new SubjectPanel(0));
    tabbedPane.add("Subject to Class", new SubjectClassPanel(0, 0, 0));
    tabbedPane.add("Students", new StudentsPanel(0, tabbedPane, marksPanel, 0));
    tabbedPane.add("Marks", marksPanel);
    tabbedPane.add("Report", new ReportTablePanel(0, 0));
    this.add(tabbedPane);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(screenSize.width / 2, screenSize.height / 2);
    this.setVisible(true);
    tabbedPane.addMouseListener(
        new MouseListener() {

          @Override
          public void mouseClicked(MouseEvent e) {
            int selectedIndex = tabbedPane.getSelectedIndex();
            System.out.println(selectedIndex);
            tabbedPane.removeAll();
            tabbedPane.revalidate();
            tabbedPane.add("Teachers", new TeacherPanel(0));
            tabbedPane.add("Classes", new ClassPanel(0));
            tabbedPane.add("Subject", new SubjectPanel(0));
            tabbedPane.add("Subject to Class", new SubjectClassPanel(0, 0, 0));
            tabbedPane.add("Students", new StudentsPanel(0, tabbedPane, marksPanel, 0));
            tabbedPane.add("Marks", marksPanel);
            tabbedPane.add("Report", new ReportTablePanel(0, 0));
            tabbedPane.setSelectedIndex(selectedIndex);
            tabbedPane.repaint();
          }

          @Override
          public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

          }

          @Override
          public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

          }

          @Override
          public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

          }

          @Override
          public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub

          }
        });
  }
}
