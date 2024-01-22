// Or Bar-Califa 318279429
// Daniel Fradkin 316410885
// https://github.com/orbarkalifa/work2

package XO;
// abstract player parent class
public abstract class Player {

    protected final Game game;
    Mark playerMark;
    public Player(Game game, Mark playerMark){
        this.playerMark = playerMark;
        this.game = game;
    }

    public void playAndPrintBoard(Cell chosenCell) {
        game.placeMove(chosenCell.getRow(), chosenCell.getCol(), playerMark);
        game.printBoard();
        // Check for a winner or a draw
        Mark status = game.checkForWinner();
        if (game.isGameOver()) {
            game.printWinner(status);
            return;
        }
        game.setTurn(playerMark);
    }
}
