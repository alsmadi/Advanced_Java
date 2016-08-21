// File: BadBatchProcessor.java

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;

public class BadBatchProcessor implements Runnable, Serializable {
  private ArrayList<Runnable> jobs;
  private ListIterator<Runnable> iterator;

  public BadBatchProcessor(ArrayList<Runnable> jobs) {
    this.jobs = jobs;
    iterator = jobs.listIterator();
  }

  public void run() {
    while (iterator.hasNext() && ! Thread.interrupted()) {
      Runnable job = iterator.next();
      job.run();
    }
  }

  public String toString() {
    StringBuilder result = new StringBuilder(super.toString());
    result.append(' ').append(jobs.size()).append(" jobs : ");
    if (iterator.hasNext()) {
      result.append("Next job: ").append(iterator.nextIndex());
    }
    else {
      result.append("Completed");
    }
    return result.toString();
  }

  // If there is an existing serialized BatchProcessor, then load it.
  // Otherwise, create a list of test jobs and run them through a new
  // batch processor
  public static void main(String args[]) {
    BadBatchProcessor processor = null;
    File serialFile = new File("batch_processor_bad.ser");
    if (serialFile.canRead()) {
      ObjectInputStream in = null;
      try {
        in = new ObjectInputStream(new FileInputStream(serialFile));
        processor = (BadBatchProcessor)in.readObject();
        System.err.println("Found previous batch processor : " +
            processor);
      }
      catch (IOException ioex) {
        System.err.println("Error occurred reading "
            + serialFile + ": " + ioex);
        System.exit(1);
      }
      catch (ClassNotFoundException cnfex) {
        System.err.println("Class " +  cnfex.getMessage()
            + " not found while unmarshalling " + serialFile);
        System.exit(2);
      }
      finally {
        if (in != null) {
          try {
            in.close();
          }
          catch (IOException ignore) {}
        }
      }
    }
    if (processor == null) {
      System.err.println("Starting new batch processor");
      ArrayList<Runnable> joblist = new ArrayList<Runnable>();
      for (int i = 0; i < 200; i++) {
        joblist.add(new TestJob("Test" + i));
      }
      processor = new BadBatchProcessor(joblist);
    }

    // start the batch processor, then interrupt it after a short pause
    Thread t = new Thread(processor);
    t.start();
    try {
      Thread.sleep(2000);
    }
    catch (InterruptedException ignore) {}
    t.interrupt();

    // serialize the BatchProcessor
    ObjectOutputStream out = null;
    try {
      out = new ObjectOutputStream(
          new FileOutputStream("batch_processor_bad.ser"));
      out.writeObject(processor);
    }
    catch (IOException ioe) {
      ioe.printStackTrace();
    }
    finally {
      if (out != null) {
        try {
          out.close();
        }
        catch (IOException ignore) {}
      }
    }
  }
}
