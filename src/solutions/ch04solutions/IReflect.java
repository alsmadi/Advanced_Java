package solutions.ch04solutions;

// File: IReflect.java

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Vector;

public interface IReflect {
  public Vector<Constructor> getCtors(String className);
  public Object instantiate(Constructor ctor, Object[] args);
  public Vector<Method> getMethods(Object obj);
  public Object invoke(Method method, Object target, Object[] args);
  public Vector<String> getClasses();
}
