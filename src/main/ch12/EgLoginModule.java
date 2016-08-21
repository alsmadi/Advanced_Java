// File: EgLoginModule.java

import solutions.ch12solutions.EgPrincipal;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class EgLoginModule implements LoginModule {
  private Subject subject;
  private CallbackHandler cbHandler;
  private EgPrincipal principal;
  private String user;
  private boolean authentic;

  private static Properties users;
  static {
    try {
      FileInputStream fis = new FileInputStream("users");
      users = new Properties();
      users.load(fis);
      fis.close();
    }
    catch (Exception e) {
      e.printStackTrace();
      System.exit(-1);
    }
  }

  public void initialize(Subject s, CallbackHandler cb,
      Map<String,?> state, Map<String,?> opts) {
    subject = s;
    cbHandler = cb;
    authentic = false;
    principal = null;
    user = null;
  }
  public boolean login() throws LoginException {
    String name = null;
    String password = null;
    String login = null;
    Callback[] callbacks = new Callback[2];
    callbacks[0] = new NameCallback("Enter your name");
    callbacks[1] = new PasswordCallback("Enter your password", true);

    try {
      cbHandler.handle(callbacks);
      name = ((NameCallback) callbacks[0]).getName();
      password =
        new String(((PasswordCallback) callbacks[1]).getPassword());
      if ((login = users.getProperty(name)) != null) {
        authentic = (login.equals(password));
      }
      if (authentic) {
        user = name;
      }
      else {
        throw new LoginException("Login for " + name + " failed.");
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return true;
  }
  public boolean commit() throws LoginException {
    boolean retValue = false;
    if (authentic && user != null) {
      principal = new EgPrincipal(user);
      subject.getPrincipals().add(principal);
      retValue = true;
    }
    return retValue;
  }
  public boolean abort() throws LoginException {
    boolean retValue = false;
    if (authentic && user != null) {
      logout();
      retValue = true;
    }
    return retValue;
  }
  public boolean logout() throws LoginException {
    boolean retValue = false;
    authentic = false;
    user = null;
    if (principal != null) {
      subject.getPrincipals().remove(principal);
      principal = null;
      retValue = true;
    }
    return retValue;
  }
}
