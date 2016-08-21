// File: ShowSalaries.java

import solutions.ch12solutions.SalariesAction;
import java.text.NumberFormat;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;

public class ShowSalaries {
  public static void main(String[] args) {
    LoginContext lc = null;

    try {
      lc = new LoginContext("Salaries");
      lc.login();
      Subject subject = lc.getSubject();
      Object o = Subject.doAs(subject, new SalariesAction());

      if (o instanceof Double) {
        double d = ((Double) o).doubleValue();
        System.out.println("Total salary: " +
          NumberFormat.getCurrencyInstance().format(d));
      }
      lc.logout();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
