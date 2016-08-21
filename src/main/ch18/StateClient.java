// File: StateClient.java

public class StateClient {
  public static void main(String[] args) {
    Computer comp = new Computer();

    comp.powerOn();
    comp.shutdown();
    comp.powerOn();
    comp.standBy();
    comp.keyPress();
    comp.hibernate();
    comp.keyPress();
    comp.powerOn();
    comp.powerOn();
    comp.shutdown();
    comp.hibernate();
  }
}