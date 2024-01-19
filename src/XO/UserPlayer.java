package XO;

public class UserPlayer extends Player implements Runnable {

    public UserPlayer (UserGame game, Mark playerMark) {
        super(game, playerMark);
    }



    @Override
    public void run() {
        while (!game.isGameOver()) {
            synchronized (game) {
            if(!(game.getTurn() == playerMark))  playAndPrintBoard(game.inputCell());
            }

        }

    }

}
