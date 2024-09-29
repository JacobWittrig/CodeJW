import java.lang.Math;
public class Knight {
    /**
     * Constructor.
     * @param row   The current row of the pawn.
     * @param col   The current column of the pawn.
     * @param isBlack   The color of the pawn.
     */
    public Knight(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    /**
     * Checks if a move to a destination square is legal.
     * @param board     The game board.
     * @param endRow    The row of the destination square.
     * @param endCol    The column of the destination square.
     * @return True if the move to the destination square is legal, false otherwise.
     */
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if(Math.abs(this.row-endRow)==2 && Math.abs(this.col-endCol)==1)
            return true;
        if(Math.abs(this.row-endRow)==1 && Math.abs(this.col-endCol)==2)
            return true;
        // Case 1: True if movement is one in one direction and two in the other
        return false;
//        Returns false if movement is not according to the rules


    }

    // Instance variables
    private int row;
    private int col;
    private boolean isBlack;

}
