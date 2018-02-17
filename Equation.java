package cz.ales.training;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by ales on 13.2.18.
 */

public class Equation {
    private static final int PLUS = 1;
    private static final int MINUS = 2;
    private static final int TIMES = 3;
    private static final int DIV = 4;

    private int variable1;
    private int variable2;
    private int result1;
    private int result2;
    private int result3;
    private int correctResult;
    private int currentSign;

    //constructor - prerequisities for the equation creation + creation
    public Equation(Boolean plus, Boolean minus, Boolean times, Boolean div, int maxVariable, int maxResult) {
        // todo dokončit metody
        currentSign = generateSign(plus, minus, times, div);
        generateVariables(maxVariable);
        generateResults(maxResult);
    }

    // randomly choose the sign from available signs
    private int generateSign(boolean plus, boolean minus, boolean times, boolean div) {
        LinkedList<Integer> signList = new LinkedList<>();
        if (plus) signList.add(PLUS);
        if (minus) signList.add(MINUS);
        if (times) signList.add(TIMES);
        if (div) signList.add(DIV);
        return signList.get(generateNumber(signList.size()));
    }

    // generate three results according to used sign
    private void generateResults() {

    }

    // generator of numbers
    private int generateNumber(int maxNumber) {
        Random random = new Random();
        return random.nextInt();
    }

    // this is a main method in this class. Here I will prepare variables
    private void generateVariables() {
        sign = generateSign();
        if (sign == PLUS) {
        } else if (sign == MINUS) {


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
