
import solutions.ch18solutions.State;

// File: StandByState.java

public class StandByState implements State {
  private Computer computer;

  public StandByState(Computer comp) {
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
    System.out.println("Power on doesn't wake a standBy computer");
  }
  public void shutdown() {
    System.out.println("You can't shutdown a standBy computer");
  }
  public void standBy() {
    System.out.println("You can't standby a standBy computer");
  }
}