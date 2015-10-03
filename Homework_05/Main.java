//Andriy Zasypkin
//2015-10-02
//Homework 05

/** Problem description:
  *   Read an input string value number and convert it to a number.
  *           proper type(double or int)
  *   Use valueOf doubleValue intValue and any other applicable methods
  *
  * Problem Assumptions:
  *   - Nothing actualy needs to be done to the numbers,
  *           appart from converting the string to a number
  *   - what are doubles(examples):
  *           Valid:
  *             0.0
  *             4.9
  *             6.1
  *             .5
  *             500.
  *             98.9
  *             -96.9
  *
  *            Invalid:
  *              09
  *              08.7 (because of leading zero)
  *              +7
  *              .
  */

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //create an input reader object
    BufferedReader input
            = new BufferedReader(new InputStreamReader(System.in));
    String strValue;
    
    System.out.print("Enter a number: ");
    do {    
      strValue = input.readLine();
    } while(strValue == null);
    
    if(strValue.matches("^-?([1-9]\d*\.\d*|0?\.\d+)$")) {
      double dValue = Double.valueOf(strValue).doubleValue();
      System.out.printf("You entered %f - a double\n", dValue);
    }
    else if(strValue.matches("\\d+")) {
      int nValue = Integer.valueOf(strValue).intValue();
      System.out.printf("You entered %d - an interger\n", nValue);
    } 
    else {
      System.out.println("you did not enter a number");
      System.exit(1);
    }
    
    input.close();
    
    System.exit(0);
  }
}
