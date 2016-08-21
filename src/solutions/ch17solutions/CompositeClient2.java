package solutions.ch17solutions;

// File: CompositeClient2.java

public class CompositeClient2 {
  public static void main(String[] args) {
    // 5 * 12 + 3 * 9
    ArithmeticComponent2 expression = new Operator2("+");
    ArithmeticComponent2 subExpression1 = new Operator2("*");
    ArithmeticComponent2 subExpression2 = new Operator2("*");

    expression.add(subExpression1);
    subExpression1.add(new Operand2(5));
    subExpression1.add(new Operand2(12));

    expression.add(subExpression2);
    subExpression2.add(new Operand2(3));
    subExpression2.add(new Operand2(9));

    expression.print();
    System.out.println("= " + expression.evaluate());
  }
}