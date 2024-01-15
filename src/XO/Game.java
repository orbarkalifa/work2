package XO;

import java.util.ArrayList;

public abstract class Game {

    private Mark[][] gameBoard;
    private Mark turn;
    private boolean isGameOver;


    // CTOR INITIALIZE GAME
    public Game() {

        isGameOver = false;
        turn = Mark.O;
        gameBoard = new Mark[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                gameBoard[i][j] = Mark.e;
            }
        }
    }

    // PRINT BOARD
    public void printBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(" " + gameBoard[i][j] + " ");
                if (j < 4) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 4) {
                System.out.println("----------------");
            }
        }
        System.out.println("----------------------------");

    }

    public synchronized Mark getTurn(){
        return turn;
    }
    public synchronized void setTurn(Mark t){
        turn = t;
    }


    // RETURN ALL AVAILABLE MOVES
    public synchronized ArrayList<Cell> getFreeCells() {
        ArrayList<Cell> cells = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (gameBoard[i][j] == Mark.e) {
                    cells.add(new Cell(i, j));
                }
            }
        }
        return cells;
    }

    public void placeMove(int row, int col, Mark player) {
        if (row >= 0 && row < 5 && col >= 0 && col < 5 && gameBoard[row][col] == Mark.e) {
            gameBoard[row][col] = player;
        } else {
            System.out.println("Invalid move. Please try again.");
        }
    }

    // CHECK IF BOARD IS FULL
    public boolean isBoardFull() {
        return getFreeCells().isEmpty();
    }


    // CHECK FOR A WINNER
    public Mark checkForWinner() {

        // ROWS
        for (int i = 0; i < 5; i++) {
            if(gameBoard[i][2] == gameBoard [i][0]|| gameBoard[i][2] == gameBoard[i][4])
                if(gameBoard[i][1]==gameBoard[i][2] && gameBoard[i][1] == gameBoard[i][3])
                    return gameBoard[i][2];

        }

        // COLUMNS
        for (int j = 0; j < 5; j++) {
            if(gameBoard[2][j] == gameBoard [0][j]|| gameBoard[2][j] == gameBoard[4][j])
                if(gameBoard[1][j]==gameBoard[2][j] && gameBoard[1][j] == gameBoard[3][j])
                    return gameBoard[2][j];
        }

        // DIAGONALS
        //main diagonal
        if(gameBoard[2][2] == gameBoard [0][0]|| gameBoard[2][2] == gameBoard[4][4])
            if(gameBoard[1][1]==gameBoard[2][2] && gameBoard[1][1] == gameBoard[3][3])
                return gameBoard[2][2];
        //sub diagonal
        if(gameBoard[2][2] == gameBoard [0][4]|| gameBoard[2][2] == gameBoard[4][0])
            if(gameBoard[1][3]==gameBoard[2][2] && gameBoard[1][3] == gameBoard[3][1])
                return gameBoard[2][2];

        if (checkLine(gameBoard[0][1], gameBoard[1][2], gameBoard[2][3], gameBoard[3][4])) {
            return gameBoard[0][1];
        }
        if (checkLine(gameBoard[1][0], gameBoard[2][1], gameBoard[3][2], gameBoard[4][3])) {
            return gameBoard[1][0];
        }

        if (checkLine(gameBoard[0][3], gameBoard[1][2], gameBoard[2][1], gameBoard[3][0])) {
            return gameBoard[0][1];
        }
        if (checkLine(gameBoard[1][4], gameBoard[2][3], gameBoard[3][2], gameBoard[4][1])) {
            return gameBoard[1][4];
        }

        return Mark.e; // No winner yet
    }

    // Helper method
    private boolean checkLine(Mark a, Mark b, Mark c, Mark d) {
        return (a != Mark.e && a == b && b == c && c == d);
    }



    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean b) {
        isGameOver = b;
    }
}