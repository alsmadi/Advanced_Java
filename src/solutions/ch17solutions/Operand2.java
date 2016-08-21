package solutions.ch17solutions;

// File: Operand.java

public class Operand2 extends ArithmeticComponent2 {
  private int op;

  public Operand2(int op) {
    this.op = op;
  }
  public void print() {
    System.out.print(op);
  }
  public int evaluate() {
    return op;
  }
}