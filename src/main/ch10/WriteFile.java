// File: WriteFile.java

import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Calendar;

public class WriteFile extends Applet {
  String filename = "testfile.txt";
  Panel thePanel = new Panel();

  public void init() {
    layoutThePanel();
    setLayout(new BorderLayout());
    add(thePanel, BorderLayout.CENTER);
  }

  public void layoutThePanel() {
    thePanel.setLayout(new BorderLayout());
    final Label l = new Label("");
    thePanel.add(l, BorderLayout.NORTH);
    final TextField tf_filename = new TextField(filename);
    thePanel.add(tf_filename, BorderLayout.CENTER);

    final Button b_write = new Button("Write");
    thePanel.add(b_write, BorderLayout.EAST);
    b_write.addActionListener( new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        AppletContext ac = null;
        try {
          ac = getAppletContext();
        }
        catch (Exception e) {
        }

        try {
          filename = tf_filename.getText();
          File wfile = new File(filename);
          PrintWriter pw = new PrintWriter(new FileOutputStream(wfile));
          pw.println("Test succeeded: " + Calendar.getInstance().getTime());
          pw.close();
          String s = "File " + filename + " written.";
          if (ac != null) ac.showStatus(s);
          l.setText(s);
        }
        catch (Exception e) {
          String s = "KaBOOM! " + e.getClass().getName() + ": " +e.getMessage();
          if (ac != null) ac.showStatus(s);
          l.setText(s);
        }
      }
    });

    Button b_close = new Button("Close");
    b_close.addActionListener( new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        AppletContext ac = null;
        try {
          ac = getAppletContext();
        }
        catch (Exception e) {
        }
        try {
          System.exit(0);
        }
        catch (SecurityException e) {
          String s = "KaBOOM! " + e.getClass().getName() + ": " +e.getMessage();
          if (ac != null)
            ac.showStatus(s);
          l.setText(s);
        }
      }
    });
    Panel p = new Panel(); p.add(b_close);
    thePanel.add(p, BorderLayout.SOUTH);
  }

  public static void main(String[] arg) {
    final Frame f = new Frame("WriteFile Application");
    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        f.dispose();
        System.exit(0);
      }
    });

    WriteFile wf = new WriteFile();
    wf.layoutThePanel();
    f.add(wf.thePanel, BorderLayout.CENTER);
    f.setSize(600,140);
    f.setVisible(true);
  }
}


