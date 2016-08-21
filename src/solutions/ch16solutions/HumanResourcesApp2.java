package solutions.ch16solutions;


import solutions.ch02solutions.Employee;

// File: HumanResourcesApp2.java

public class HumanResourcesApp2 {
  public static void main(String[] args) {
    NewHireHelper2 h1 = new NewHireHelper2();
    NewHireHelper2 h2 = new NewHireHelper2();
    h1.start();
    h2.start();
  }
}

class NewHireHelper2 extends Thread {
  public void createNewEmployee() {
    IdGenerator2 gen = IdGenerator2.getInstance();
    int id = gen.getNextId();
    Employee e = new Employee(id);
    // add new employee to database
  }
  public void run() {
    createNewEmployee();
  }
}
