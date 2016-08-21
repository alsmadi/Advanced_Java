// File: Operand.java

public class Operand extends ArithmeticComponent {
  private int op;

  public Operand(int op) {
    this.op = op;
  }
  public int evaluate() {
    return op;
  }
}