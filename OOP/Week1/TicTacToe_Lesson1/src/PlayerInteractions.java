import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayerInteractions {
  private Scanner scan = new Scanner(System.in);

  // Avoids the extra class & memory leak problems of Java 7 static Map
  private static final Map<Character, Integer> rowChoices = Stream.of(new Object[][] {
      { 'a', 0 },
      { 'b', 1 },
      { 'c', 2 },
  }).collect(Collectors.toUnmodifiableMap(data -> (Character) data[0], data -> (Integer) data[1]));
  // But still deprecated, if Java 9+ we could use Map.of, such as:
  // Map<Character, Integer> map = Map.of('a',0, 'b', 1 'c', 2);

  public int[] getPlayerMove() {
    String playerMove = scan.nextLine().toLowerCase();

    try {

      char row = playerMove.charAt(0);
      int col = Character.getNumericValue(playerMove.charAt(2)) - 1;

      if (col >= 0 && col < 3) {
        return new int[] {rowChoices.get(row), col};
      }

    } catch (Exception e) {
      System.out.println("\nYou have to enter: ROW COLUMN such as 'B 2'\n");
      return new int[] {-1};
    }
    return new int[] {-1};
  }

  public Boolean checkQuit() {
    System.out.print("\nDo you want to play again? (Y/N): ");
    if (scan.next().toLowerCase().startsWith("n")) {
      playerQuit();
      return true;
    }
    return false;
  }

  private void playerQuit() {
    System.out.println("\nThanks for playing!\n");
    scan.close();
  }
}
