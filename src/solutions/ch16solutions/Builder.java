package solutions.ch16solutions;

// File: Builder.java

public abstract class Builder {

  public static Builder getInstance(String source) {
    if (source.equals("PropertyFile")) {
      return new PropertyBuilder();
    }
    return new FlatFileBuilder();
  }

  public abstract void buildId(int id);
  public abstract void buildFaxNumber(String fax);
  public abstract void buildLocation(String loc);
  public abstract OutputFile getFile();
}
