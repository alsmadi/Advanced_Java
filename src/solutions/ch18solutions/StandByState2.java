package solutions.ch18solutions;

// File: StandByState2.java

public class StandByState2 implements State {
  private Computer2 computer;

  public StandByState2(Computer2 comp) {
    computer = comp;
  }

  public void hibernate() {
    System.out.println("You can't hibernate a standBy computer");
  }
  public void keyPress() {
    System.out.println("Waking up. . .");
    System.out.println("Power on display and drives");
    computer.setState(computer.getActiveState());
  }
  public void powerOn() {
    // NEW CODE:
    System.out.println("Waking up. . .");
    System.out.println("Power on display and drives");
    computer.setState(computer.getActiveState());
  }
  public void shutdown() {
    System.out.println("You can't shutdown a standBy computer");
  }
  public void standBy() {
    System.out.println("You can't standby a standBy computer");
  }
}