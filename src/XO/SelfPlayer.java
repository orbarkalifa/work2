package XO;

import java.util.List;

public class SelfPlayer extends Player implements Runnable {

    public SelfPlayer(Game game, Mark playerMark) {
        super(game, playerMark);
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
            if (!(game.getTurn() == playerMark)) {
                System.out.println(playerMark + " played:");
                playAndPrintBoard(chooseRandomCell());
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
