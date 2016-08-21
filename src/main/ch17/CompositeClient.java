// File: CompositeClient.java

public class CompositeClient {
  public static void main(String[] args) {
    // 5 * 12 + 3 * 9
    ArithmeticComponent expression = new Operator("+");
    ArithmeticComponent subExpression1 = new Operator("*");
    ArithmeticComponent subExpression2 = new Operator("*");

    expression.add(subExpression1);
    subExpression1.add(new Operand(5));
    subExpression1.add(new Operand(12));

    expression.add(subExpression2);
    subExpression2.add(new Operand(3));
    subExpression2.add(new Operand(9));

    System.out.println("Result: " + expression.evaluate());
  }
}