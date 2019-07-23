/**
/**
 * Model for each cell (square) on the game board.
 * Add this after just building the board.
 * Not sure if want to seperate out Cells or Game Logic
 */

public class Cells {

  /**
   * CellContent/content = Cells can be Empty, have an X, or have 0
   * cRow, cCol = Cell Row & Cell Column
   */
  public enum CellContent {
    EMPTY, CROSS, ZERO
  }
  CellContent content;
  int cRow, cCol;

  /** Constructor to initialize cell */
  public Cells(int row, int col) {
    cRow = row;
    cCol = col;
    clearCell();
  }

  /** Clear the cell (set contents to Empty) */
  public void clearCell() {
    content = CellContent.EMPTY;
  }

  /** Sets the content of the cell to new move based on player */
  public void setContent() {
    switch (content) {
      case CROSS:
        System.out.print(" X ");
        break;
      case ZERO:
        System.out.print(" O ");
        break;
      case EMPTY:
        System.out.print("   ");
        break;
    }
  }

}
