package players;

import enums.Movements;

public class CpuPlayerMedium extends players.CpuPlayerEasy {
    private int sum;

    public CpuPlayerMedium(utils.Board board, Movements movement) {
        super(board, movement);
    }

    @Override
    public void chooseField() {

        //1.try to win OR try to block
        //checks rows
        for (int i = 0; i < 3; i++) {  //dla kazdego wiersza
            if (!getBoard().isRowFull(i)) { //spr czy wiersz jest pelny, jak pełny to go pomin i idz dalej
                sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += getBoard().getBoardField(i, j).getSignValue(); //sumuje elm z niepełnego wiersza
                }
                if (sum == 2 || sum == -2) {  //jesli ta suma to 2 v -2
                    x = i;                      //x to ten wiesz
                    findYofEmptyFieldInRow(x); //y to puste pole w tym wierszu
                    return;
                }
            }
        }

        //check columns
        for (int j = 0; j < 3; j++) {
            if (!getBoard().isColFull(j)) {
                sum = 0;
                for (int i = 0; i < 3; i++) {
                    sum += getBoard().getBoardField(i, j).getSignValue();
                }
                if (sum == 2 || sum == -2) {  //jesli ta suma to 2 v -2
                    y = j;                      //x to ten wiesz
                    findXYofEmptyFieldInCol(y);
                    return;
                }
            }
        }

        //check diags
        //2a przekątna /
        if (!getBoard().isFrontDiagFull()) { //jeśli przekątna / nie jest pełna
            sum = 0;
            sumFrontDiag();
            if (sum == 2 || sum == -2) {             //zsumuj i jak suma = 2 v -2
                findEmptyFieldInFrontDiag();  //znajdz puste i wypełnij
                return;
            }
        }
        //2b przekątna \
        if (!getBoard().isBackDiagFull()) {  //jeśli przekątna \ nie jest pełna
            sum = 0;
            sumBackDiag();
            if (sum == 2 || sum == -2) {
                findEmptyFieldInBackDiag();
                return;
            }
        }

        //3.random
        chooseRandomField();
    }


    public void findYofEmptyFieldInRow(int row) {
        for (int j = 0; j < 3; j++) {
            if (getBoard().isFieldEmpty(row, j)) {
                y = j;
            }
        }
    }

    public void findXYofEmptyFieldInCol(int col) {
        for (int i = 0; i < 3; i++) {
            if (getBoard().isFieldEmpty(i, col)) {
                x = i;
            }
        }
    }


    public int sumFrontDiag() {
        return sum = getBoard().getBoardField(0, 2).getSignValue() + getBoard().getBoardField(1, 1).getSignValue() + getBoard().getBoardField(2, 0).getSignValue();
    }

    public int sumBackDiag() {
        return sum = getBoard().getBoardField(0, 0).getSignValue() + getBoard().getBoardField(1, 1).getSignValue() + getBoard().getBoardField(2, 2).getSignValue();
    }

    public void findEmptyFieldInFrontDiag() { //this diagonal -> /
        if (getBoard().isFieldEmpty(0, 2)) {
            x = 0;
            y = 2;
        } else if (getBoard().isFieldEmpty(1, 1)) {
            x = 1;
            y = 1;
        } else if (getBoard().isFieldEmpty(2, 0)){
            x = 2;
            y = 0;
        }
    }

    public void findEmptyFieldInBackDiag() { //this diagonal -> \
        if (getBoard().isFieldEmpty(0, 0)) {
            x = 0;
            y = 0;
        } else if (getBoard().isFieldEmpty(1, 1)) {
            x = 1;
            y = 1;
        } else if (getBoard().isFieldEmpty(2, 2)) {
            x = 2;
            y = 2;
        }
    }
}

