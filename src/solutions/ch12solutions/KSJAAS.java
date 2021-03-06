package solutions.ch12solutions;

// File: KSJAAS.java

import java.security.Principal;
import java.util.Set;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;

public class KSJAAS {
  public static void main(String[] args) {
    LoginContext context = null;
    Subject subject = null;

    try {
      context = new LoginContext("KSJAAS", new LoginHandler());
      context.login();
      subject = context.getSubject();
      Set<Principal> principals = subject.getPrincipals();
      for (Principal p : principals) {
        System.out.println("Principal type: " +
          p.getClass().getName() + " name: " + p.getName());
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
