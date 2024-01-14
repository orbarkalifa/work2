package XO;

public class SelfGame extends Game {

    Thread t1;
    Thread t2;

    public SelfGame() {
        super();
        SelfPlayer playerX = new SelfPlayer(this, Mark.O);
        SelfPlayer playerO = new SelfPlayer(this, Mark.X);
        t1 = new Thread(playerX);
        t2 = new Thread(playerO);
        t1.start();  // Add this line
        t2.start();  // Add this line
    }


}
