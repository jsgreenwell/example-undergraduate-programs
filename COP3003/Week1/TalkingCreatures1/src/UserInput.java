import java.util.Scanner;

public class UserInput {
  private Scanner scan = new Scanner(System.in);

  public Integer getLanguage() {
    System.out.println("Welcome! Please select your language:\n" +
        "1: English\n 2: Spanish\n 3: Latin\n 4: German\nEnter Choice: ");
    return scan.nextInt();
  }

  public String getGreeting() {
    System.out.println("Is it <morning> or <night>?\n" +
        "Enter 'morning' or 'night': ");
    return scan.next();
  }

  public Boolean stopProgramChoice() {
    String userExit = "";
    System.out.println("Would you like to exit? (Y/N)");
    userExit = scan.next();

    // If No then while loop should continue (true). If Yes then while should exit (false)
    if (userExit.equals("N") || userExit.equals("n")) {
      return true;
    } else {
      return false;
    }
  }
}
