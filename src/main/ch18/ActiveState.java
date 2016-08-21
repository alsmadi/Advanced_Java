
import solutions.ch18solutions.State;

// File: ActiveState.java

public class ActiveState implements State {
  private Computer computer;

  public ActiveState(Computer comp) {
    computer = comp;
  }

  public void hibernate() {
    System.out.println("Hibernating . . .");
    System.out.println("Saving current desktop state to disk");
    System.out.println("Press the power on button to wake up");
    computer.setState(computer.getHibernateState());
  }
  public void keyPress() {
    System.out.println("Key press doesn't wake an active computer");
  }
  public void powerOn() {
    System.out.println("Power on doesn't wake an active computer");
  }
  public void shutdown() {
    System.out.println("Shutting down . . .");
    System.out.println("Clearing all active state");
    System.out.println("Press the power on button to start up");
    computer.setState(computer.getShutdownState());
  }
  public void standBy() {
    System.out.println("Standing by . . .");
    System.out.println("Power off display and drives");
    System.out.println("Press any key to wake up");
    computer.setState(computer.getStandByState());
  }
}