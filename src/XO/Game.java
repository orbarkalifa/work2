package XO;


import java.util.ArrayList;

public abstract class Game {


    public XO type;

    private String[][] gameBoard = new String[5][5];

    public void printBoard(){
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                if (gameBoard[i][j] != null) System.out.print(gameBoard[i][j] + " ");
                else System.out.print(" - ");
            }
            System.out.println();
        }
    }

    public XO getTurn(){
        //todo
        return type;
    }

    public ArrayList<Cell> getFreeCells() {
        ArrayList<Cell> cells = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (gameBoard[i][j] == null){
                    cells.add(new Cell(i,j));
                }
            }
        }
        return cells;
    }



}
