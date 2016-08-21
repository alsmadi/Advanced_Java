// File: Operator.java

import java.util.ArrayList;
import java.util.Iterator;

public class Operator extends ArithmeticComponent {
  private ArrayList<ArithmeticComponent> children;
  private String operator;

  public Operator(String operator) {
    this.operator = operator;
    children = new ArrayList<ArithmeticComponent>();
  }
  public void add(ArithmeticComponent component) {
    children.add(component);
  }
  public void remove(ArithmeticComponent component) {
    children.remove(component);
  }
  public ArithmeticComponent getChild(int i) {
    return children.get(i);
  }
  public int evaluate() {
    int result = 0;
    boolean firstChild = true;
    Iterator<ArithmeticComponent> it = children.iterator();
    while (it.hasNext()) {
      ArithmeticComponent comp = it.next();

      if (firstChild == true) {
        result = comp.evaluate();
        firstChild = false;
        continue;
      }
      if (operator.equals("+"))
        result += comp.evaluate();
      else if (operator.equals("-"))
        result -= comp.evaluate();
      else if (operator.equals("*"))
        result *= comp.evaluate();
      else if (operator.equals("/"))
        result /= comp.evaluate();
    }
    return result;
  }
}