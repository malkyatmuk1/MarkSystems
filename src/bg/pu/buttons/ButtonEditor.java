package bg.pu.buttons;

import bg.pu.TabbedPane;
import bg.pu.entity.*;
import bg.pu.panels.classes.ClassPanel;
import bg.pu.panels.grade.MarksPanel;
import bg.pu.panels.students.StudentsPanel;
import bg.pu.panels.subjectclass.SubjectClassPanel;
import bg.pu.panels.subjects.SubjectPanel;
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
  private ArrayList<Subjects> subjectsArrayList;
  private int indexClassOfStudents;
  DataService dataService = new DataService();
  TabbedPane tabbedPane;
  JPanel jPanel;
  MarksPanel marksPanel;
  Student student;

  public ButtonEditor(
      JTextField txt,
      ArrayList<Student> studentArrayList,
      JPanel jPanel,
      TabbedPane tabbedPane,
      MarksPanel marksPanel,
      int classOfStudents) {
    super(txt);

    btn = new JButton();
    btn.setOpaque(true);
    this.jPanel = jPanel;
    this.tabbedPane = tabbedPane;
    this.marksPanel = marksPanel;
    this.studentArrayList = studentArrayList;
    this.indexClassOfStudents = classOfStudents;
    btn.addActionListener(e -> fireEditingStopped());
  }

  public ButtonEditor(
      JTextField txt, ArrayList<Grade> gradeArrayList, Student student, JPanel jPanel) {
    super(txt);

    btn = new JButton();
    btn.setOpaque(true);
    this.jPanel = jPanel;
    this.student = student;
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

  public ButtonEditor(JTextField txt, ArrayList<Subjects> subjectsArrayList, SubjectPanel jPanel) {
    super(txt);

    btn = new JButton();
    btn.setOpaque(true);
    this.jPanel = jPanel;
    this.subjectsArrayList = subjectsArrayList;

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
        tabbedPane.setIndexStudent(this.studentArrayList.get(id).getStudentId());
        marksPanel.setStudent(dataService.getStudentById(tabbedPane.getIndexStudent()));
        MarksPanel marksPanelNew = new MarksPanel(marksPanel.getStudent(), id);
        marksPanel.removeAll();
        marksPanel.add(marksPanelNew);
        marksPanel.revalidate();
        marksPanel.repaint();
        tabbedPane.setSelectedComponent(marksPanel);
      } else if (lbl.equals("Delete student")) {
        dataService.deleteStudent(this.studentArrayList.get(id));
        StudentsPanel studentsPanel =
            new StudentsPanel(this.indexClassOfStudents, tabbedPane, marksPanel, 0);
        jPanel.removeAll();
        jPanel.add(studentsPanel);
        jPanel.revalidate();
        jPanel.repaint();
      } else if (lbl.equals("Update student")) {
        StudentsPanel studentsPanel =
            new StudentsPanel(this.indexClassOfStudents, tabbedPane, marksPanel, id);
        jPanel.removeAll();
        jPanel.add(studentsPanel);
        jPanel.revalidate();
        jPanel.repaint();
      } else if (lbl.equals("Update grade")) {
        MarksPanel marksPanel = new MarksPanel(student, id);
        jPanel.removeAll();
        jPanel.add(marksPanel);
        jPanel.revalidate();
        jPanel.repaint();
      } else if (lbl.equals("Delete grade")) {
        dataService.deleteGrade(this.gradeArrayList.get(id));
        MarksPanel marksPanel = new MarksPanel(student, 0);
        jPanel.removeAll();
        jPanel.add(marksPanel);
        jPanel.revalidate();
        jPanel.repaint();
      } else if (lbl.equals("Update subject class")) {
        SubjectClassPanel subjectClassPanel = new SubjectClassPanel(id, 0, 0);
        jPanel.removeAll();
        jPanel.add(subjectClassPanel);
        jPanel.revalidate();
        jPanel.repaint();
      } else if (lbl.equals("Delete subject class")) {
        dataService.deleteSubjectClass(this.subjectClassArrayList.get(id));
        SubjectClassPanel subjectClassPanel = new SubjectClassPanel(id - 1, 0, 0);
        jPanel.removeAll();
        jPanel.add(subjectClassPanel);
        jPanel.revalidate();
        jPanel.repaint();
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
      } else if (lbl.equals("Update subject")) {
        SubjectPanel subjectPanel = new SubjectPanel(id);
        jPanel.removeAll();
        jPanel.add(subjectPanel);
        jPanel.revalidate();
        jPanel.repaint();
      } else if (lbl.equals("Delete subject")) {
        dataService.deleteSubject(subjectsArrayList.get(id).getName());
        SubjectPanel subjectPanel = new SubjectPanel(0);
        jPanel.removeAll();
        jPanel.add(subjectPanel);
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
