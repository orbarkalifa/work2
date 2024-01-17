package XO;
// abstract player parent class
public abstract class Player {

    protected Game game;
    Mark playerMark;
    public Player(Game game, Mark playerMark){
        this.playerMark=playerMark;
        this.game=game;
    }

    public synchronized void playAndPrintBoard(Cell chosenCell){
        game.placeMove(chosenCell.getRow(), chosenCell.getCol(), playerMark);
        game.printBoard();

        // Check for a winner or a draw
        Mark winner = game.checkForWinner();
        if (winner != Mark.e || game.isBoardFull()) {
            game.setGameOver(true);
            game.printWinner(game.checkForWinner());
            return;
        }
        game.setTurn(playerMark);
    }
}
