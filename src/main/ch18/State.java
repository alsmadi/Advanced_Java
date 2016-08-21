// File: State.java

public interface State {
  public void hibernate();
  public void keyPress();
  public void powerOn();
  public void shutdown();
  public void standBy();
}