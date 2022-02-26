package bg.pu.service;

import bg.pu.database.DBConnection;
import bg.pu.entity.*;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;


public class DataService {

    //TEACHER
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
                teacherArrayList.add(new Teacher(Integer.parseInt(elements[0].toString()), elements[1].toString(), elements[2].toString(), elements[3].toString()));
                rowCount++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return teacherArrayList;
    }

    public Teacher getTeacherById(int teacherId) {
        ResultSet result = executeQueryBySqlString("select * from teacher where teacherId='" + teacherId + "'");
        Object[] element = new Object[2];
        try {
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

        Teacher teacher = new Teacher(Integer.parseInt(element[0].toString()), element[1].toString(), element[2].toString(), element[3].toString());
        return teacher;
    }

    public void addTeacher(JTextField firstName, JTextField secondName, JTextField thirdName) {
        executeInsertQuery("insert into teacher (FIRSTNAME, SECONDNAME, THIRDNAME) VALUES ('" + firstName.getText() + "', '" + secondName.getText() + "', '" + thirdName.getText() + "');");
    }

    public void updateTeacher(JTextField firstName, JTextField secondName, JTextField thirdName, int teacherId) {
        executeQueryBySqlString("update teacher set FIRSTNAME='" + firstName.getText() + "', SECONDNAME='" + secondName.getText() + "', THIRDNAME='" + thirdName.getText() + "' where teacherid=" + teacherId);
    }

    public void deleteTeacher(Teacher teacher) {
        executeInsertQuery("DELETE FROM teacher WHERE teacherId=" + teacher.getTeacherId());
    }

    //CLASS
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
                classOfStudentsArrayList.add(new ClassOfStudents(Integer.parseInt(elements[0].toString()), getTeacherById(Integer.parseInt(elements[1].toString())), elements[2].toString()));
                rowCount++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return classOfStudentsArrayList;
    }

    public void addClass(String name, int teacherId) {
        executeInsertQuery("insert into class (NAME, TEACHERID) VALUES ('" + name + "', " + teacherId + ")");
    }

    public void updateClass(ClassOfStudents classOfStudents, String name, Teacher teacher) {
        executeInsertQuery("update class set NAME='" + name + "', TEACHERID=" + teacher.getTeacherId() + " where CLASSID=" + classOfStudents.getClassId());
    }

    public void deleteClass(ClassOfStudents classOfStudents) {
        executeInsertQuery("DELETE FROM class WHERE classId=" + classOfStudents.getClassId());
    }

    public ClassOfStudents getClassById(int classId) {
        ResultSet result = executeQueryBySqlString("select * from class where classId='" + classId + "'");
        Object[] element = new Object[3];
        try {
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

        ClassOfStudents classOfStudents = new ClassOfStudents(Integer.parseInt(element[0].toString()), getTeacherById(Integer.parseInt(element[1].toString())), element[2].toString());
        return classOfStudents;
    }

    //SUBJECT
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
                subjectsArrayList.add(new Subjects(Integer.parseInt(elements[0].toString()), elements[1].toString()));
                rowCount++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return subjectsArrayList;
    }

    public Subjects getSubjectById(int subjectId) {
        ResultSet result = executeQueryBySqlString("select * from subjects where subjectId='" + subjectId + "'");
        Object[] element = new Object[2];
        try {
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
        executeInsertQuery("insert into subjects (NAME) VALUES ('" + name + "');");
    }

    public void updateSubject(Subjects subjects) {
        executeInsertQuery("update subjects set NAME='" + subjects.getName() + "'where subjectId="+subjects.getSubjectId());
    }

    public void deleteSubject(String name) {
        executeInsertQuery("DELETE FROM subjects WHERE name='" + name+"'");
    }

    //STUDENT
    public Student getStudentById(int studentId) {
        ResultSet result = executeQueryBySqlString("select * from student where studentId='" + studentId + "'");
        Object[] element = new Object[5];
        try {
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

        Student student = new Student(Integer.parseInt(element[0].toString()), element[1].toString(), element[2].toString(), element[3].toString(), getClassById(Integer.parseInt(element[4].toString())));
        return student;
    }

    public void addStudent(JTextField firstName, JTextField secondName, JTextField thirdName, ClassOfStudents classOfStudents) {
        executeInsertQuery("insert into student (FIRSTNAME, SECONDNAME, THIRDNAME, CLASSID) VALUES ('" + firstName.getText() + "', '" + secondName.getText() + "', '" + thirdName.getText() + "', " + classOfStudents.getClassId() + ");");
    }

    public void updateStudent(JTextField firstName, JTextField secondName, JTextField thirdName, int classId, int studentId) {
        executeInsertQuery("update student set FIRSTNAME='" + firstName.getText() + "', SECONDNAME='" + secondName.getText() + "', THIRDNAME='" + thirdName.getText() + "', ClassId=" + classId + " where studentId=" + studentId);
    }

    public void deleteStudent(Student student) {
        executeInsertQuery("DELETE FROM student WHERE studentId=" + student.getStudentId());
    }

    public ArrayList<Student> getAllStudentsByClassId(ClassOfStudents classOfStudents) {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        ResultSet result = executeQueryBySqlString("select * from student where classId=" + classOfStudents.getClassId());
        try {
            ResultSetMetaData metaData = result.getMetaData();
            int columnCount = metaData.getColumnCount();
            int rowCount = 0;
            while (result.next()) {
                Object[] elements = new Object[columnCount];
                for (int j = 0; j < columnCount; j++) {
                    elements[j] = result.getObject(j + 1);
                }
                studentArrayList.add(new Student(Integer.parseInt(elements[0].toString()), elements[1].toString(), elements[2].toString(), elements[3].toString(), getClassById(Integer.parseInt(elements[4].toString()))));
                rowCount++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentArrayList;
    }

    //GRADE
    public ArrayList<Grade> getAllGradesByStudent(Student student) {
        ArrayList<Grade> gradeArrayList = new ArrayList<>();
        ResultSet result = executeQueryBySqlString("select * from grade where studentid=" + student.getStudentId());
        try {
            ResultSetMetaData metaData = result.getMetaData();
            int columnCount = metaData.getColumnCount();
            int rowCount = 0;
            while (result.next()) {
                Object[] elements = new Object[columnCount];
                for (int j = 0; j < columnCount; j++) {
                    elements[j] = result.getObject(j + 1);
                }
                gradeArrayList.add(new Grade(Integer.parseInt(elements[0].toString()), Float.parseFloat(elements[1].toString()), getSubjectById(Integer.parseInt(elements[2].toString())), getStudentById(Integer.parseInt(elements[3].toString()))));
                rowCount++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return gradeArrayList;
    }

    public void addGrade(float gradeValue, Subjects subjects, Student student) {
        executeInsertQuery("insert into grade (GRADE_VALUE, STUDENTID, SUBJECTID) VALUES (" + gradeValue + ", " + student.getStudentId() + ", " + subjects.getSubjectId() + ");");
    }

    public void updateGrade(Float gradeValue, int subjectId, int studentId, int gradeId) {
        executeInsertQuery("update grade set GRADE_VALUE=" + gradeValue + ", SUBJECTID=" + subjectId + ", STUDENTID=" + studentId + " where gradeid=" + gradeId);
    }

    public void deleteGrade(Grade grade) {
        executeInsertQuery("DELETE FROM grade WHERE gradeId=" + grade.getGradeId());
    }

    //SUBJECT CLASS

    public ArrayList<SubjectClass> getAllSubjectClass(ClassOfStudents classOfStudents){
        ArrayList<SubjectClass> subjectClassArrayList = new ArrayList<>();
        ResultSet result = executeQueryBySqlString("select * from subject_class where classid="+classOfStudents.getClassId());
        try {
            ResultSetMetaData metaData = result.getMetaData();
            int columnCount = metaData.getColumnCount();
            int rowCount = 0;
            while (result.next()) {
                Object[] elements = new Object[columnCount];
                for (int j = 0; j < columnCount; j++) {
                    elements[j] = result.getObject(j + 1);
                }
                subjectClassArrayList.add(new SubjectClass(Integer.parseInt(elements[0].toString()), getSubjectById(Integer.parseInt(elements[1].toString())), getClassById(Integer.parseInt(elements[2].toString()))));
                rowCount++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return subjectClassArrayList;
    }
    public ArrayList<SubjectClass> getAllSubjectClass(){
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
                subjectClassArrayList.add(new SubjectClass(Integer.parseInt(elements[0].toString()), getSubjectById(Integer.parseInt(elements[1].toString())), getClassById(Integer.parseInt(elements[2].toString()))));
                rowCount++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return subjectClassArrayList;
    }
    public ArrayList<ClassOfStudents> getAllSubjectClassWithoutSubject(Subjects subjects){
        ArrayList<ClassOfStudents> subjectClassArrayList = new ArrayList<>();
        ResultSet result = executeQueryBySqlString("select a.classId from class a left join subject_class b on a.classId = b.classid and b.subjectid="+subjects.getSubjectId() + " where subjectid is null");
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
        executeInsertQuery("insert into subject_class (SUBJECTID, CLASSID) VALUES (" + subjects.getSubjectId() + ", " + classOfStudents.getClassId() + ");");
    }

    public void updateSubjectClass(SubjectClass subjectClass) {
        executeInsertQuery("update subject_class set subjectId=" + subjectClass.getSubject().getSubjectId() + ", ClassID=" + subjectClass.getClassId().getClassId()+ " where subjectclassid=" + subjectClass.getSubjectClassId());
    }

    public void deleteSubjectClass(SubjectClass subjectClass) {
        executeInsertQuery("DELETE class subject_class WHERE subjectclassid=" + subjectClass.getSubjectClassId());
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
        Statement statement = null;
        try {
            statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
