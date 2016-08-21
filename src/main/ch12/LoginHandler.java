// File: LoginHandler.java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.ConfirmationCallback;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.TextOutputCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class LoginHandler implements CallbackHandler {
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
      else if (cb instanceof TextOutputCallback) {
        TextOutputCallback tocb = (TextOutputCallback) cb;
        String prompt = "";

        switch (tocb.getMessageType()) {
          case TextOutputCallback.ERROR:
            prompt += "Error: ";
            break;
          case TextOutputCallback.INFORMATION:
            prompt += "Information: ";
            break;
          case TextOutputCallback.WARNING:
            prompt += "Warning: ";
            break;
        }
        prompt += tocb.getMessage();
        System.out.println(prompt);
      }
      else if (cb instanceof ConfirmationCallback) {
        ConfirmationCallback ccb = (ConfirmationCallback) cb;
        String prompt = ccb.getPrompt();
        if (prompt != null)
          System.out.println(ccb.getPrompt());
        BufferedReader in = new BufferedReader(
          new InputStreamReader(System.in));

        switch (ccb.getOptionType()) {
          case ConfirmationCallback.UNSPECIFIED_OPTION:
            String[] options = ccb.getOptions();
            for (int i=0; i<options.length; i++) {
              System.out.println(i + ": " + options[i]);
            }
            System.out.print(
              "Please enter the number of your choice: ");
            int opt = Integer.parseInt(in.readLine());
            ccb.setSelectedIndex(opt);
            break;

          case ConfirmationCallback.YES_NO_OPTION:
            System.out.print("Please enter either yes or no: ");
            if (in.readLine().equals("yes")) {
              ccb.setSelectedIndex(ConfirmationCallback.YES);
            }
            else {
              ccb.setSelectedIndex(ConfirmationCallback.NO);
            }
            break;

          case ConfirmationCallback.YES_NO_CANCEL_OPTION:
            System.out.print("Please enter yes, no, or cancel: ");
            String response = in.readLine();
            if (response.equals("yes")) {
              ccb.setSelectedIndex(ConfirmationCallback.YES);
            }
            else if (response.equals("no")) {
              ccb.setSelectedIndex(ConfirmationCallback.NO);
            }
            else {
              ccb.setSelectedIndex(ConfirmationCallback.CANCEL);
            }
            break;

          case ConfirmationCallback.OK_CANCEL_OPTION:
            System.out.print("Please enter either ok or cancel: ");
            if (in.readLine().equals("ok")) {
              ccb.setSelectedIndex(ConfirmationCallback.OK);
            }
            else {
              ccb.setSelectedIndex(ConfirmationCallback.CANCEL);
            }
            break;
        }
      }
      else {
        throw new UnsupportedCallbackException(cb);
      }
    }
  }
}
