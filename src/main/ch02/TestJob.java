// File: TestJob.java

import java.io.Serializable;

// A simple class for testing BatchProcessor
public class TestJob implements Runnable, Serializable {
  private String name;

  public TestJob(String name) {
    this.name = name;
  }

  public void run() {
    System.out.println(name + " Starting.");
    // simulate some work
    try {
      Thread.sleep(25);
    }
    catch (InterruptedException ex) {
      System.err.println(ex);
      // propogate the interruption to the batch processor
      Thread.currentThread().interrupt();
    }
    System.out.println(name + " Completed.");
  }
}

