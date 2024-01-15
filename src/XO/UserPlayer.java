package XO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserPlayer extends Player implements Runnable {
    private SelfGame game;

    public UserPlayer (Game game, Mark playerMark) {
        super(playerMark);
        this.game = (SelfGame) game;
    }



    @Override
    public void run() {
        while (!game.isGameOver()) {

            if(!(game.getTurn() == playerMark)){
                Cell chosenCell = inputCell();
                if (chosenCell != null) {
                    game.placeMove(chosenCell.getRow(), chosenCell.getCol(), playerMark);
                    game.printBoard();
                    game.setTurn(playerMark);
                    if(game.isGameOver()) {
                        game.printWinner(game.checkForWinner());
                        break;
                    }
                    // Check for a winner or a draw
                    Mark winner = game.checkForWinner();
                    if (winner != Mark.e || game.isBoardFull()) {
                        game.setGameOver(true);
                        break;
                    }
                }
            }

        }
    }

    private Cell inputCell() {

        ArrayList<Cell> cells = game.getFreeCells();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter x,y coordinates (0-4): ");
        int x = input.nextInt();
        int y = input.nextInt();
        Cell inputCell = new Cell(x,y);
        if (!cells.contains(inputCell)) {
            System.out.println("incorrect input. try again");
            inputCell = inputCell();
        }
        return inputCell;

    }


}
