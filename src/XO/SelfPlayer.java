package XO;

import java.util.List;

public class SelfPlayer extends Player implements Runnable {
    private SelfGame game;

    public SelfPlayer(SelfGame game, Mark playerMark) {
        super(playerMark);
        this.game = game;
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

                    // Check for a winner or a draw
                    Mark winner = game.checkForWinner();
                    if (winner != Mark.E || game.isBoardFull()) {
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

        System.out.println("Null returned - no free cells");
        return null;
    }
}
