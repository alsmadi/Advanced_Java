// File: AdapterClient.java

import java.util.*;

public class AdapterClient {
  public static void main(String[] args) {
    Collection<String> c1 = new ArrayList<String>();
    populateCollection(c1);
    printCollection(c1);
    Collection<String> c2 = new GenericArrayAdapter<String>();
    populateCollection(c2);
    printCollection(c2);
  }
  private static void populateCollection(Collection<String> c) {
    c.add("Class: " + c.getClass().toString());
    c.add("HashCode: " + c.hashCode());
  }
  private static void printCollection(Collection<String> c) {
    Iterator it = c.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }
}