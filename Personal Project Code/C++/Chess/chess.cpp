#include <iostream>
#include <vector>

// Enum for chess pieces
enum Piece {
    EMPTY, PAWN, KNIGHT, BISHOP, ROOK, QUEEN, KING
};

// Struct to represent a chess piece
struct ChessPiece {
    Piece piece;
    bool isWhite;
};

// Function to initialize the chessboard
std::vector<ChessPiece> initializeChessboard() {
    std::vector<ChessPiece> board(64, {EMPTY, false});

    // Place pawns
    for (int i = 8; i < 16; ++i) {
        board[i] = {PAWN, true}; // White pawns
        board[i + 40] = {PAWN, false}; // Black pawns
    }

    // Place other pieces
    std::vector<Piece> pieceOrder = {ROOK, KNIGHT, BISHOP, QUEEN, KING, BISHOP, KNIGHT, ROOK};
    for (int i = 0; i < 8; ++i) {
        board[i] = {pieceOrder[i], true}; // White pieces
        board[i + 56] = {pieceOrder[i], false}; // Black pieces
    }

    return board;
}

// Function to print the chessboard
void printChessboard(const std::vector<ChessPiece>& board) {
    for (int rank = 7; rank >= 0; --rank) {
        for (int file = 0; file < 8; ++file) {
            int index = rank * 8 + file;
            ChessPiece cp = board[index];
            char pieceChar = '.';
            switch (cp.piece) {
                case PAWN: pieceChar = 'P'; break;
                case KNIGHT: pieceChar = 'N'; break;
                case BISHOP: pieceChar = 'B'; break;
                case ROOK: pieceChar = 'R'; break;
                case QUEEN: pieceChar = 'Q'; break;
                case KING: pieceChar = 'K'; break;
                default: break;
            }
            if (!cp.isWhite && cp.piece != EMPTY) {
                pieceChar = tolower(pieceChar);
            }
            std::cout << pieceChar << " ";
        }
        std::cout << std::endl;
    }
}

int main() {
    std::vector<ChessPiece> chessboard = initializeChessboard();
    printChessboard(chessboard);
    return 0;
}























