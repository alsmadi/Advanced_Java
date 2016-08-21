package solutions.ch18solutions;

// File: StateClient2.java

public class StateClient2 {
  public static void main(String[] args) {
    Computer2 comp = new Computer2();

    comp.powerOn();
    comp.standBy();
    comp.keyPress();
    comp.standBy();
    comp.powerOn();
    comp.shutdown();
  }
}