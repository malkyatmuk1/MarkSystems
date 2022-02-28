package bg.pu.frames.report;

import bg.pu.panels.report.ReportTablePanel;

import javax.swing.*;
import java.awt.*;

public class ReportPage extends JFrame {
  public void displayReportPage() {
    GridLayout gridLayout = new GridLayout(5, 1);
    this.setLayout(gridLayout);
    gridLayout.layoutContainer(this);
    this.add(new ReportTablePanel());
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(screenSize.width, screenSize.height);
    this.setVisible(true);
  }
}
