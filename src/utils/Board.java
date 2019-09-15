package utils;

import enums.Movements;

public class Board {

    private Movements[][] board = new Movements[3][3];

    public Board() {
        newBoard(board);
    }

    private void newBoard(Movements[][] board) { //przy tworzeniu Board, wypełniam go ruchami "EMPTY" - czyszcze tablice
        System.out.println("=> NEW GAME!");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Movements.EMPTY;
            }
        }
    }

    public Movements getBoardField(int row, int column) {
        return board[row][column];
    }

    public void setBoardField(int row, int column, Movements movement) {
        board[row][column] = movement;
    }

    public Movements[][] getBoard() {
        return board;
    }

    public Boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Movements.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public Boolean isFieldEmpty(int row, int column) {
        if (board[row][column].getSignValue() == 0) {
            return true;
        }
        return false;
    }

    public Boolean isRowFull(int row) {
        //mnoże 3 pola (jesli znajde puste pore (wartość zero) to sie zeruje, wiec wiersz niepełny)
        if (getBoardField(row, 0).getSignValue() * getBoardField(row, 1).getSignValue() * getBoardField(row, 2).getSignValue() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isColFull(int col) {
        if (getBoardField(0, col).getSignValue() * getBoardField(1, col).getSignValue() * getBoardField(2, col).getSignValue() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isFrontDiagFull() { //czyli ta -> /
        if (getBoardField(0, 2).getSignValue() * getBoardField(1, 1).getSignValue() * getBoardField(2, 0).getSignValue() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isBackDiagFull() { //czyli ta -> \
        if (getBoardField(0, 0).getSignValue() * getBoardField(1, 1).getSignValue() * getBoardField(2, 2).getSignValue() != 0) {
            return true;
        } else {
            return false;
        }
    }
}
