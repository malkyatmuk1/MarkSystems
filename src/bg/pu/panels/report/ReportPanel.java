package bg.pu.panels.report;

import bg.pu.frames.report.ReportPage;

import javax.swing.*;
import java.awt.*;

public class ReportPanel extends JPanel {
  private JLabel firstLable = new JLabel("View report for excellent students");
  private JButton viewReportButton = new JButton("ViewReport");

  public ReportPanel() {
    GridBagLayout layout = new GridBagLayout();
    this.setLayout(layout);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 0;
    this.add(firstLable, gbc);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.ipady = 20;
    gbc.gridx = 0;
    gbc.gridy = 1;
    this.add(viewReportButton, gbc);
    viewReportButton.addActionListener(
        e -> {
          ReportPage reportPage = new ReportPage();
          reportPage.displayReportPage();
          JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ReportPanel.this);
          frame.dispose();
        });
  }
}
