/**
 * Creates a model (or more correctly a view) of the game board.
 */

public class Board {
  private char[][] board = new char[3][3];

  public Board () {
    drawBoard();
  }

  public void drawBoard() {
    String[] boardrows = {"A", "B", "C"};

    System.out.println("    1   2   3");
    for (int i = 0; i < boardrows.length; i++) {
      System.out.printf("%s:  %c |  %c  |  %c %n", boardrows[i], board[i][0], board[i][1], board[i][2]);

      if (i != boardrows.length-1) {
        System.out.println("   -----------");
      }
    }
  }

  public void drawMove(int[] choice, char player) {
    board[choice[0]][choice[1]] = player;
    drawBoard();
  }

}
