// Or Bar-Califa 318279429
// Daniel Fradkin 316410885
// https://github.com/orbarkalifa/work2

package XO;

public class SelfGame extends Game {

    Thread t1;
    Thread t2;

    // initialize game, creating two selfPlayer threads and activate run() function for each
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
