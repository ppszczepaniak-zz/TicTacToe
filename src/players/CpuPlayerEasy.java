package players;

import enums.Movements;
import utils.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CpuPlayerEasy extends Player {
    private Random randomGenerator = new Random();
    private List<Integer[]> listOfEmptyFields;

    public CpuPlayerEasy(Board board, Movements movement) {
        super(board, movement);
    }

    @Override
    public void chooseField() {
        chooseRandomField();
    }

    public void chooseRandomField() {
        findEmptyFieldsList(); //finds empty list

        //chooses random field from list (x,y)
        int randomEmptyField = randomGenerator.nextInt(listOfEmptyFields.size());
        x = listOfEmptyFields.get(randomEmptyField)[0];
        y = listOfEmptyFields.get(randomEmptyField)[1];
    }

    private void findEmptyFieldsList() {
        listOfEmptyFields = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (getBoard().isFieldEmpty(i, j)) {
                    listOfEmptyFields.add(new Integer[]{i, j}); //dodaje wektory 2 elementowe (x,y)
                }
            }
        }
    }

}
