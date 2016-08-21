package solutions.ch18solutions;

// File: Computer.java

public class Computer2 {
  State activeState = new ActiveState2(this);
  State hibernateState = new HibernateState2(this);
  State shutdownState = new ShutdownState2(this);
  State standByState = new StandByState2(this);
  State currentState;

  public Computer2() {
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