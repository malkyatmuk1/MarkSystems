package bg.pu.panels.students;

import bg.pu.buttons.ButtonEditor;
import bg.pu.buttons.ButtonRenderer;
import bg.pu.entity.ClassOfStudents;
import bg.pu.entity.Student;
import bg.pu.frames.students.AddStudentPage;
import bg.pu.frames.teacher.FirstPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentsTablePanel extends JPanel {
    DataService dataService = new DataService();

    JTable jtable;
    String[] columnName = {"Name", "View marks", "Delete student", "Update student"};
    private JButton buttonAddStudent = new JButton("Add Student");
    public StudentsTablePanel(ClassOfStudents classOfStudents) {
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        ArrayList<Student> studentArrayList = dataService.getAllStudentsByClassId(classOfStudents);
        Object[][] data = new Object[studentArrayList.size()][4];
        for (int i = 0; i < studentArrayList.size(); i++) {
            data[i][0] = studentArrayList.get(i).getFirstName() + " " + studentArrayList.get(i).getSecondName() + " " + studentArrayList.get(i).getThirdName();
            data[i][1] = "View marks";
            data[i][2] = "Delete student";
            data[i][3] = "Update student";
        }

        // Initializing the JTabl

        this.jtable = new JTable(data, columnName);
        jtable.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());

        //SET CUSTOM EDITOR TO TEAMS COLUMN
        jtable.getColumnModel().getColumn(1).setCellEditor(new ButtonEditor(new JTextField(), studentArrayList));
        jtable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());

        //SET CUSTOM EDITOR TO TEAMS COLUMN
        jtable.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JTextField(), studentArrayList));
        jtable.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());

        //SET CUSTOM EDITOR TO TEAMS COLUMN
        jtable.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JTextField(), studentArrayList));
        //SCROLLPANE,SET SZE,SET CLOSE OPERATION
        JScrollPane pane = new JScrollPane(jtable);
        //jtable.setBounds(30,40,200,300);
        this.add(pane, BorderLayout.CENTER);
        this.add(buttonAddStudent, BorderLayout.PAGE_END);

        buttonAddStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStudentPage addStudentPage = new AddStudentPage();
                addStudentPage.displayAddStudentPage(classOfStudents);

            }
        });
    }
}

