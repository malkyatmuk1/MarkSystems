package bg.pu.panels.subjects;

import bg.pu.service.DataService;

import javax.swing.*;

public class SubjectPanel extends JPanel {
  DataService dataService = new DataService();

  public SubjectPanel(int indexOfSubject) {
    UpdateSubjectPanel updateSubjectPanel =
        new UpdateSubjectPanel(dataService.getAllSubjects().get(indexOfSubject), this);
    TableSubjectPanel tablePanel = new TableSubjectPanel(this);
    this.add(tablePanel);
    this.add(updateSubjectPanel);
    this.add(new AddSubjectPanel(this));

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  }
}
