package bg.pu.panels.classes;
import bg.pu.entity.Subjects;
import bg.pu.frames.classes.ClassMenuPage;
import bg.pu.frames.classes.UpdateClassPage;
import bg.pu.frames.students.StudentClassPage;
import bg.pu.frames.subjectclass.AddSubjectClassPage;
import bg.pu.frames.subjects.SubjectMenuPage;
import bg.pu.frames.subjects.UpdateSubjectPage;
import bg.pu.frames.teacher.FirstPage;
import bg.pu.panels.subjectclass.AddSubjectClassPanel;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubjectMenuPanel extends JPanel {
    private JButton buttonAddToClass = new JButton("Add to a class");
    private JButton buttonUpdateSubject = new JButton("Update subject");
    private JButton buttonDeleteSubject = new JButton("Delete subject");
    DataService dataService = new DataService();
    public SubjectMenuPanel(Subjects subject){
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(buttonUpdateSubject, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(buttonDeleteSubject, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        this.add(buttonAddToClass, gbc);
        buttonAddToClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(SubjectMenuPanel.this);
                frame.dispose();
                AddSubjectClassPage addSubjectClassPage = new AddSubjectClassPage();
                addSubjectClassPage.displayAddSubjectClassPage(subject);
            }
        });
        buttonUpdateSubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(SubjectMenuPanel.this);
                frame.dispose();
                UpdateSubjectPage updateSubjectPage = new UpdateSubjectPage();
                updateSubjectPage.displayUpdateSubjecPage(subject);
            }
        });
        buttonDeleteSubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO ask if is the user is sure to delete the subject
                dataService.deleteSubject(subject.getName());
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(SubjectMenuPanel.this);
                frame.dispose();
                FirstPage firstPage = new FirstPage();
                firstPage.displayFirstPage(dataService.getAllTeachers(), dataService.getAllClass());
            }
        });
    }

}

