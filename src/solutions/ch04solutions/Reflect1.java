package solutions.ch04solutions;

// File: Reflect1.java

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Vector;

public class Reflect1 implements IReflect {
  public static void main(String[] args) {
    Reflect1 reflect = new Reflect1();
    ReflectFrame frame = new ReflectFrame(reflect);
    frame.setVisible(true);
  }
  public Vector<Constructor> getCtors(String className) {
    Vector<Constructor> v = new Vector<Constructor>();
    try {
      Class cls = Class.forName(className);
      Constructor[] ctors = cls.getDeclaredConstructors();
      for (Constructor ctor : ctors) {
        v.add(ctor);
      }
    }
    catch (ClassNotFoundException cnfe) {
      cnfe.printStackTrace();
    }
    return v;
  }
  public Object instantiate(Constructor ctor, Object[] args) {
    Object o = null;
    // fill in code here

    return o;
  }
  public Vector<Method> getMethods(Object obj) {
    Vector<Method> v = new Vector<Method>();
    // fill in code here

    return v;
  }
  public Object invoke(Method method, Object target, Object[] args) {
    Object retValue = null;
    // fill in code here

    return retValue;
  }
  public Vector<String> getClasses() {
    Vector<String> v = new Vector<String>();
    File curDir = new File(".");
    File[] classFiles = curDir.listFiles(new FileFilter() {
      public boolean accept(File f) {
        return f.getName().contains(".class");
    }});
    for (File file : classFiles) {
      String name = file.getName();
      name = name.substring(0, name.indexOf(".class"));
      v.add(name);
    }
    return v;
  }
}
