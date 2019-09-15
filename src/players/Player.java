package players;

import utils.Board;
import enums.Movements;

public abstract class Player {
    private Board board;
    protected int x;
    protected int y;
    protected Movements movement;

    public Player(Board board, Movements movement) {
        this.board = board;
        this.movement = movement;
    }

    public void playerMove() {
        do {
            chooseField();      //player musi wybrac pole, dopoki nie wybierze pustego
            if (!getBoard().isFieldEmpty(x, y)) {
                System.out.println("=> ERROR: Pole (" + x + ", " + y + ") jest już zajęte! Wybierz inne pole...");
            }
        } while (!getBoard().isFieldEmpty(x, y));
        makeMove(x, y, movement); //wykonuje ruch na to pole
    }

    public abstract void chooseField();


    public void makeMove(int row, int column, Movements move) {
        getBoard().setBoardField(row, column, move);
        System.out.println("Gracz [" + move + "] wykonał ruch " + move + " na polu (" + row + ", " + column + ")");
    }


    public Board getBoard() {
        return board;
    }

    public Movements getMovement() {
        return movement;
    }
}
