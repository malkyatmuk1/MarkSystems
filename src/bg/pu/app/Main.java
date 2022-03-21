package bg.pu.app;

import bg.pu.frames.teacher.FirstPage;
import bg.pu.service.DataService;

public class Main {
  public static void main(String[] args) {
    DataService dataService = new DataService();
    FirstPage firstPage = new FirstPage();
    firstPage.displayFirstPage();
  }
}
