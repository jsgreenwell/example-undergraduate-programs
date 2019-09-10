import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** TicTacToe game written in a structured style for debugging & review practice.
 *  Used as unit review before OOP introduction.
 *  Does not follow all best practices to allow for review practice.
 */
public class Main {
  /** Use to set a game "State" (for later scaling) */
  public enum CellContent { TIE, CROSS, CIRCLE }

  /**
   * Main game logic: Gets player move and validates player input
   * @param player
   * @return int array with the row & col for board (2d char array)
   */
  public static int[] getPlayerMove(CellContent player, PlayerInteractions p) {
    int[] move = new int[] {-1};

    while (move[0] == -1) {
      if (player == CellContent.CROSS) {
        System.out.print("Enter your move Player X (A-C 1-3, like 'A 3'): ");
      } else {
        System.out.print("Enter your move Player O (A-C 1-3, like 'A 3'): ");
      }
      move = p.getPlayerMove();
    }
    return move;
  }

  /**
   * Builds board from Board class, calls for player move, updates winner and scoreboard
   * @param args
   */
  public static void main(String[] args) {
    Board board = new Board();
    PlayerInteractions pi = new PlayerInteractions();

    System.out.println("X always goes first in this game, so X starts:");

    CellContent curPlayer = CellContent.CROSS;
    Boolean movesLeft = true;
    String winner = null;

    Map<String, Integer> scoreboard = Stream.of(new Object[][] {
        { "X", 0 },
        { "O", 0 },
        { "Tie", 0 },
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

    while (true) {
      while (movesLeft) {

        if (curPlayer == CellContent.CROSS) {
          if (board.drawMove(getPlayerMove(curPlayer, pi), 'X')) {
            curPlayer = CellContent.CIRCLE;
          }
        } else {
          if (board.drawMove(getPlayerMove(curPlayer, pi), 'O')) {
            curPlayer = CellContent.CROSS;
          }
        }
        winner = board.endGame();
        movesLeft = (winner == "Continue") ? true : false;

      }

      board.clrScreen();

      scoreboard.put(winner, scoreboard.get(winner) + 1);
      System.out.printf("Current Scoreboard: X: %d, O: %d, Ties: %d %n",
          scoreboard.get("X"), scoreboard.get("O"), scoreboard.get("Tie"));
      System.out.printf("Nice Game, Winner is %s %n", winner);

      if (!pi.checkQuit()) {
        // If player does not want to quit - reset round variables
        curPlayer = CellContent.CROSS;
        movesLeft = true;
        winner = null;
        board.initBoard();
      }

      }
    }
  }
