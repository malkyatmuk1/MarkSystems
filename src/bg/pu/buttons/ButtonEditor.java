package bg.pu.buttons;

import bg.pu.entity.*;
import bg.pu.frames.grade.GradeTablePage;
import bg.pu.frames.grade.UpdateGradePage;
import bg.pu.frames.students.UpdateStudentPage;
import bg.pu.frames.subjectclass.UpdateSubjectClassPage;
import bg.pu.frames.teacher.FirstPage;
import bg.pu.panels.classes.ClassPanel;
import bg.pu.panels.teacher.TeacherPanel;
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
  private ArrayList<Teacher> teacherArrayList;
  private ArrayList<ClassOfStudents> classOfStudentsArrayList;
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

  public ButtonEditor(
      JTextField txt, ArrayList<Teacher> teacherArrayList, JPanel jPanel, boolean isTeacher) {
    super(txt);

    btn = new JButton();
    btn.setOpaque(true);
    this.jPanel = jPanel;
    this.teacherArrayList = teacherArrayList;

    btn.addActionListener(e -> fireEditingStopped());
  }

  public ButtonEditor(
      JTextField txt, ArrayList<ClassOfStudents> classOfStudentsArrayList, ClassPanel jPanel) {
    super(txt);

    btn = new JButton();
    btn.setOpaque(true);
    this.jPanel = jPanel;
    this.classOfStudentsArrayList = classOfStudentsArrayList;

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
        firstPage.displayFirstPage();
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
        firstPage.displayFirstPage();
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
        firstPage.displayFirstPage();
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(jPanel);
        frame.dispose();
      } else if (lbl.equals("Update teacher")) {
        TeacherPanel teacherPanel = new TeacherPanel(id);
        jPanel.removeAll();
        jPanel.add(teacherPanel);
        jPanel.revalidate();
        jPanel.repaint();
      } else if (lbl.equals("Delete teacher")) {
        dataService.deleteTeacher(this.teacherArrayList.get(id));
        TeacherPanel teacherPanel = new TeacherPanel(0);
        jPanel.removeAll();
        jPanel.add(teacherPanel);
        jPanel.revalidate();
        jPanel.repaint();
      } else if (lbl.equals("Update class")) {
        ClassPanel classPanel = new ClassPanel(id);
        jPanel.removeAll();
        jPanel.add(classPanel);
        jPanel.revalidate();
        jPanel.repaint();
      } else if (lbl.equals("Delete class")) {
        dataService.deleteClass(this.classOfStudentsArrayList.get(id));
        ClassPanel classPanel = new ClassPanel(0);
        jPanel.removeAll();
        jPanel.add(classPanel);
        jPanel.revalidate();
        jPanel.repaint();
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
