package solutions.ch08solutions;

// File: ISBN_Impl.java

import java.rmi.MarshalledObject;
import java.rmi.RemoteException;
import java.rmi.activation.Activatable;
import java.rmi.activation.ActivationID;
import java.util.HashMap;

public class ISBN_Impl extends Activatable implements ISBN_IF {
  private HashMap<String, String> map = null;

  public ISBN_Impl(ActivationID id, MarshalledObject data)
      throws RemoteException {
    super(id, 0);
    map = new HashMap<String, String>();
    map.put("0131483986", "Java How to Program");
    map.put("1586639161 ", "Java");
    map.put("0201310058", "Effective Java Programming Language Guide");
    map.put("0321305027 ", "The Java Developer's Guide to Eclipse");
    map.put("0596009208 ", "Head First Java");
    map.put("0596007736  ", "Java in a Nutshell");
  }

  public String getTitle(String isbn) {
    String title = map.get(isbn);
    return title;
  }
}
