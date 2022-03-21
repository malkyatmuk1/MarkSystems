package bg.pu.panels.subjectclass;

import bg.pu.entity.ClassOfStudents;
import bg.pu.entity.Subjects;
import bg.pu.frames.subjects.SubjectMenuPage;
import bg.pu.frames.teacher.FirstPage;
import bg.pu.service.DataService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddSubjectClassPanel extends JPanel {
  private JLabel classLabel = new JLabel("Class");
  private JLabel title = new JLabel("Add subject to a class");
  private JComboBox comboBox;
  private JButton addButton = new JButton("Add subject to a class");
  private JButton returnBackButton = new JButton("Back");
  DataService dataService = new DataService();

  public AddSubjectClassPanel(Subjects subject) {
    {
      GridBagLayout layout = new GridBagLayout();
      this.setLayout(layout);
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.gridx = 0;
      gbc.gridy = 0;
      this.add(title, gbc);
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.gridx = 1;
      gbc.gridy = 1;
      gbc.weightx = 0.5;
      ArrayList<ClassOfStudents> classArrayList =
          dataService.getAllSubjectClassWithoutSubject(subject);
      String[] className = new String[classArrayList.size()];
      for (int i = 0; i < classArrayList.size(); i++) {
        className[i] = classArrayList.get(i).getName();
      }
      comboBox = new JComboBox(className);
      this.add(comboBox, gbc);
      gbc.gridx = 0;
      gbc.gridy = 1;

      this.add(classLabel, gbc);
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.gridx = 0;
      gbc.gridy = 2;
      gbc.gridwidth = 2;
      this.add(addButton, gbc);

      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.gridx = 0;
      gbc.gridy = 3;
      gbc.gridwidth = 2;
      this.add(returnBackButton, gbc);

      addButton.addActionListener(
          e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(AddSubjectClassPanel.this);
            frame.dispose();
            dataService.addSubjectClass(subject, classArrayList.get(comboBox.getSelectedIndex()));
            FirstPage firstPage = new FirstPage();
            firstPage.displayFirstPage();
          });
      returnBackButton.addActionListener(
          e -> {
            SubjectMenuPage subjectMenuPage = new SubjectMenuPage();
            subjectMenuPage.displaySubjectMenuPage(subject);
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(AddSubjectClassPanel.this);
            frame.dispose();
          });
    }
  }
}
