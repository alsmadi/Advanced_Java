// File: ArithmeticComponent.java

public abstract class ArithmeticComponent {
  public void add(ArithmeticComponent component) {
    throw new UnsupportedOperationException();
  }
  public void remove(ArithmeticComponent component) {
    throw new UnsupportedOperationException();
  }
  public ArithmeticComponent getChild(int i) {
    throw new UnsupportedOperationException();
  }
  public int evaluate() {
    throw new UnsupportedOperationException();
  }
}