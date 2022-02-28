package bg.pu.app;

import bg.pu.entity.ClassOfStudents;
import bg.pu.entity.SubjectClass;
import bg.pu.entity.Subjects;
import bg.pu.frames.teacher.FirstPage;
import bg.pu.service.DataService;

import java.net.Inet4Address;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DataService dataService = new DataService();
//        bg.pu.entity.Grade grade = dataService.getGradeByName("2A");
//        System.out.println(grade.toString());
//        for (bg.pu.entity.Teacher teacher: dataService.getAllTeachers()) {
//            System.out.println(teacher.toString());
//
//            bg.pu.entity.ClassStudents classStudents = dataService.getClassByTeacher(teacher);
//            System.out.println(classStudents);
//
//            ArrayList<bg.pu.entity.Student> studentArrayList = dataService.getAllStudentByClassId(classStudents);
//            for (bg.pu.entity.Student student: studentArrayList) {
//                System.out.println(student);
//            }
//
//            ArrayList<bg.pu.entity.Marks> marksArrayList = dataService.getAllTypeOfMarks();
//            for (bg.pu.entity.Marks mark:marksArrayList) {
//                System.out.println(mark);
//            }
//
//            ArrayList<bg.pu.entity.Subjects> subjectsArrayList = dataService.getAllSubjectsByGrade(grade);
//            for (bg.pu.entity.Subjects subjects:subjectsArrayList) {
//                System.out.println(subjects);
//            }
//
//            ArrayList<bg.pu.entity.StudentGrade> studentGradeArrayList = dataService.getAllStudentGradeByStudentId(studentArrayList.get(0));
//            for (bg.pu.entity.StudentGrade studentGrade:studentGradeArrayList) {
//                System.out.println(studentGrade);
//            }

//
        FirstPage firstPage = new FirstPage();
        firstPage.displayFirstPage(dataService.getAllTeachers(), dataService.getAllClass());
//        Subjects subjects = dataService.getSubjectById(1);
//        System.out.println(subjects.getName());
//        dataService.getAllSubjectClass();
//
//        for (SubjectClass studentGrade:dataService.getAllSubjectClass()) {
//            System.out.println(studentGrade);
//        }
        ArrayList<String> classOfStudentsArrayList = dataService.getReportForAStudentsForMath();
            for (String studentGrade:classOfStudentsArrayList) {
                System.out.println(studentGrade);
            }
            System.out.println(dataService.getStudentById(4).toString());
        System.out.println(dataService.getStudentById(1).toString());
        System.out.println(dataService.getAllGradesByStudent(dataService.getStudentById(1)));
//    }
    }
}

