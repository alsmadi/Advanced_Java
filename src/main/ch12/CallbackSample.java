// File: CallbackSample.java

import solutions.ch12solutions.LoginHandler;
import solutions.ch12solutions.SalariesAction;
import java.text.NumberFormat;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;

public class CallbackSample {
  public static void main(String[] args) {
    LoginContext lc = null;

    try {
      lc = new LoginContext("CallbackSample", new LoginHandler());
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
