package XO;

import java.util.ArrayList;
import java.util.Scanner;

public class UserGame extends Game {

        Thread t1;
        Thread t2;

        public UserGame() {
            super();
            SelfPlayer playerX = new SelfPlayer(this, Mark.X);
            UserPlayer playerO = new UserPlayer(this, Mark.O);
            t1 = new Thread(playerX);
            t2 = new Thread(playerO);
            t1.start();  // Add this line
            t2.start();  // Add this line
        }




}
