package XO;
// abstract player parent class
public abstract class Player {

    protected final Game game;
    Mark playerMark;
    public Player(Game game, Mark playerMark){
        this.playerMark=playerMark;
        this.game=game;
    }

    public void playAndPrintBoard(Cell chosenCell) {
            game.placeMove(chosenCell.getRow(), chosenCell.getCol(), playerMark);
            game.printBoard();
            // Check for a winner or a draw
            if (game.isGameOver()) {
                game.printWinner(game.checkForWinner());
                return;
            }
            game.setTurn(playerMark);
        }
}
