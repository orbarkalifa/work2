package XO;

import java.util.List;

public class SelfPlayer implements Runnable {
    private SelfGame game;
    private Mark playerMark;

    public SelfPlayer(SelfGame game, Mark playerMark) {
        this.game = game;
        this.playerMark = playerMark;
    }



    @Override
    public void run() {
        while (!game.isGameOver()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }

            Cell chosenCell = chooseRandomCell();
            if (chosenCell != null) {
                game.placeMove(chosenCell.getRow(), chosenCell.getCol(), playerMark);
                game.printBoard();

                // Check for a winner or a draw
                Mark winner = game.checkForWinner();
                if (winner != Mark.c || game.isBoardFull()) {
                    game.setGameOver(true);
                    break;
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
