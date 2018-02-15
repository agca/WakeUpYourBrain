package cz.ales.training;

import java.util.Random;

/**
 * Created by ales on 13.2.18.
 */

public class Equation {
    private int variable1;
    private int variable2;
    private enum Sign {PLUS, MINUS, TIMES, DIV}
    private int result1;
    private int result2;
    private int result3;
    private int correctResult;

    private void generateResults(Sign sign) {

    }

    private int generateNumber(int maxNumber) {
        Random random = new Random();
        return random.nextInt();
    }

    // this is a main method in this class. Here I will prepare variables
    private void generateVariables(Sign sign, int maxVariable, int maxResult) {
        switch (sign) {
            case PLUS:
                variable1 = generateNumber(maxVariable);
                variable2 = generateNumber(maxResult-variable1);
                break;

            case MINUS:
                variable1 = generateNumber(maxVariable);
                variable2 = generateNumber(variable1);
                break;

            case TIMES:

                break;

            case DIV:

                break;

            default:

            break;

        }
    }
}
