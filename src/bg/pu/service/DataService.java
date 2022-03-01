package bg.pu.service;

import bg.pu.database.DBConnection;
import bg.pu.entity.*;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class DataService {

  // TEACHER
  public ArrayList<Teacher> getAllTeachers() {
    ArrayList<Teacher> teacherArrayList = new ArrayList<>();
    ResultSet result = executeQueryBySqlString("select * from teacher");
    try {
      ResultSetMetaData metaData = result.getMetaData();
      int columnCount = metaData.getColumnCount();
      int rowCount = 0;
      while (result.next()) {
        Object[] elements = new Object[columnCount];
        for (int j = 0; j < columnCount; j++) {
          elements[j] = result.getObject(j + 1);
        }
        teacherArrayList.add(
            new Teacher(
                Integer.parseInt(elements[0].toString()),
                elements[1].toString(),
                elements[2].toString(),
                elements[3].toString()));
        rowCount++;
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return teacherArrayList;
  }

  public Teacher getTeacherById(int teacherId) {
    String sql = "select * from teacher where teacherId=?";
    Object[] element = new Object[2];
    try {
      Connection conn = DBConnection.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, teacherId);
      ResultSet result = ps.executeQuery();
      ResultSetMetaData metaData = result.getMetaData();
      int columnCount = metaData.getColumnCount();

      while (result.next()) {
        element = new Object[columnCount];
        for (int j = 0; j < columnCount; j++) {
          element[j] = result.getObject(j + 1);
        }
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    Teacher teacher =
        new Teacher(
            Integer.parseInt(element[0].toString()),
            element[1].toString(),
            element[2].toString(),
            element[3].toString());
    return teacher;
  }

  public void addTeacher(JTextField firstName, JTextField secondName, JTextField thirdName) {
    String sql = "insert into teacher (FIRSTNAME, SECONDNAME, THIRDNAME) VALUES (?, ?, ?)";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement(sql);
      ps.setString(1, firstName.getText());
      ps.setString(2, secondName.getText());
      ps.setString(3, thirdName.getText());
      ps.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public void updateTeacher(
      JTextField firstName, JTextField secondName, JTextField thirdName, int teacherId) {
    String sql =
        "update teacher set FIRSTNAME = ?, SECONDNAME = ?, THIRDNAME = ?  where teacherid = ?";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement(sql);
      ps.setString(1, firstName.getText());
      ps.setString(2, secondName.getText());
      ps.setString(3, thirdName.getText());
      ps.setInt(4, teacherId);
      ps.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public void deleteTeacher(Teacher teacher) {
    String sql = "DELETE FROM teacher WHERE teacherId=?";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement(sql);
      ps.setInt(1, teacher.getTeacherId());
      ps.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  // CLASS
  public ArrayList<ClassOfStudents> getAllClass() {
    ArrayList<ClassOfStudents> classOfStudentsArrayList = new ArrayList<>();
    ResultSet result = executeQueryBySqlString("select * from class");
    try {
      ResultSetMetaData metaData = result.getMetaData();
      int columnCount = metaData.getColumnCount();
      int rowCount = 0;
      while (result.next()) {
        Object[] elements = new Object[columnCount];
        for (int j = 0; j < columnCount; j++) {
          elements[j] = result.getObject(j + 1);
        }
        classOfStudentsArrayList.add(
            new ClassOfStudents(
                Integer.parseInt(elements[0].toString()),
                getTeacherById(Integer.parseInt(elements[2].toString())),
                elements[1].toString()));
        rowCount++;
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return classOfStudentsArrayList;
  }

  public void addClass(String name, int teacherId) {
    String sql = "insert into class (NAME, TEACHERID) VALUES (?, ?)";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement(sql);
      ps.setString(1, name);
      ps.setInt(2, teacherId);
      ps.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public void updateClass(ClassOfStudents classOfStudents, String name, Teacher teacher) {

    String sql = "update class set NAME = ?, TEACHERID=? where CLASSID = ?";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement(sql);
      ps.setString(1, name);
      ps.setInt(2, teacher.getTeacherId());
      ps.setInt(3, classOfStudents.getClassId());
      ps.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public void deleteClass(ClassOfStudents classOfStudents) {

    String sql = "delete from class where CLASSID = ?";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement(sql);
      ps.setInt(1, classOfStudents.getClassId());
      ps.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public ClassOfStudents getClassById(int classId) {

    String sql = "select * from class where classid=?";
    Object[] element = new Object[3];
    try {
      Connection conn = DBConnection.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, classId);
      ResultSet result = ps.executeQuery();
      ResultSetMetaData metaData = result.getMetaData();
      int columnCount = metaData.getColumnCount();

      while (result.next()) {
        element = new Object[columnCount];
        for (int j = 0; j < columnCount; j++) {
          element[j] = result.getObject(j + 1);
        }
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    ClassOfStudents classOfStudents =
        new ClassOfStudents(
            Integer.parseInt(element[0].toString()),
            getTeacherById(Integer.parseInt(element[2].toString())),
            element[1].toString());
    return classOfStudents;
  }

  // SUBJECT
  public ArrayList<Subjects> getAllSubjects() {
    ArrayList<Subjects> subjectsArrayList = new ArrayList<>();
    ResultSet result = executeQueryBySqlString("select * from subjects");
    try {
      ResultSetMetaData metaData = result.getMetaData();
      int columnCount = metaData.getColumnCount();
      int rowCount = 0;
      while (result.next()) {
        Object[] elements = new Object[columnCount];
        for (int j = 0; j < columnCount; j++) {
          elements[j] = result.getObject(j + 1);
        }
        subjectsArrayList.add(
            new Subjects(Integer.parseInt(elements[0].toString()), elements[1].toString()));
        rowCount++;
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return subjectsArrayList;
  }

  public Subjects getSubjectById(int subjectId) {

    String sql = "select * from subjects where subjectId=?";
    Object[] element = new Object[2];
    try {
      Connection conn = DBConnection.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, subjectId);
      ResultSet result = ps.executeQuery();
      ResultSetMetaData metaData = result.getMetaData();
      int columnCount = metaData.getColumnCount();

      while (result.next()) {
        element = new Object[columnCount];
        for (int j = 0; j < columnCount; j++) {
          element[j] = result.getObject(j + 1);
        }
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    Subjects subject = new Subjects(Integer.parseInt(element[0].toString()), element[1].toString());
    return subject;
  }

  public void addSubject(String name) {

    String sql = "insert into subjects (NAME) VALUES (?)";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement(sql);
      ps.setString(1, name);
      ps.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public void updateSubject(Subjects subjects) {

    String sql = "update subjects set NAME = ? where subjectId = ?";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement(sql);
      ps.setString(1, subjects.getName());
      ps.setInt(2, subjects.getSubjectId());
      ps.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public void deleteSubject(String name) {
    executeInsertQuery("DELETE FROM subjects WHERE name='" + name + "'");
    String sql = "DELETE FROM subjects WHERE name=?";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement(sql);
      ps.setString(1, name);
      ps.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  // STUDENT
  public Student getStudentById(int studentId) {
    String sql = "select * from student where studentId=?";
    Object[] element = new Object[5];
    try {
      Connection conn = DBConnection.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, studentId);
      ResultSet result = ps.executeQuery();
      ResultSetMetaData metaData = result.getMetaData();
      int columnCount = metaData.getColumnCount();

      while (result.next()) {
        element = new Object[columnCount];
        for (int j = 0; j < columnCount; j++) {
          element[j] = result.getObject(j + 1);
        }
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    Student student =
        new Student(
            Integer.parseInt(element[0].toString()),
            element[1].toString(),
            element[2].toString(),
            element[3].toString(),
            getClassById(Integer.parseInt(element[4].toString())));
    return student;
  }

  public void addStudent(
      JTextField firstName,
      JTextField secondName,
      JTextField thirdName,
      ClassOfStudents classOfStudents) {
    String sql = "insert into student (FIRSTNAME, SECONDNAME, THIRDNAME, CLASSID) VALUES (?,?,?,?)";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement(sql);
      ps.setString(1, firstName.getText());
      ps.setString(2, secondName.getText());
      ps.setString(3, thirdName.getText());
      ps.setInt(4, classOfStudents.getClassId());
      ps.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public void updateStudent(
      JTextField firstName,
      JTextField secondName,
      JTextField thirdName,
      int classId,
      int studentId) {
    String sql =
        "update student set FIRSTNAME = ?, SECONDNAME = ?, THIRDNAME=?, CLASSID = ? where studentid=?";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement(sql);
      ps.setString(1, firstName.getText());
      ps.setString(2, secondName.getText());
      ps.setString(3, thirdName.getText());
      ps.setInt(4, classId);
      ps.setInt(5, studentId);
      ps.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public void deleteStudent(Student student) {
    String sql = "DELETE FROM student WHERE studentid=?";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement(sql);
      ps.setInt(1, student.getStudentId());
      ps.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public ArrayList<Student> getAllStudentsByClassId(ClassOfStudents classOfStudents) {
    ArrayList<Student> studentArrayList = new ArrayList<>();
    ResultSet result =
        executeQueryBySqlString(
            "select * from student where classId=" + classOfStudents.getClassId());
    try {
      ResultSetMetaData metaData = result.getMetaData();
      int columnCount = metaData.getColumnCount();
      int rowCount = 0;
      while (result.next()) {
        Object[] elements = new Object[columnCount];
        for (int j = 0; j < columnCount; j++) {
          elements[j] = result.getObject(j + 1);
        }
        studentArrayList.add(
            new Student(
                Integer.parseInt(elements[0].toString()),
                elements[1].toString(),
                elements[2].toString(),
                elements[3].toString(),
                getClassById(Integer.parseInt(elements[4].toString()))));
        rowCount++;
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return studentArrayList;
  }

  // GRADE
  public ArrayList<Grade> getAllGradesByStudent(Student student) {
    ArrayList<Grade> gradeArrayList = new ArrayList<>();
    String sql = "select * from grade where studentid=?";
    try {
      Connection conn = DBConnection.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, student.getStudentId());
      ResultSet result = ps.executeQuery();
      ResultSetMetaData metaData = result.getMetaData();
      int columnCount = metaData.getColumnCount();
      int rowCount = 0;
      while (result.next()) {
        Object[] elements = new Object[columnCount];
        for (int j = 0; j < columnCount; j++) {
          elements[j] = result.getObject(j + 1);
        }
        gradeArrayList.add(
            new Grade(
                Integer.parseInt(elements[0].toString()),
                Float.parseFloat(elements[1].toString()),
                getSubjectById(Integer.parseInt(elements[2].toString())),
                getStudentById(Integer.parseInt(elements[3].toString()))));
        rowCount++;
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return gradeArrayList;
  }

  public void addGrade(float gradeValue, Subjects subjects, Student student) {
    String sql = "insert into grade (GRADE_VALUE, STUDENTID, SUBJECTID) VALUES (?,?,?)";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement(sql);
      ps.setFloat(1, gradeValue);
      ps.setInt(2, student.getStudentId());
      ps.setInt(3, subjects.getSubjectId());
      ps.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public void updateGrade(Float gradeValue, int subjectId, int studentId, int gradeId) {
    String sql = "update grade set GRADE_VALUE = ?, SUBJECTID=?, STUDENTID=? where gradeid=?";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement(sql);
      ps.setFloat(1, gradeValue);
      ps.setInt(2, subjectId);
      ps.setInt(3, studentId);
      ps.setInt(4, gradeId);
      ps.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public void deleteGrade(Grade grade) {
    String sql = "DELETE FROM grade WHERE gradeId=?";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement(sql);
      ps.setInt(1, grade.getGradeId());
      ps.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  // SUBJECT CLASS

  public ArrayList<SubjectClass> getAllSubjectClass(ClassOfStudents classOfStudents) {
    ArrayList<SubjectClass> subjectClassArrayList = new ArrayList<>();
    String sql = "select * from subject_class where classid=?";
    try {
      Connection conn = DBConnection.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, classOfStudents.getClassId());
      ResultSet result = ps.executeQuery();
      ResultSetMetaData metaData = result.getMetaData();
      int columnCount = metaData.getColumnCount();
      int rowCount = 0;
      while (result.next()) {
        Object[] elements = new Object[columnCount];
        for (int j = 0; j < columnCount; j++) {
          elements[j] = result.getObject(j + 1);
        }
        subjectClassArrayList.add(
            new SubjectClass(
                Integer.parseInt(elements[0].toString()),
                getSubjectById(Integer.parseInt(elements[1].toString())),
                getClassById(Integer.parseInt(elements[2].toString()))));
        rowCount++;
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return subjectClassArrayList;
  }

  public ArrayList<SubjectClass> getAllSubjectClass() {
    ArrayList<SubjectClass> subjectClassArrayList = new ArrayList<>();
    ResultSet result = executeQueryBySqlString("select * from subject_class");
    try {
      ResultSetMetaData metaData = result.getMetaData();
      int columnCount = metaData.getColumnCount();
      int rowCount = 0;
      while (result.next()) {
        Object[] elements = new Object[columnCount];
        for (int j = 0; j < columnCount; j++) {
          elements[j] = result.getObject(j + 1);
        }
        subjectClassArrayList.add(
            new SubjectClass(
                Integer.parseInt(elements[0].toString()),
                getSubjectById(Integer.parseInt(elements[1].toString())),
                getClassById(Integer.parseInt(elements[2].toString()))));
        rowCount++;
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return subjectClassArrayList;
  }

  public ArrayList<ClassOfStudents> getAllSubjectClassWithoutSubject(Subjects subjects) {
    ArrayList<ClassOfStudents> subjectClassArrayList = new ArrayList<>();
    ResultSet result =
        executeQueryBySqlString(
            "select a.classId from class a left join subject_class b on a.classId = b.classid and b.subjectid="
                + subjects.getSubjectId()
                + " where subjectid is null");
    try {

      ResultSetMetaData metaData = result.getMetaData();
      int columnCount = metaData.getColumnCount();
      int rowCount = 0;
      while (result.next()) {
        Object[] elements = new Object[columnCount];
        for (int j = 0; j < columnCount; j++) {
          elements[j] = result.getObject(j + 1);
        }
        subjectClassArrayList.add(getClassById(Integer.parseInt(elements[0].toString())));
        rowCount++;
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return subjectClassArrayList;
  }

  public void addSubjectClass(Subjects subjects, ClassOfStudents classOfStudents) {

    String sql = "insert into subject_class (SUBJECTID, CLASSID) VALUES (?,?)";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement(sql);
      ps.setInt(1, subjects.getSubjectId());
      ps.setInt(2, classOfStudents.getClassId());
      ps.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public void updateSubjectClass(SubjectClass subjectClass) {
    String sql = "update subject_class set subjectId=?, classid=? where subjectclassid=?";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement(sql);
      ps.setInt(1, subjectClass.getSubject().getSubjectId());
      ps.setInt(2, subjectClass.getClassId().getClassId());
      ps.setInt(3, subjectClass.getSubjectClassId());
      ps.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public void deleteSubjectClass(SubjectClass subjectClass) {
    String sql = "DELETE class subject_class WHERE subjectclassid=?";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement(sql);
      ps.setInt(1, subjectClass.getSubjectClassId());
      ps.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  // REPORT
  public ArrayList<StudentWithGrade> getReportForAStudents() {
    ArrayList<StudentWithGrade> subjectClassArrayList = new ArrayList<>();
    ResultSet result =
        executeQueryBySqlString(
            "select b.*, a.grade_value, a.subjectId from grade a inner join student b on (a.grade_value = 6.0 and a.studentid = b.studentid) where classid = 1");
    try {
      ResultSetMetaData metaData = result.getMetaData();
      int columnCount = metaData.getColumnCount();
      int rowCount = 0;
      while (result.next()) {
        Object[] elements = new Object[columnCount];
        for (int j = 0; j < columnCount; j++) {
          elements[j] = result.getObject(j + 1);
        }
        subjectClassArrayList.add(
            new StudentWithGrade(
                new Student(
                    Integer.parseInt(elements[0].toString()),
                    elements[1].toString(),
                    elements[2].toString(),
                    elements[3].toString(),
                    getClassById(Integer.parseInt(elements[4].toString()))),
                Float.parseFloat(elements[5].toString()),
                getSubjectById(Integer.parseInt(elements[6].toString())).getName()));
        rowCount++;
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    return subjectClassArrayList;
  }

  private ResultSet executeQueryBySqlString(String sql) {
    Connection conn = DBConnection.getConnection();
    PreparedStatement state = null;
    ResultSet result = null;
    try {
      state = conn.prepareStatement(sql);
      result = state.executeQuery();

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return result;
  }

  private void executeInsertQuery(String sql) {
    Connection conn = DBConnection.getConnection();
    PreparedStatement statement = null;
    try {
      statement = conn.prepareStatement(sql);
      statement.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}
