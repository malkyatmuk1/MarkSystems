package bg.pu.panels.grade;

import bg.pu.buttons.ButtonEditor;
import bg.pu.buttons.ButtonRenderer;
import bg.pu.entity.Grade;
import bg.pu.entity.Student;
import bg.pu.frames.grade.AddGradePage;
import bg.pu.frames.grade.UpdateGradePage;
import bg.pu.frames.students.AddStudentPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MarksPanel extends JPanel {
    JTable jtable;
    JLabel jLabel;
    String[] columnName = {"Subject", "Mark", "Update grade", "Delete grade"};
    DataService dataService = new DataService();
    private JButton buttonAddGrade = new JButton("Add grade");

    public MarksPanel(Student student) {
        jLabel = new JLabel(student.getFirstName() + " " + student.getSecondName() + " " + student.getThirdName() + "'s marks");
        this.add(jLabel, BorderLayout.PAGE_START);
        ArrayList<Grade> gradeArrayList = dataService.getAllGradesByStudent(student);
        Object[][] data = new Object[gradeArrayList.size()][4];
        for (int i = 0; i < gradeArrayList.size(); i++) {
            data[i][0] = gradeArrayList.get(i).getSubject().getName();
            data[i][1] = gradeArrayList.get(i).getGradeValue();
            data[i][2] = "Update grade";
            data[i][3] = "Delete grade";
        }

        // Initializing the JTabl
        this.jtable = new JTable(data, columnName);
        jtable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());

        //SET CUSTOM EDITOR TO TEAMS COLUMN
        jtable.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JTextField(), gradeArrayList, true));
        jtable.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());

        //SET CUSTOM EDITOR TO TEAMS COLUMN
        jtable.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JTextField(), gradeArrayList, true));
        //SCROLLPANE,SET SZE,SET CLOSE OPERATION
        JScrollPane pane = new JScrollPane(jtable);
        //jtable.setBounds(30,40,200,300);
        this.add(buttonAddGrade, BorderLayout.PAGE_END);
        this.add(pane, BorderLayout.CENTER);

        buttonAddGrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddGradePage addGradePage = new AddGradePage();
                addGradePage.displayAddGradePage(student);
            }
        });

    }
}
