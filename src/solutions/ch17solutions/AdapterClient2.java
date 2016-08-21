package solutions.ch17solutions;

// File: AdapterClient2.java

import java.util.*;

public class AdapterClient2 {
  public static void main(String[] args) {
    Collection<String> c = new GenericArrayAdapter2<String>();
    populateCollection(c);
    System.out.println("Original Collection: " );
    printCollection(c);
    removeItemFromCollection(c);
    System.out.println("Collection After Remove: " );
    printCollection(c);
    removeItemsFromCollection(c);
    System.out.println("Collection After Remove All: " );
    printCollection(c);
  }
  private static void populateCollection(Collection<String> c) {
    for (int i = 0; i < 10; i++) {
      c.add("Element: " + i);
    }
  }
  private static void removeItemFromCollection(Collection<String> c) {
    c.remove("Element: 8");
  }
  private static void removeItemsFromCollection(Collection<String> c){
    ArrayList<String> list = new ArrayList<String>();
    for (int i = 0; i < 5; i++) {
      list.add("Element: " + i);
    }
    c.removeAll(list);
  }
  private static void printCollection(Collection<String> c) {
    Iterator it = c.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }
}