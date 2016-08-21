// File:  CCCheckTest.java

public class CCCheckTest {
  public static void main (String args[]) {
    int valid = 0;
    String testNumber = "12344";
    CCCheck checker = new CCCheck();

    valid = checker.validCC(testNumber, testNumber.length());
    System.out.println("Number " + testNumber + " is " + valid);

    testNumber = "12341";
    valid = checker.validCC(testNumber,testNumber.length());
    System.out.println("Number " + testNumber + " is " + valid);
  }
}

