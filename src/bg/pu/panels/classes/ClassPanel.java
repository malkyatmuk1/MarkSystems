package bg.pu.panels.classes;

import bg.pu.service.DataService;

import javax.swing.*;

public class ClassPanel extends JPanel {
  DataService dataService = new DataService();
  ClassTablePanel classTablePanel = new ClassTablePanel(this);

  public ClassPanel(int indexOfClass) {

    this.add(classTablePanel);
    this.add(new UpdateClassPanel(dataService.getAllClass().get(indexOfClass), this));
    this.add(new AddClassPanel(this));

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  }
}
