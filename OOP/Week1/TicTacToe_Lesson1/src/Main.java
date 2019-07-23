/**
 * Where I'm at: Setup the basic board, single move works (need to test all cases)
 * Need to add loop to Player Moves, scoreboard, and move logic to classes
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // make private??
    public enum GameState {PLAYING, DRAW, CROSS_WON, O_WON}
    public enum CellContent { EMPTY, CROSS, CIRCLE }

    public static int[] getPlayerMove(CellContent player) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            if (player == CellContent.CROSS) {
                System.out.print("Enter your move Player X (A-C 1-3, like 'A 3'): ");
            } else {
                System.out.print("Enter your move Player O (A-C 1-3, like 'A 3'): ");
            }

            String playerMove = scan.nextLine().toLowerCase();
            try {

                char row = playerMove.charAt(0);
                int col = Character.getNumericValue(playerMove.charAt(2)) - 1;

                if (col >= 0 && col < 3) {
                    switch (row) {
                        case 'a':
                            return new int[] {0, col};
                        case 'b':
                            return new int[] {1, col};
                        case 'c':
                            return new int[] {2, col};
                 }
                }

            } catch (Exception e) {
                System.out.println("\nYou have to enter: ROW COLUMN such as 'B 2'\n");
            }
        }
    }

    public static void main(String[] args) {
        Map<GameState, Integer> scores = new HashMap();
        Board board = new Board();

        System.out.println("X always goes first in this game, so X starts:");

        CellContent curPlayer = CellContent.CROSS;
        board.drawMove(getPlayerMove(curPlayer), 'X');
    }
}
