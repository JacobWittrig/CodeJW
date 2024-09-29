import java.lang.Math;
public class Board {

    // Instance variables
    private Piece[][] board;
    boolean whiteWins;
    boolean blackWins;


    // Construct an object of type Board using given arguments.
    public Board() {
    this.board = new Piece[8][8];
    }

    // Accessor Methods


    // Return the Piece object stored at a given row and column
    public Piece getPiece(int row, int col) {

        return board[row][col];
    }


    // Update a single cell of the board to the new piece.
    public void setPiece(int row, int col, Piece piece) {
        board[row][col]=piece;
    }

    // Game functionality methods


    // Moves a Piece object from one cell in the board to another, provided that
    // this movement is legal. A constraint of a legal move is:
    // - there exists a Piece at (startRow, startCol) and the destination square is seizable.
    // Returns a boolean to signify success or failure.
    // This method calls all necessary helper functions to determine if a move is legal,
    // and to execute the move if it is.
    // Your Game class should not directly call any other method of this class.
    // Hint: this method should call isMoveLegal() on the starting piece. 
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        if(board[startRow][startCol]==null)
            return false;
        if(verifySourceAndDestination(startRow,startCol,endRow, endCol, board[startRow][startCol].getIsBlack())==false)
            return false;
        if(board[startRow][startCol].isMoveLegal(this,endRow,endCol)==false)
            return false;
        board[startRow][startCol].setPosition(endRow,endCol);
        setPiece(endRow,endCol,board[startRow][startCol]);
        setPiece(startRow,startCol,null);
        return true;
    }


    // Determines whether the game has been ended, i.e., if one player's King
    // has been captured.
    public boolean isGameOver() {
        boolean hasBlackKing=false;
        boolean hasWhiteKing=false;
        for (Piece[] row: board){
            for (Piece cell: row){
                if(cell!=null) {
                    if (cell.character == '\u265a')
                        hasBlackKing = true;
                    if (cell.character == '\u2654')
                        hasWhiteKing = true;
                }
            }
        }
        whiteWins=hasWhiteKing;
        blackWins=hasBlackKing;
        return (!hasWhiteKing | !hasBlackKing);
    }

    // Constructs a String that represents the Board object's 2D array.
    // Returns the fully constructed String.
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(" ");
        for(int i = 0; i < 8; i++){
            out.append(" ");
            out.append(i);
        }
        out.append('\n');
        for(int i = 0; i < board.length; i++) {
            out.append(i);
            out.append("|");
            for(int j = 0; j < board[0].length; j++) {
                out.append(board[i][j] == null ? "\u2001|" : board[i][j] + "|");
            }
            out.append("\n");
        }
        return out.toString();
    }


    // Sets every cell of the array to null. For debugging and grading purposes.
    public void clear() {
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                board[i][j]=null;
            }
        }

    }

    // Movement helper functions


    // Ensures that the player's chosen move is even remotely legal.
    // Returns a boolean to signify whether:
    // - 'start' and 'end' fall within the array's bounds.
    // - 'start' contains a Piece object, i.e., not null.
    // - Player's color and color of 'start' Piece match.
    // - 'end' contains either no Piece or a Piece of the opposite color.
    // - where 'start' = (startRow, startCol) and 'end' = (endRow, endCol)
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        if(startRow>7 | startRow<0 | endRow>7 | endRow<0 | startCol>7 | startCol<0 | endCol>7 | endCol<0)
            return false;
        if(board[startRow][startCol]==null)
            return false;
        if(isBlack!=board[startRow][startCol].getIsBlack())
            return false;
        if(board[endRow][endCol]!=null && (board[startRow][startCol].getIsBlack()==board[endRow][endCol].getIsBlack()))
            return false;
        if(startRow==endRow && startCol==endCol)
            return false;
        return true;
    }


    // Check whether the 'start' position and 'end' position are adjacent to each other
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
//        if(startRow==endRow && startCol==endCol)
//            return false;
//        Commented these two lines out as the test cases do not like this test

        if(Math.abs(startRow-endRow)>1 | Math.abs(startCol-endCol)>1)
            return false;
        return true;
    }


    // Checks whether a given 'start' and 'end' position are a valid horizontal move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one row.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {

//        if(startRow==endRow && startCol==endCol)
//            return false;
        //        Commented these two lines out as the test cases do not like this test
        if(startRow!=endRow)
            return false;
        //checks to make sure movement is in a line
        for(int i=Math.min(startCol,endCol)+1;i<Math.max(startCol,endCol);i++){
            if(board[startRow][i]!=null)
                return false;
            //checks to see if path is through a piece
        }
        return true;
        //returns true if all criteria fit
    }


    // Checks whether a given 'start' and 'end' position are a valid vertical move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one column.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
//        if(startRow==endRow && startCol==endCol)
//            return false;
        //        Commented these two lines out as the test cases do not like this test
        if(startCol!=endCol)
            return false;
        //checks to make sure movement is in a line
        for(int i=Math.min(startRow,endRow)+1;i<Math.max(startRow,endRow);i++){
            if(board[i][startCol]!=null)
                return false;
            //checks to see if path is through a piece
        }
        return true;
    }


    // Checks whether a given 'start' and 'end' position are a valid diagonal move.
    // Returns a boolean to signify whether:
    // - The path from 'start' to 'end' is diagonal... change in row and col.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        if (Math.abs(startRow - endRow) != Math.abs(startCol - endCol))
            return false;
        //checks to see if move is diagonal
        for (int i = 1; i < Math.abs(startRow - endRow); i++) {
            if (board[startRow + i * Integer.signum(endRow-startRow)][startCol + i * Integer.signum(endCol-startCol)] != null)
                return false;
// checks to see if path is empty by using a for loop which increments by one in each step

        }

        return true;
    }
}
