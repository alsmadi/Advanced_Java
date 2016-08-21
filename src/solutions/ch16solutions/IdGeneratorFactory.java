package solutions.ch16solutions;

// File: IdGeneratorFactory.java

public class IdGeneratorFactory {

  //Factory Method
  public IdGenerator3 getIdGenerator() {
    if (Configuration.isConfigValid()) {
      return FileIdGenerator.getInstance();
    }
    else {
      return SimpleIdGenerator.getInstance();
    }
  }
}
