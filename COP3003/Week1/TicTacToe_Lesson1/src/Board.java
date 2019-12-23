/**
 * Creates a model (or more correctly a view) of the game board.
 * Currently this also has some of the game logic in it (which I would not normally).
 * Meant for code review - corrected version available in 2nd week.
 */
public class Board {
  /** board is a 3x3 character array with 9 total spaces */
  private char[][] board = new char[3][3];
  private static int FULL = 0;

  public Board () { drawBoard(); }

  /** Initalize board for new round */
  public void initBoard() {
    board = new char[3][3];
    FULL = 0;
    drawBoard();
  }

  /** Draw the main 3x3 board with any moves made */
  public void drawBoard() {
    String[] boardrows = {"A", "B", "C"};

    System.out.println("    1   2   3");
    for (int i = 0; i < boardrows.length; i++) {
      System.out.printf("%s:  %c |  %c  |  %c %n", boardrows[i],
          board[i][0], board[i][1], board[i][2]);

      if (i != boardrows.length-1) {
        System.out.println("   -----------");
      }
    }
  }

  /**
   * Checks to see if index (choice) is 0, returns false if full.
   * Or Adds player (X or O) to character array (board) at index (choice).
   * @param choice space chosen
   * @param player player X or O
   * @return true (valid move) or false (invalid move)
   */
  public Boolean drawMove(int[] choice, char player) {
    // 0 is the default assignment for char array ('\u0000')
    if (board[choice[0]][choice[1]] == 0) {
      board[choice[0]][choice[1]] = player;
      FULL++;
      clrScreen();
      drawBoard();
      return true;
    }
    System.out.println("Invalid Move, Space already used");
    return false;
  }

  /**
   * Checks to see if there is a winning 3-in-a-row for X or O
   * If not, checks to see if board is full (all 9 moves used)
   * If still not, returns "continue" to continue the round
   * @return winning player, tie, or continue
   */
  public String endGame() {
    if (checkWin('X')) {
      return "X";
    }

    if (checkWin('O')) {
      return "O";
    }

    if (FULL == 9) {
      return "Tie";
    }
    return "Continue";
  }

  /**
   * Checks board (char array) for 3 in-a-row squares (a win)
   * @param curPlayer (X or O)
   * @return true if winning move found for player
   */
  private Boolean checkWin(char curPlayer) {

    // check horizontal & vertical win
    for (int i = 0; i < 3; i++) {
      if (board[i][0] == curPlayer &&
          board[i][1] == curPlayer &&
          board[i][2] == curPlayer) {
        return true;
      }

      if (board[0][i] == curPlayer &&
          board[1][i] == curPlayer &&
          board[2][i] == curPlayer) {
        return true;
      }
    }

    // check diagonal win
    if ((board[0][0] == curPlayer &&
        board[1][1] == curPlayer &&
        board[2][2] == curPlayer) ||
        board[0][2] == curPlayer &&
            board[1][1] == curPlayer &&
            board[2][0] == curPlayer)
      return true;

    // No matches
    return false;
  }

  /**
   * This is typically massively complex and already saved in a library.
   * I.e. it will have to deal with a Robot for IDEs & standard OS problems
   * However, to avoid overloading everyone: using the "simple fix" (prints 25 newlines)
   */
  public static void clrScreen() {
    for (int i = 0; i < 25; ++i) System.out.println();
  }


}
