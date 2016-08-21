// File: EgPrincipal.java
package main.ch12;
//import solutions.ch12solutions.EgPrincipal;
import java.io.Serializable;
import java.security.Principal;

public class EgPrincipal implements Principal, Serializable {
  private String name;

  public EgPrincipal(String nm) {
    name = nm;
  }
  public String getName() {
    return name;
  }
  public boolean equals(Object o) {
    if (!(o instanceof EgPrincipal))
      return false;

    return ((EgPrincipal) o).name.equals(this.name);
  }
}
