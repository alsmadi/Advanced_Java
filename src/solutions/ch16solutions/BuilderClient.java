package solutions.ch16solutions;

// File: BuilderClient.java

public class BuilderClient {
  public static void main(String[] args) {
    Director d = new Director();

    Builder b = Builder.getInstance("FlatFile");
    d.setBuilder(b);
    OutputFile flat = d.construct();
    flat.write("manager.txt");

    b = Builder.getInstance("PropertyFile");
    d.setBuilder(b);
    OutputFile prop = d.construct();
    prop.write("manager.properties");

    System.out.println("output files created");
  }
}
