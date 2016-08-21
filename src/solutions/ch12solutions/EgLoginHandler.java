package solutions.ch12solutions;

// File: EgLoginHandler.java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;


public class EgLoginHandler implements CallbackHandler {
  public void handle(Callback[] callbacks)
      throws IOException, UnsupportedCallbackException {

    for (Callback cb : callbacks) {

      if (cb instanceof NameCallback) {
        NameCallback ncb = (NameCallback) cb;
        System.out.print(ncb.getPrompt() + " ");
        BufferedReader in = new BufferedReader(
          new InputStreamReader(System.in));
        String name = in.readLine();
        ncb.setName(name);
      }

      else if (cb instanceof PasswordCallback) {
        PasswordCallback pcb = (PasswordCallback) cb;
        System.out.print(pcb.getPrompt() + " ");
        BufferedReader in = new BufferedReader(
          new InputStreamReader(System.in));
        String password = in.readLine();
        pcb.setPassword(password.toCharArray());
      }

      else {
        throw new UnsupportedCallbackException(cb);
      }
    }
  }
}
