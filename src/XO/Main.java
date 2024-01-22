// Or Bar-Califa 318279429
// Daniel Fradkin 316410885
// https://github.com/orbarkalifa/work2

package XO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 for self game or 2 for user game");
        int option = input.nextInt();
        switch (option) {   // Initialize the game
            case 1:
                new SelfGame();
                break;
            case 2:
                new UserGame();
                break;
            default:
                System.out.println("invalid input, try again");
                break;
        }

    }


}
