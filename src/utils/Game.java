package utils;

import players.Player;

public class Game {

    private Board board;
    private Printer printer;
    private Player player1;
    private Player player2;


    public Game(Board board, Player player1, Player player2, Printer printer) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.printer = printer;
        playGame();
    }

    public void playGame() {
        printer.showBoard();
        do {
            if (isGameOverAfterMoveOf(player1)) {
                break;
            }
            if (isGameOverAfterMoveOf(player2)) {
                break;
            }
        } while (true);
    }

    public Boolean isGameOverAfterMoveOf(Player player) {
        System.out.print("=> Ruch gracza [" + player.getMovement() + "]. ");
        player.playerMove();
        printer.showBoard();
        if (hasPlayerWon()) {
            System.out.println("=> GAME OVER: PLAYER [" + player.getMovement() + "] HAS WON!");
            return true;
        } else if (board.isBoardFull()) {
            System.out.println("=> REMIS!");
            return true;
        }
        return false;
    }


    public Boolean hasPlayerWon() {
        if (isSameInRows() || isSameInColumns() || isSameInDiagonals()) {
            return true;
        }
        return false;
    }

    //warunki zwycięstwa
    private Boolean isSameInRows() {
        for (int i = 0; i < 3; i++) {
            if (board.isRowFull(i)) { //spr. czy wiersz jest pełny
                if (board.getBoardField(i, 0).equals(board.getBoardField(i, 1))) {
                    if (board.getBoardField(i, 1).equals(board.getBoardField(i, 2))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private Boolean isSameInColumns() {
        for (int i = 0; i < 3; i++) {
            if (board.isColFull(i)) { //spr. czy kolumna jest pełna
                if (board.getBoardField(0, i).equals(board.getBoardField(1, i))) {
                    if (board.getBoardField(1, i).equals(board.getBoardField(2, i))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private Boolean isSameInDiagonals() {
        if (board.isFrontDiagFull()) //spr skos1 tzn ten -> /
            if (board.getBoard()[0][0].equals(board.getBoard()[1][1])) {
                if (board.getBoard()[1][1].equals(board.getBoard()[2][2])) {
                    return true;
                }
            }

        if (board.isBackDiagFull()) //spr skos2 tzn ten -> \
            if (board.getBoard()[0][2].equals(board.getBoard()[1][1])) {
                if (board.getBoard()[1][1].equals(board.getBoard()[2][0])) {
                    return true;
                }
            }
        return false;
    }
}
