import java.util.Scanner;
public class Game {
    private Board newBoard;
    private boolean blackMove;
    public Game(){
        this.newBoard=new Board();
        blackMove=false;
//        initializes the game to standard chess setup and sets first move to white

    }

    public static void main (String[] args){
        Game newGame=new Game();
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR",newGame.newBoard);
// Creates a new game, and the constructor makes a board with the proper setup.
        System.out.println("Welcome to CSCI 1933H chess. This chess functions under simplified rules.");
        Scanner gameInput=new Scanner(System.in);
        while (!newGame.newBoard.isGameOver()){
            System.out.println(newGame.newBoard);
            if(!newGame.blackMove){
                System.out.println("It is currently white's turn to play");
            }
            else{
                System.out.println("It is currently black's turn to play");
            }
            System.out.println("What is your move? Format: [start row] [start col] [end row] [end col]");
            String[] inputs=gameInput.nextLine().trim().split("\\s+");
            int[] moveNumbers=new int[inputs.length];
            for(int i=0;i<inputs.length;i++)
                moveNumbers[i]=Integer.parseInt(inputs[i]);
            if(moveNumbers.length!=4){
                System.out.println("Invalid input. Please enter four numbers, according to the format above");
            }
            else{
                if(newGame.newBoard.verifySourceAndDestination(moveNumbers[0],moveNumbers[1],moveNumbers[2],moveNumbers[3],newGame.blackMove) && newGame.newBoard.movePiece(moveNumbers[0],moveNumbers[1],moveNumbers[2],moveNumbers[3]))
                {newGame.newBoard.getPiece(moveNumbers[2],moveNumbers[3]).promotePawn(moveNumbers[2],newGame.newBoard.getPiece(moveNumbers[2],moveNumbers[3]).getIsBlack());
                    newGame.blackMove=!newGame.blackMove;}
                //alternates whose turn it is,checks if pawn needs to be promoted
                else{
                    System.out.println("Invalid move.");
                }

            }


        };
        if(newGame.newBoard.blackWins){
        System.out.println("Black has won the game!");}
        else if(newGame.newBoard.whiteWins){
            System.out.println("White has won the game!");}
        else {
            System.out.println("How did we get here?");
        };


    }
}
