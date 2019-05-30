import java.util.Scanner;

/*
## Overview
Example program to show implementation of:
  - String Formatting
  - Variables
  - Operators
  - Control statements and loops
  - Basic class implementation

Program will print "Hello World" or "Goodbye" in: English, Spanish, Latin, and German.
A Class will be included for each language (Class diagram included in models directory).

## Program Description
Program takes user input to determine language choice and greeting. Then checks the input
and loads the appropriate Class based on it and returns the string to be printed.

## Next steps
As this is partially to show why Interfaces are used the next step would be to add an
interface. After that, the next step is up to you: How could this be improved?
 */

public class SayHello {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    Boolean exitFlag = true;

    while (exitFlag) {
      Integer userLanguage = 0;
      String greetingChoice = "";
      String finalGreeting = "";
      String userExit = "";

      System.out.println("Welcome! Please select your language:\n" +
          "1: English\n 2: Spanish\n 3: Latin\n 4: German\nEnter Choice: ");
      userLanguage = scan.nextInt();

      switch (userLanguage) {
        case 1:
          English eng = new English();
          System.out.println("Is it <morning> or <night>?\n" +
              "Enter 'morning' or 'night': ");
          greetingChoice = scan.next();
          if (greetingChoice.equals("morning")) {
            finalGreeting = eng.sayHello();
          } else if (greetingChoice.equals("night")) {
            finalGreeting = eng.sayHello();
          } else{
            System.out.println("You must enter 'morning' or 'night'");
          }
          break;
        case 2:
          Spanish span = new Spanish();
          System.out.println("Is it <morning> or <night>?\n" +
              "Enter 'morning' or 'night': ");
          greetingChoice = scan.next();
          if (greetingChoice.equals("morning")) {
            finalGreeting = span.sayHello();
          } else if (greetingChoice.equals("night")) {
            finalGreeting = span.sayHello();
          } else{
            System.out.println("You must enter 'morning' or 'night'");
          }
          break;
        case 3:
          Latin lat = new Latin();
          System.out.println("Is it <morning> or <night>?\n" +
              "Enter 'morning' or 'night': ");
          greetingChoice = scan.next();
          // Why we like using a ternary return statement
          finalGreeting = lat.sayHelloOrGoodbye(greetingChoice);
          break;
        case 4:
          German ger = new German();
          System.out.println("Is it <morning> or <night>?\n" +
              "Enter 'morning' or 'night': ");
          greetingChoice = scan.next();
          if (greetingChoice.equals("morning")) {
            finalGreeting = ger.sayHello();
          } else if (greetingChoice.equals("night")) {
            finalGreeting = ger.sayHello();
          } else{
            System.out.println("You must enter 'morning' or 'night'");
          }
          break;
         default:
            System.out.println("Valid selection needed - select 1 through 4");
            break;
        }
      System.out.printf("In your choosen language: %s", finalGreeting);

      System.out.println("Would you like to exit? (Y/N)");
      userExit = scan.next();

      if (userExit.equals("N") || userExit.equals("n")) {
        continue;
      } else {
        exitFlag = false;
      }

    }
  }
}
