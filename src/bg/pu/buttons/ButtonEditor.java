package bg.pu.buttons;

import bg.pu.entity.Grade;
import bg.pu.entity.Student;
import bg.pu.entity.SubjectClass;
import bg.pu.frames.grade.GradeTablePage;
import bg.pu.frames.grade.UpdateGradePage;
import bg.pu.frames.students.UpdateStudentPage;
import bg.pu.frames.subjectclass.UpdateSubjectClassPage;
import bg.pu.panels.subjectclass.UpdateSubjectClassPanel;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//BUTTON EDITOR CLASS
public class ButtonEditor extends DefaultCellEditor {
    protected JButton btn;
    private String lbl;
    private Boolean clicked;
    private int id;
    private ArrayList<Student> studentArrayList;
    private ArrayList<Grade> gradeArrayList;
    private ArrayList<SubjectClass> subjectClassArrayList;
    DataService dataService = new DataService();

    public ButtonEditor(JTextField txt, ArrayList<Student> studentArrayList) {
        super(txt);

        btn = new JButton();
        btn.setOpaque(true);
        this.studentArrayList = studentArrayList;

        //WHEN BUTTON IS CLICKED
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                fireEditingStopped();
            }
        });
    }
    public ButtonEditor(JTextField txt, ArrayList<Grade> gradeArrayList, boolean isGrade) {
        super(txt);

        btn = new JButton();
        btn.setOpaque(true);
        this.gradeArrayList = gradeArrayList;

        //WHEN BUTTON IS CLICKED
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                fireEditingStopped();
            }
        });
    }

    public ButtonEditor(JTextField txt, ArrayList<SubjectClass> subjectClassArrayList, int isGrade) {
        super(txt);

        btn = new JButton();
        btn.setOpaque(true);
        this.subjectClassArrayList = subjectClassArrayList;

        //WHEN BUTTON IS CLICKED
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                fireEditingStopped();
            }
        });
    }

    //OVERRIDE A COUPLE OF METHODS
    @Override
    public Component getTableCellEditorComponent(JTable table, Object obj,
                                                 boolean selected, int row, int col) {

        //SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
        lbl = (obj == null) ? "" : obj.toString();
        this.id = row;
        btn.setText(lbl);
        clicked = true;
        return btn;
    }

    //IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
    @Override
    public Object getCellEditorValue() {

        if (clicked) {
            //SHOW US SOME MESSAGE

            if (lbl.equals("View marks")) {
                new GradeTablePage().displayGradePage(this.studentArrayList.get(id));
            } else if (lbl.equals("Delete student")){
                dataService.deleteStudent(this.studentArrayList.get(id));
            }
            else if(lbl.equals("Update student")){
                new UpdateStudentPage().displayStudentPage(this.studentArrayList.get(id));
            }
            else if(lbl.equals("Update grade")){
                new UpdateGradePage().displayUpdateGradePage(this.gradeArrayList.get(id));
            }
            else if(lbl.equals("Delete grade")){
                dataService.deleteGrade(this.gradeArrayList.get(id));
            }
            else if(lbl.equals("Update subject class")){
                new UpdateSubjectClassPage().displayUpdateSubjectClassPage(this.subjectClassArrayList.get(id));
            }
            else if(lbl.equals("Delete subject class")){
                dataService.deleteSubjectClass(this.subjectClassArrayList.get(id));
            }

        }
        //SET IT TO FALSE NOW THAT ITS CLICKED
        clicked = false;
        return new String(lbl);
    }

    @Override
    public boolean stopCellEditing() {

        //SET CLICKED TO FALSE FIRST
        clicked = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}
