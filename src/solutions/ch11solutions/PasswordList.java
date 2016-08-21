package solutions.ch11solutions;

// File: PasswordList.java

import java.io.*;
import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import javax.crypto.Cipher;
import javax.crypto.SealedObject;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

class UsernamePassword implements Serializable {
  private String username;
  private String password;
  private String website;

  public UsernamePassword(String w, String u, String p) {
    username = u;
    password = p;
    website = w;
  }
  public String toString() {
    return "website: "+ website + " username: " + username +
      " password: " + password;
  }
}

public class PasswordList {
  private BufferedReader buf;
  private ArrayList<UsernamePassword> passwords = null;
  PBEParameterSpec paramSpec = null;
  Cipher cipher = null;
  Key theKey = null;

  public PasswordList() {
    try {
      buf = new BufferedReader(new InputStreamReader(System.in));
      String password = promptForPassword();
      createCipher(password);
      passwords = getPasswordList();

      int opt;
      while ((opt = displayMenu() ) != 3) {
        switch(opt) {
          case 1:  addPassword();
                   break;
          case 2:  showPasswords();
                   break;
          default: System.out.println("Invalid Option");
        }
      }

      savePasswords();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  private String promptForPassword() throws IOException {
    System.out.print("Enter decrypt password: ");
    String password = buf.readLine();
    return password;
  }
  private void createCipher(String password) throws Exception {
    byte[] salt = {(byte)0xca, (byte)0xfe, (byte)0xba, (byte)0xbe,
                   (byte)0x32, (byte)0x9a, (byte)0xfa, (byte)0x71 };

    paramSpec = new PBEParameterSpec(salt, 10);

    PBEKeySpec keySpec =
      new PBEKeySpec(password.toCharArray());
    SecretKeyFactory skf =
    SecretKeyFactory.getInstance("PBEWithMD5AndDES");

    theKey = skf.generateSecret(keySpec);
    cipher = Cipher.getInstance("PBEWithMD5AndDES");
    cipher.init(Cipher.DECRYPT_MODE, theKey, paramSpec);
  }

  @SuppressWarnings("unchecked") // Not supported in 1.5.0
  private ArrayList<UsernamePassword> getPasswordList() {
    ArrayList<UsernamePassword> pw =
      new ArrayList<UsernamePassword>();
    try {
      File file = new File ("passwords.dat");     
      if (file.exists())
      {
        ObjectInputStream ois = new ObjectInputStream(
          new FileInputStream(file));
        SealedObject so = (SealedObject) ois.readObject();
        pw = (ArrayList<UsernamePassword>) so.getObject(cipher);
      ois.close();
      }
    }
    catch (Exception e) {
      System.err.println(e);
    }
    return pw;
  }
  private int displayMenu() {
    int choice = 0;
    String input;
    try {
      System.out.println("\n  Menu");
      System.out.println("1 - Add Password");
      System.out.println("2 - Show Passwords");
      System.out.println("3 - Quit");
      System.out.print("\nEnter Option: ");
      input = buf.readLine();
      choice = Integer.parseInt(input);
    }
    catch (IOException e) {
      System.err.println(e);
    }
    catch (NumberFormatException e) {
      System.err.println(e);
    }
    return choice;
  }
  private void addPassword() {
    try {
      UsernamePassword up;
      String ws,u,p;
      System.out.print("Website: ");
      ws = buf.readLine();
      System.out.print("Username: ");
      u = buf.readLine();
      System.out.print("Password: ");
      p = buf.readLine();
      up = new UsernamePassword(ws, u, p);
      passwords.add(up);
    }
    catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  private void showPasswords() {
    Iterator<UsernamePassword> iter = passwords.iterator();
    while (iter.hasNext())
      System.out.println(iter.next());
  }
  private void savePasswords() throws Exception {
    ObjectOutputStream ois = new ObjectOutputStream(
    new FileOutputStream("passwords.dat"));
    cipher.init(Cipher.ENCRYPT_MODE, theKey, paramSpec);
    SealedObject so = new SealedObject(passwords, cipher);
    ois.writeObject(so);
    ois.close();
  }
  public static void main(String[] args) {
    new PasswordList();
  }
}