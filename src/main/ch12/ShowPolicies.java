// File: ShowPolicies.java

import java.net.URL;
import java.security.CodeSource;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Policy;
import java.security.Principal;
import java.security.ProtectionDomain;
import java.security.cert.Certificate;
import java.util.Enumeration;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;

public class ShowPolicies {
  public static void main(String[] args) {
    LoginContext lc = null;

    try {
      lc = new LoginContext("Salaries");
      lc.login();
      Subject subject = lc.getSubject();
      Principal[] principals =
        subject.getPrincipals().toArray(new Principal[0]);

      URL url = new URL("file:///");
      CodeSource cs = new CodeSource(url, new Certificate[0]);
      ProtectionDomain pd = new ProtectionDomain(cs, null,
        ShowPolicies.class.getClassLoader(), principals);
      Policy policy = Policy.getPolicy();
      PermissionCollection pc = policy.getPermissions(pd);

      Enumeration<Permission> e = pc.elements();
      while (e.hasMoreElements()) {
        Permission p = e.nextElement();
        System.out.println("Permission: " + p);
      }
      lc.logout();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
