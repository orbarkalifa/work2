package XO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 for self game or 2 for user game");
        int option = input.nextInt();
        switch (option) {   // Initialize the game

            case 1:
                SelfGame selfGame = new SelfGame();
                break;
            case 2:
                UserGame userGame = new UserGame();
                break;

        }
    }
}
