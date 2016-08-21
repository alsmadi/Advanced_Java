
import solutions.ch16solutions.Manager;

// File: BuilderWannabe.java

public class BuilderWannabe {
  private static String EOL = System.getProperty("line.separator");

  private ManagerFile createFlatFileRepresentation(Manager manager) {
    ManagerFile mf = new ManagerFlatFile();
    mf.append("" + manager.getId() + EOL);
    mf.append(manager.getFaxNumber() + EOL);
    mf.append(manager.getLocation() + EOL);
    return mf;
  }
  private ManagerFile createPropertyRepresentation(Manager manager) {
    ManagerFile mf = new ManagerPropertyFile();
    mf.append("id=" + manager.getId());
    mf.append("faxNumber=" + manager.getFaxNumber());
    mf.append("location=" + manager.getLocation());
    return mf;
  }

  public static void main(String[] args) {
    Manager manager = new Manager(42);
    manager.setFaxNumber("303 867-5309");
    manager.setLocation("Gunnison");

    BuilderWannabe bw = new BuilderWannabe();
    ManagerFile flat = bw.createFlatFileRepresentation(manager);
    ManagerFile prop = bw.createPropertyRepresentation(manager);

    flat.write("manager.txt");
    prop.write("manager.properties");
    System.out.println("output files created");
  }
}
