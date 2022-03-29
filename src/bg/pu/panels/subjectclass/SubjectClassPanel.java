package bg.pu.panels.subjectclass;

import bg.pu.entity.ClassOfStudents;
import bg.pu.entity.Subjects;
import bg.pu.service.DataService;

import javax.swing.*;
import java.util.ArrayList;

public class SubjectClassPanel extends JPanel {
  private JLabel firstLable = new JLabel("Manage subject to class");
  private JButton buttonAddSubject = new JButton("Subject to class");
  DataService dataService = new DataService();

  public SubjectClassPanel(int updateIndex, int addClassIndex, int addSubjectIndex) {
    UpdateSubjectClassPanel updateSubjectClassPanel =
        new UpdateSubjectClassPanel(dataService.getAllSubjectClass().get(updateIndex), this);
    SubjectClassTablePanel subjectClassTablePanel = new SubjectClassTablePanel(this);
    this.add(subjectClassTablePanel);
    this.add(updateSubjectClassPanel);
    this.add(new AddSubjectClassPanel(this, addSubjectIndex, addClassIndex));

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  }

  private int getIndexOfClass(ArrayList<ClassOfStudents> arrayList, int indexClass) {
    for (int i = 0; i < arrayList.size(); i++) {
      if (arrayList.get(i).getClassId() == indexClass) return i;
    }
    return -1;
  }

  private int getIndexOfSubject(ArrayList<Subjects> arrayList, int indexSubjects) {
    for (int i = 0; i < arrayList.size(); i++) {
      if (arrayList.get(i).getSubjectId() == indexSubjects) return i;
    }
    return -1;
  }
}
