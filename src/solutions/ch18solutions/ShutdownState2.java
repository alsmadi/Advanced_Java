package solutions.ch18solutions;

// File: ShutdownState2.java

public class ShutdownState2 implements State {
  private Computer2 computer;

  public ShutdownState2(Computer2 comp) {
    computer = comp;
  }

  public void hibernate() {
    System.out.println("You can't hibernate a shutdown computer");
  }
  public void keyPress() {
    System.out.println("Keypress doesn't wake a shutdown computer");
  }
  public void powerOn() {
    System.out.println("Starting up. . .");
    computer.setState(computer.getActiveState());
  }
  public void shutdown() {
    System.out.println("You can't shutdown a shutdown computer");
  }
  public void standBy() {
    System.out.println("You can't standby a shutdown computer");
  }
}