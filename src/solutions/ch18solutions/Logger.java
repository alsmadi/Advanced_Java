package solutions.ch18solutions;

// File: Logger.java

public class Logger implements Observer {
  private Subject subject;

  public Logger(Subject subject) {
    this.subject = subject;
    subject.addObserver(this);
  }

  public void update() {
    double currentBalance = ((BankAccount)subject).getBalance();
    System.out.println("Balance updated: " + currentBalance);
  }
}