package solutions.ch06solutions;

// File: ServerStatistics.java

public class ServerStatistics implements java.io.Serializable {
  private String fileName;
  private int connectionCount;
  private int port;

  public ServerStatistics(String fnam, int port, int count) {
    fileName = fnam;
    this.port = port;
    connectionCount = count;
  }

  public String getFileName() {
    return fileName;
  }
  public int getConnectionCount() {
    return connectionCount;
  }
  public int getPort() {
    return port;
  }
  public void incrementConnectionCount() {
    connectionCount += 1;
  }
  public String toString() {
    StringBuilder result = new StringBuilder("ServerStatistics:");
    result.append(" serving file ").append(fileName);
    result.append(" on port ").append(port);
    result.append(" ").append(connectionCount);
    result.append(" connections.");
    return result.toString();
  }
}
