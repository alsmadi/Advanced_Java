
import solutions.ch18solutions.State;

// File: HibernateState.java

public class HibernateState implements State {
  private Computer computer;

  public HibernateState(Computer comp) {
    computer = comp;
  }

  public void hibernate() {
    System.out.println("You can't hibernate a hibernating computer");
  }
  public void keyPress() {
    System.out.println("Keypress doesn't wake hibernating computer");
  }
  public void powerOn() {
    System.out.println("Waking up. . .");
    System.out.println("Restore desktop state from disk");
    computer.setState(computer.getActiveState());
  }
  public void shutdown() {
    System.out.println("You can't shutdown a hibernating computer");
  }
  public void standBy() {
    System.out.println("You can't standby a hibernating computer");
  }
}