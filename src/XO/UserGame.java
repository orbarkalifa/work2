// Or Bar-Califa 318279429
// Daniel Fradkin 316410885
// https://github.com/orbarkalifa/work2

package XO;


public class UserGame extends Game {

    Thread t1;
    Thread t2;

    // initialize game, creating self player and user player and activating run() function of each
    public UserGame() {
            super();
            SelfPlayer playerX = new SelfPlayer(this, Mark.X);
            UserPlayer playerO = new UserPlayer(this, Mark.O);
            t1 = new Thread(playerX);
            t2 = new Thread(playerO);
            t1.start();
            t2.start();
        }




}
