package solutions.ch16solutions;

// File: PropertyBuilder.java

public class PropertyBuilder extends Builder {
  private PropertyFile file;

  public PropertyBuilder() {
    file = new PropertyFile();
  }

  public void buildId(int id) {
    file.append("id=" + id);
  }
  public void buildFaxNumber(String fax) {
    file.append("faxNumber=" + fax);
  }
  public void buildLocation(String location) {
    file.append("location=" + location);
  }
  public OutputFile getFile() {
    return file;
  }
}
