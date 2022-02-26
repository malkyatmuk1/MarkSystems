package bg.pu.panels.subjectclass;

import bg.pu.buttons.ButtonEditor;
import bg.pu.buttons.ButtonRenderer;
import bg.pu.entity.ClassOfStudents;
import bg.pu.entity.Student;
import bg.pu.entity.SubjectClass;
import bg.pu.frames.students.AddStudentPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SubjectClassTablePanel extends JPanel {
    DataService dataService = new DataService();

    JTable jtable;
    String[] columnName = {"Subject name", "Class", "Update subject class ", "Delete subject class"};
    private JButton buttonAddStudent = new JButton("Update subject class");
    public SubjectClassTablePanel() {
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        ArrayList<SubjectClass> subjectClassArrayList = dataService.getAllSubjectClass();
        Object[][] data = new Object[subjectClassArrayList.size()][4];
        for (int i = 0; i < subjectClassArrayList.size(); i++) {
            data[i][0] = subjectClassArrayList.get(i).getSubject().getName();
            data[i][1] = subjectClassArrayList.get(i).getClassId().getName();
            data[i][2] = "Update subject class";
            data[i][3] = "Delete subject class";
        }

        // Initializing the JTabl

        this.jtable = new JTable(data, columnName);

        jtable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());

        //SET CUSTOM EDITOR TO TEAMS COLUMN
        jtable.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JTextField(), subjectClassArrayList,1));
        jtable.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());

        //SET CUSTOM EDITOR TO TEAMS COLUMN
        jtable.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JTextField(), subjectClassArrayList , 1));
        //SCROLLPANE,SET SZE,SET CLOSE OPERATION
        JScrollPane pane = new JScrollPane(jtable);
        //jtable.setBounds(30,40,200,300);
        this.add(pane, BorderLayout.CENTER);

    }
}
