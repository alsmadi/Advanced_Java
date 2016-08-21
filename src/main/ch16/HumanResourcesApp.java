
import solutions.ch02solutions.Employee;

// File: HumanResourcesApp.java

public class HumanResourcesApp {
  public static void main(String[] args) {
    NewHireHelper h1 = new NewHireHelper();
    NewHireHelper h2 = new NewHireHelper();
    h1.start();
    h2.start();
  }
}

class NewHireHelper extends Thread {
  public void createNewEmployee() {
    IdGenerator gen = new IdGenerator();
    int id = gen.getNextId();
    Employee e = new Employee(id);
    // add new employee to database
  }
  public void run() {
    createNewEmployee();
  }
}
