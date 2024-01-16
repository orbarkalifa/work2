package XO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserPlayer extends Player implements Runnable {
    private Game game;

    public UserPlayer (UserGame game, Mark playerMark) {
        super(playerMark);
        this.game = game;
    }



    @Override
    public void run() {
        while (!game.isGameOver()) {
            if(!(game.getTurn() == playerMark)){
                game.printBoard();
                Cell chosenCell = game.inputCell();
                    game.placeMove(chosenCell.getRow(), chosenCell.getCol(), playerMark);
                    game.printBoard();
                    game.setTurn(playerMark);
                if (game.isGameOver()) {
                    game.setGameOver(true);
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
