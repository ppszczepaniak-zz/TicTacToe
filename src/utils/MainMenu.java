package utils;

import enums.Movements;
import players.CpuPlayerEasy;
import players.CpuPlayerMedium;
import players.HumanPlayer;
import players.Player;

import java.util.Scanner;

public class MainMenu {
    private Game game;
    private Printer printer;
    private Board board;
    private Scanner input = new Scanner(System.in);
    private int playerValue;
    private Player player1;
    private Player player2;


    public MainMenu() {
        board = new Board();                //tworze pusta tablice
        printer = new Printer(board);       //tworze printer do wyswietlania tablicy

        //tworze gracza 1
        do {
            System.out.println("Choose player [X]: 0 = human, 1 = CPU (EASY), 2 = CPU (MEDIUM)");
            playerValue = input.nextInt();
        } while (playerValue != 0 && playerValue != 1 && playerValue != 2);

        switch (playerValue) {
            case 0:
                player1 = new HumanPlayer(board, Movements.X);
                System.out.println("Player [X] is a human.");
                break;
            case 1:
                player1 = new CpuPlayerEasy(board, Movements.X);
                System.out.println("Player [X] is a CPU (EASY).");
                break;
            case 2:
                player1 = new CpuPlayerMedium(board, Movements.X);
                System.out.println("Player [X] is a CPU (MEDIUM).");
                break;
        }

        //tworze gracza 2
        do {
            System.out.println("Choose player [O]: 0 = human, 1 = CPU (EASY), 2 = CPU (MEDIUM)");
            playerValue = input.nextInt();
        } while (playerValue != 0 && playerValue != 1 && playerValue != 2);

        switch (playerValue) {
            case 0:
                player2 = new HumanPlayer(board, Movements.O);
                System.out.println("Player [O] is a human.");
                break;
            case 1:
                player2 = new CpuPlayerEasy(board, Movements.O);
                System.out.println("Player [O] is a CPU (EASY).");
                break;
            case 2:
                player2 = new CpuPlayerMedium(board, Movements.O);
                System.out.println("Player [O] is a CPU (MEDIUM).");
                break;
        }

        //ew. feature czekam ze startem na wciśnięcie s (przydatne gdy graja 2 komputery)
        //writeS();

        game = new Game(board, player1, player2, printer); //start gry
    }


    private void writeS() {
        String pressed;
        do {
            System.out.println("Write 's' to begin game...");
            pressed = input.next();
        } while (!pressed.equals("s"));
    }

}


