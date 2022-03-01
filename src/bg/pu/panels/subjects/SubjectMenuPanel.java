package bg.pu.panels.subjects;

import bg.pu.entity.Subjects;
import bg.pu.frames.subjectclass.AddSubjectClassPage;
import bg.pu.frames.subjects.UpdateSubjectPage;
import bg.pu.frames.teacher.FirstPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;

public class SubjectMenuPanel extends JPanel {
  private JButton buttonAddToClass = new JButton("Add to a class");
  private JButton buttonUpdateSubject = new JButton("Update subject");
  private JButton buttonDeleteSubject = new JButton("Delete subject");
  private JButton returnBackButton = new JButton("Back");
  DataService dataService = new DataService();

  public SubjectMenuPanel(Subjects subject) {
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
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridwidth = 2;
    this.add(returnBackButton, gbc);
    buttonAddToClass.addActionListener(
        e -> {
          JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(SubjectMenuPanel.this);
          frame.dispose();
          AddSubjectClassPage addSubjectClassPage = new AddSubjectClassPage();
          addSubjectClassPage.displayAddSubjectClassPage(subject);
        });
    buttonUpdateSubject.addActionListener(
        e -> {
          JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(SubjectMenuPanel.this);
          frame.dispose();
          UpdateSubjectPage updateSubjectPage = new UpdateSubjectPage();
          updateSubjectPage.displayUpdateSubjecPage(subject);
        });
    buttonDeleteSubject.addActionListener(
        e -> {
          dataService.deleteSubject(subject.getName());
          JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(SubjectMenuPanel.this);
          frame.dispose();
          FirstPage firstPage = new FirstPage();
          firstPage.displayFirstPage(dataService.getAllTeachers(), dataService.getAllClass());
        });
    returnBackButton.addActionListener(
        e -> {
          FirstPage firstPage = new FirstPage();
          firstPage.displayFirstPage(dataService.getAllTeachers(), dataService.getAllClass());
          JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(SubjectMenuPanel.this);
          frame.dispose();
        });
  }
}
