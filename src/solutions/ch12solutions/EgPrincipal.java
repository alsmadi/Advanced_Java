package solutions.ch12solutions;

// File: EgPrincipal.java

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
