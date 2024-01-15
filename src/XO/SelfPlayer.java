package XO;

import java.util.List;

public class SelfPlayer extends Player implements Runnable {
    private SelfGame game;

    public SelfPlayer(Game game, Mark playerMark) {
        super(playerMark);
        this.game = (SelfGame) game;
    }



    @Override
    public void run() {
        while (!game.isGameOver()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(!(game.getTurn() == playerMark)){
                Cell chosenCell = chooseRandomCell();
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

    private Cell chooseRandomCell() {

        List<Cell> freeCells = game.getFreeCells();

        if (!freeCells.isEmpty()) {
            // Select a random available cell
            int randomIndex = (int) (Math.random() * freeCells.size());
            return freeCells.get(randomIndex);
        }
        return null;
    }
}
