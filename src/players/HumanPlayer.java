package players;

import utils.Board;
import enums.Movements;

import java.util.Scanner;


public class HumanPlayer extends Player {
    private Scanner input = new Scanner(System.in);


    public HumanPlayer(Board board, Movements movement) {
        super(board, movement);
    }

    @Override
    public void chooseField() {
        do {
            System.out.println("Wprowadź współrzędną (x,y) z przedziału od 0 do 2.");
            System.out.println("=> Podaj współrzędną x...");
            x = input.nextInt();
        } while (x != 0 && x != 1 && x != 2);

        do {
            System.out.println("=> Podaj współrzędną y...");
            y = input.nextInt();
        } while (y != 0 && y != 1 && y != 2);
    }
}
