package solutions.ch02solutions;

// File: Department.java

import java.io.Serializable;

public class Department implements Serializable {
  private String code;
  private String name;
  private Employee manager;
  private String city;
  private String state;

  public Department(String cd, String nm, Employee mg, String ct,
      String st) {
    code = cd;
    name = nm;
    manager = mg;
    city = ct;
    state = st;
  }
  public boolean equals(Object o) {
    if (o instanceof Department) {
      Department dTest = (Department) o;
      return code.equals(dTest.code) &&
             name.equals(dTest.name) &&
             manager.equals(dTest.manager);
    }
    else
      return false;
  }
  public String toString() {
    return code + " " + name + " manager: " + manager;
  }
  public String getCode(){
    return code;
  }
  public String getName(){
    return name;
  }
  public Employee getManager(){
    return manager;
  }
  public void setName(String nm){
    name = nm;
  }
}
