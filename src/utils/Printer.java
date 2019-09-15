package utils;
public class Printer {
    private Board board;

    public Printer(Board board) {
        this.board = board;
    }

    public void showBoard() {
        System.out.println("_____________");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (board.getBoardField(i, j)) {
                    case X:
                        System.out.print("|" + " X ");
                        break;
                    case O:
                        System.out.print("|" + " O ");
                        break;
                    case EMPTY:
                        System.out.print("|" + "   ");
                        break;
                }
            }
            System.out.println("|" + "\n_____________");
        }
    }

}

