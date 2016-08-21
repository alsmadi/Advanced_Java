
import solutions.ch18solutions.State;

// File: Computer.java

public class Computer {
  State activeState = new ActiveState(this);
  State hibernateState = new HibernateState(this);
  State shutdownState = new ShutdownState(this);
  State standByState = new StandByState(this);
  State currentState;

  public Computer() {
    currentState = shutdownState;
  }
  public void hibernate() {
    currentState.hibernate();
  }
  public void keyPress() {
    currentState.keyPress();
  }
  public void powerOn() {
    currentState.powerOn();
  }
  public void shutdown() {
    currentState.shutdown();
  }
  public void standBy() {
    currentState.standBy();
  }
  public void setState(State state) {
    currentState = state;
  }
  public State getActiveState() {
    return activeState;
  }
  public State getHibernateState() {
    return hibernateState;
  }
  public State getShutdownState() {
    return shutdownState;
  }
  public State getStandByState() {
    return standByState;
  }
}