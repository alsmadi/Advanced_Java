package solutions.ch16solutions;

// File: FlatFileBuilder.java

public class FlatFileBuilder extends Builder {
  private static String EOL = System.getProperty("line.separator");
  FlatFile file = new FlatFile();

  public void buildId(int id) {
    file.append("" + id + EOL);
  }
  public void buildFaxNumber(String fax) {
    file.append(fax + EOL);
  }
  public void buildLocation(String location) {
    file.append(location + EOL);
  }
  public OutputFile getFile() {
    return file;
  }
}
