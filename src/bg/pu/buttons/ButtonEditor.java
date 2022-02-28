package bg.pu.buttons;

import bg.pu.entity.Grade;
import bg.pu.entity.Student;
import bg.pu.entity.SubjectClass;
import bg.pu.frames.grade.GradeTablePage;
import bg.pu.frames.grade.UpdateGradePage;
import bg.pu.frames.students.UpdateStudentPage;
import bg.pu.frames.subjectclass.UpdateSubjectClassPage;
import bg.pu.frames.teacher.FirstPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ButtonEditor extends DefaultCellEditor {
  protected JButton btn;
  private String lbl;
  private Boolean clicked;
  private int id;
  private ArrayList<Student> studentArrayList;
  private ArrayList<Grade> gradeArrayList;
  private ArrayList<SubjectClass> subjectClassArrayList;
  DataService dataService = new DataService();
  JPanel jPanel;

  public ButtonEditor(JTextField txt, ArrayList<Student> studentArrayList, JPanel jPanel) {
    super(txt);

    btn = new JButton();
    btn.setOpaque(true);
    this.jPanel = jPanel;
    this.studentArrayList = studentArrayList;

    btn.addActionListener(e -> fireEditingStopped());
  }

  public ButtonEditor(
      JTextField txt, ArrayList<Grade> gradeArrayList, boolean isGrade, JPanel jPanel) {
    super(txt);

    btn = new JButton();
    btn.setOpaque(true);
    this.jPanel = jPanel;
    this.gradeArrayList = gradeArrayList;

    btn.addActionListener(e -> fireEditingStopped());
  }

  public ButtonEditor(
      JTextField txt, ArrayList<SubjectClass> subjectClassArrayList, int isGrade, JPanel jPanel) {
    super(txt);

    btn = new JButton();
    btn.setOpaque(true);
    this.jPanel = jPanel;
    this.subjectClassArrayList = subjectClassArrayList;

    btn.addActionListener(e -> fireEditingStopped());
  }

  @Override
  public Component getTableCellEditorComponent(
      JTable table, Object obj, boolean selected, int row, int col) {

    lbl = (obj == null) ? "" : obj.toString();
    this.id = row;
    btn.setText(lbl);
    clicked = true;
    return btn;
  }

  @Override
  public Object getCellEditorValue() {

    if (clicked) {

      if (lbl.equals("View marks")) {
        new GradeTablePage().displayGradePage(this.studentArrayList.get(id));
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(jPanel);
        frame.dispose();
      } else if (lbl.equals("Delete student")) {
        dataService.deleteStudent(this.studentArrayList.get(id));
        FirstPage firstPage = new FirstPage();
        firstPage.displayFirstPage(dataService.getAllTeachers(), dataService.getAllClass());
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(jPanel);
        frame.dispose();
      } else if (lbl.equals("Update student")) {
        new UpdateStudentPage().displayStudentPage(this.studentArrayList.get(id));
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(jPanel);
        frame.dispose();
      } else if (lbl.equals("Update grade")) {
        new UpdateGradePage().displayUpdateGradePage(this.gradeArrayList.get(id));
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(jPanel);
        frame.dispose();
      } else if (lbl.equals("Delete grade")) {
        dataService.deleteGrade(this.gradeArrayList.get(id));
        FirstPage firstPage = new FirstPage();
        firstPage.displayFirstPage(dataService.getAllTeachers(), dataService.getAllClass());
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(jPanel);
        frame.dispose();
      } else if (lbl.equals("Update subject class")) {
        new UpdateSubjectClassPage()
            .displayUpdateSubjectClassPage(this.subjectClassArrayList.get(id));
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(jPanel);
        frame.dispose();
      } else if (lbl.equals("Delete subject class")) {
        dataService.deleteSubjectClass(this.subjectClassArrayList.get(id));
        FirstPage firstPage = new FirstPage();
        firstPage.displayFirstPage(dataService.getAllTeachers(), dataService.getAllClass());
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(jPanel);
        frame.dispose();
      }
    }
    clicked = false;
    return new String(lbl);
  }

  @Override
  public boolean stopCellEditing() {

    clicked = false;
    return super.stopCellEditing();
  }

  @Override
  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
}
