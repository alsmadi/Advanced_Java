package solutions.ch18solutions;

// File: HibernateState2.java

public class HibernateState2 implements State {
  private Computer2 computer;

  public HibernateState2(Computer2 comp) {
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