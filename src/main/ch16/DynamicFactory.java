// File: DynamicFactory.java

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DynamicFactory {
  private static final String DEFAULT = "MyProduct";

  public Product createProduct() {
    String product = getProductName();
    Product p = null;
    try {
      Class clazz = Class.forName(product);
      p = (Product) clazz.newInstance();
    }
    catch (ClassNotFoundException e) {
      return null;
    }
    catch (InstantiationException e) {
      return null;
    }
    catch (IllegalAccessException e) {
      return null;
    }
    return p;
  }
  private String getProductName() {
    Properties p = new Properties();
    String productToCreate = DEFAULT;
    try {
      FileInputStream inputStream = new
        FileInputStream("product.properties");
      if (inputStream != null) {
        p.load(inputStream);
        productToCreate = p.getProperty("product");
      }
    }
    catch (IOException ignore) { }

    return productToCreate;
  }
  public static void main(String[] args) {
    DynamicFactory df = new DynamicFactory();
    Product p = df.createProduct();
    if (p != null) {
      p.whatAmI();
    }
    else {
      throw new RuntimeException("Couldn't create object of type "  +
        df.getProductName());
    }
  }
}
