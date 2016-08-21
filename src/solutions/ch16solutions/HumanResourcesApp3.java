package solutions.ch16solutions;


import solutions.ch02solutions.Employee;

// File: HumanResourcesApp3.java

public class HumanResourcesApp3 {
  public static void main(String[] args) {
    NewHireHelper3 h1 = new NewHireHelper3();
    NewHireHelper3 h2 = new NewHireHelper3();
    h1.start();
    h2.start();
  }
}

class NewHireHelper3 extends Thread {
  public void createNewEmployee() {
    IdGeneratorFactory factory = new IdGeneratorFactory();
    IdGenerator3 gen = factory.getIdGenerator();
    int id = gen.getNextId();
    Employee e = new Employee(id);
    // add new employee to database
  }
  public void run() {
    createNewEmployee();
  }
}
