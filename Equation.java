package cz.ales.training;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by ales on 13.2.18.
 */

public class Equation {
    private static final int PLUS = 0;
    private static final int MINUS = 1;
    private static final int TIMES = 2;
    private static final int DIV = 3;
    private String[] signString = {"+", "-", "*", "/"};

    private int variable1;
    private int variable2;
    private int result1;
    private int result2;
    private int result3;
    private int correctResult;
    private int currentSign;

    //constructor + input prerequisities for the equation creation + creation
    //                      true          true           false         false        10              20
    public Equation(boolean plus, boolean minus, boolean times, boolean div, int otherNumber, int maxNumber) {
        currentSign = generateSign(plus, minus, times, div);
        generateVariables(otherNumber, maxNumber);
        generateCorrectResult();
        generateFakeResults(plus, minus, times, div);
    }

    public String getEquationString() {
        String equation = "" + variable1 + " " + signString[currentSign] + " " + variable2 + " = ";
        return  equation;
    }

    public String getResult1String() {
        return ""+result1;
    }

    public String getResult2String() {
        return ""+result2;
    }

    public String getResult3String() {
        return ""+result3;
    }

    public String getCorrectResultString() {
        return ""+correctResult;
    }

    // randomly choose the sign from available signs
    private int generateSign(boolean plus, boolean minus, boolean times, boolean div) {
        LinkedList<Integer> signList = new LinkedList<>();
        if (plus) signList.add(PLUS);
        if (minus) signList.add(MINUS);
        if (times) signList.add(TIMES);
        if (div) signList.add(DIV);
        int num = generateNumber(signList.size());
        return signList.get(num-1);
    }

    // generate three results according to used sign
    private void generateCorrectResult() {
        switch (currentSign) {
            case PLUS:
                correctResult = variable1 + variable2;
                break;
            case MINUS:
                correctResult = variable1 - variable2;
                break;
            case TIMES:
                correctResult = variable1 * variable2;
                break;
            case DIV:
                correctResult = variable1 / variable2;
                break;
            default:
                break;
        }
    }

    // this is a main method in this class; variables will be prepared here.
    private void generateVariables(int otherNumber, int maxNumber) {
        switch (currentSign) {
            case PLUS:
                variable1 = generateNumber(otherNumber);
                if ((maxNumber-variable1) < otherNumber) {
                    variable2 = generateNumber(maxNumber-variable1);
                } else {
                    variable2 = generateNumber(otherNumber);
                }
                break;

            case MINUS:
                variable1 = generateNumber(maxNumber);
                if (variable1>otherNumber) {
                    variable2 = generateNumber(otherNumber);
                } else {
                    variable2 = generateNumber(variable1);
                }
                break;

            case TIMES:
                variable1 = generateNumber(otherNumber);
                if ((maxNumber/variable1) < otherNumber) {
                    variable2 = generateNumber(maxNumber/variable1);
                } else {
                    variable2 = generateNumber(otherNumber);
                }
                break;

            case DIV:
                variable1 = generateNumber(otherNumber);
                if ((maxNumber/variable1) < otherNumber) {
                    variable2 = generateNumber(maxNumber/variable1);
                } else {
                    variable2 = generateNumber(otherNumber);
                }
                variable1 *= variable2;
                break;

            default:
                variable1 = 888;
                variable2 = 888;
                break;
        }
    }

    void generateFakeResults(boolean plus, boolean minus, boolean times, boolean div) {

    }


    // numbers generator (1 ... maxNumber)
    private int generateNumber(int maxNumber) {
        Random random = new Random();
        return random.nextInt(maxNumber)+1;
    }
}
