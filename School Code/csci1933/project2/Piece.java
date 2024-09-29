import java.util.Objects;
import java.util.Scanner;

public class Piece {
    // Create Instance Variables
    char character;
    int row;
    int col;
    boolean isBlack;

    /**
     * Constructor.
     * @param character     The character representing the piece.
     * @param row           The row on the board the piece occupies.
     * @param col           The column on the board the piece occupies.
     * @param isBlack       The color of the piece.
     */
    public Piece(char character, int row, int col, boolean isBlack) {
        this.character = character;
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    /**
     * Determines if moving this piece is legal.
     * @param board     The current state of the board.
     * @param endRow    The destination row of the move.
     * @param endCol    The destination column of the move.
     * @return If the piece can legally move to the provided destination on the board.
     */
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        switch (this.character) {
            case '\u2659':
            case '\u265f':
                Pawn pawn = new Pawn(row, col, isBlack);
                return pawn.isMoveLegal(board, endRow, endCol);
            case '\u2656':
            case '\u265c':
                Rook rook = new Rook(row, col, isBlack);
                return rook.isMoveLegal(board, endRow, endCol);
            case '\u265e':
            case '\u2658':
                Knight knight = new Knight(row, col, isBlack);
                return knight.isMoveLegal(board, endRow, endCol);
            case '\u265d':
            case '\u2657':
                Bishop bishop = new Bishop(row, col, isBlack);
                return bishop.isMoveLegal(board, endRow, endCol);
            case '\u265b':
            case '\u2655':
                Queen queen = new Queen(row, col, isBlack);
                return queen.isMoveLegal(board, endRow, endCol);
            case '\u265a':
            case '\u2654':
                King king = new King(row, col, isBlack);
                return king.isMoveLegal(board, endRow, endCol);
            default:
                return false;
        }
    }

    /**
     * Sets the position of the piece.
     * @param row   The row to move the piece to.
     * @param col   The column to move the piece to.
     */
    public void setPosition(int row, int col) {
        this.row=row;
        this.col=col;

    }

    /**
     * Return the color of the piece.
     * @return  The color of the piece.
     */
    public boolean getIsBlack() {
        return this.isBlack;
    }

    /**
     * Handle promotion of a pawn.
     * @param row Current row of the pawn
     * @param isBlack Color of the pawn
     */

//    This function works by scanning in the requested promotion if a promotion should happen, then updating the piece
//    If an invalid piece is selected, the function is recalled so a valid input can be entered.
    public void promotePawn(int row, boolean isBlack) {
        if (this.character!='\u2659' && this.character!='\u265f')
            return;

        if(isBlack && row==7){
            String promote="";
            Scanner input = new Scanner(System.in);
            while(!Objects.equals(promote, "queen") && !Objects.equals(promote, "rook") && !Objects.equals(promote, "bishop") && !Objects.equals(promote, "knight")){
            System.out.println("Choose a piece to promote to: (queen, rook, bishop, or knight: ");
            promote = input.nextLine();}
//            input.close();
            switch (promote){
                case "queen":
                    this.character='\u265b';
                    break;
                case "rook":
                    this.character='\u265c';
                    break;
                case "bishop":
                    this.character='\u265d';
                    break;
                case "knight":
                    this.character='\u265e';
                    break;
                default:
                    promotePawn(row,isBlack);


            }

        }
        if(!isBlack && row==0) {
            Scanner input = new Scanner(System.in);
            System.out.println("Choose a piece to promote to: (queen, rook, bishop, or knight");
            String promote = input.nextLine();
//            input.close();
            switch (promote) {
                case "queen":
                    this.character = '\u2655';
                    break;
                case "rook":
                    this.character = '\u2656';
                    break;
                case "bishop":
                    this.character = '\u2657';
                    break;
                case "knight":
                    this.character = '\u2658';
                    break;
                default:
                    promotePawn(row, isBlack);
            }
        }
    }
    //function above takes in input and checks color in order to see if pawn needs promotion


    /**
     * Returns a string representation of the piece.
     * @return  A string representation of the piece.
     */
    public String toString() {
        return Character.toString(this.character);
    }


}
