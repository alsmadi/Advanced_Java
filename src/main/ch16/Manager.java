// File: Manager.java

public class Manager {
  private int id;
  private String faxNumber;
  private String location;

  public Manager(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }
  public String getFaxNumber() {
    return faxNumber;
  }
  public void setFaxNumber(String faxNumber) {
    this.faxNumber = faxNumber;
  }
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }
  public String toString() {
    return "Manager: " + id + " " + faxNumber + " " + location;
  }
}
