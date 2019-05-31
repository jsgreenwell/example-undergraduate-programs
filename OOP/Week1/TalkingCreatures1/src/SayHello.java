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
    UserInput ui = new UserInput();
    Boolean exitFlag = true;

    while (exitFlag) {
      String greetingChoice = "";
      String finalGreeting = "";

      switch (ui.getLanguage()) {
        case 1:
          English eng = new English();
          greetingChoice = ui.getGreeting();
          if (greetingChoice.equals("morning")) {
            finalGreeting = eng.sayHello();
          } else if (greetingChoice.equals("night")) {
            finalGreeting = eng.sayGoodbye();
          } else{
            System.out.println("You must enter 'morning' or 'night'");
          }
          break;
        case 2:
          Spanish span = new Spanish();
          greetingChoice = ui.getGreeting();
          if (greetingChoice.equals("morning")) {
            finalGreeting = span.sayHello();
          } else if (greetingChoice.equals("night")) {
            finalGreeting = span.sayGoodbye();
          } else{
            System.out.println("You must enter 'morning' or 'night'");
          }
          break;
        case 3:
          Latin lat = new Latin();
          greetingChoice = ui.getGreeting();
          // Why we like using a ternary return statement
          finalGreeting = lat.sayHelloOrGoodbye(greetingChoice);
          break;
        case 4:
          German ger = new German();
          greetingChoice = ui.getGreeting();
          if (greetingChoice.equals("morning")) {
            finalGreeting = ger.sayHello();
          } else if (greetingChoice.equals("night")) {
            finalGreeting = ger.sayGoodbye();
          } else{
            System.out.println("You must enter 'morning' or 'night'");
          }
          break;
         default:
            System.out.println("Valid selection needed - select 1 through 4");
            break;
        }
      System.out.printf("In your choosen language: %s\n", finalGreeting);

      exitFlag = ui.stopProgramChoice();
    }
  }
}
