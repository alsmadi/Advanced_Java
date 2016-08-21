package solutions.ch02solutions;

// File: Employee.java

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee implements Serializable {
  private int id;
  private String firstName;
  private String lastName;
  private String title;
  private String departmentCode;
  private int supervisorId;
  private Date hireDate;
  private float salary;

  public Employee(int i, String first, String last, String ti,
      String deptCode, int supId, Date hire, float sal) {
    id = i;
    firstName = first;
    lastName = last;
    title = ti;
    departmentCode = deptCode;
    supervisorId = supId;
    hireDate = hire;
    salary = sal;
  }

  public boolean equals(Object o) {
    if (o instanceof Employee) {
      Employee eTest = (Employee) o;
      return id == eTest.id &&
             lastName.equals(eTest.lastName) &&
             firstName.equals(eTest.firstName) &&
             title.equals(eTest.title) &&
             hireDate.equals(eTest.hireDate);
    }
    else
      return false;
  }
  public String toString() {
    SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy");
    StringBuilder result = new StringBuilder();
    result.append(title);
    result.append(" ").append(firstName);
    result.append(" ").append(lastName);
    result.append(" hired ").append(df.format(hireDate));
    return result.toString();
  }
  public String getName() {
    return firstName + " " + lastName;
  }
  public String getTitle() {
    return title;
  }
  public Date getHireDate() {
    return hireDate;
  }
  public int getId() {
    return id;
  }
  public int getSupervisorId() {
    return supervisorId;
  }
}
