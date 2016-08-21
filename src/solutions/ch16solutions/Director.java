package solutions.ch16solutions;

// File: Director.java

public class Director {
  private Builder builder;
  private Manager manager;

  public Director() {
    manager = new Manager(42);
    manager.setFaxNumber("303 867-5309");
    manager.setLocation("Gunnison");
  }

  public void setBuilder(Builder builder) {
    this.builder = builder;
  }
  public OutputFile construct() {
    builder.buildId(manager.getId());
    builder.buildFaxNumber(manager.getFaxNumber());
    builder.buildLocation(manager.getLocation());
    return builder.getFile();
  }
}
