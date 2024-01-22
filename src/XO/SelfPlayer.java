// Or Bar-Califa 318279429
// Daniel Fradkin 316410885
// https://github.com/orbarkalifa/work2

package XO;

import java.util.List;

import static java.lang.StringTemplate.STR;

public class SelfPlayer extends Player implements Runnable {

    public SelfPlayer(Game game, Mark playerMark) {
        super(game, playerMark);
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
                    System.out.println(STR."\{playerMark} played:");
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
        return freeCells.getFirst(); // doesn't matter, game is over
    }
}
