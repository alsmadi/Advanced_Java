package solutions.ch17solutions;

// File: Operator2.java

import java.util.ArrayList;
import java.util.Iterator;

public class Operator2 extends ArithmeticComponent2 {
  private ArrayList<ArithmeticComponent2> children;
  private String operator;

  public Operator2(String operator) {
    this.operator = operator;
    children = new ArrayList<ArithmeticComponent2>();
  }
  public void add(ArithmeticComponent2 component) {
    children.add(component);
  }
  public void remove(ArithmeticComponent2 component) {
    children.remove(component);
  }
  public ArithmeticComponent2 getChild(int i) {
    return children.get(i);
  }
  public int evaluate() {
    int result = 0;
    boolean firstChild = true;
    Iterator<ArithmeticComponent2> it = children.iterator();
    while (it.hasNext()) {
      ArithmeticComponent2 comp = it.next();

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
  public void print() {
    Iterator<ArithmeticComponent2> it = children.iterator();
    while (it.hasNext()) {
      ArithmeticComponent2 comp = it.next();
      comp.print();
      if (it.hasNext())
        System.out.print(" " + operator + " ");
    }
  }
}