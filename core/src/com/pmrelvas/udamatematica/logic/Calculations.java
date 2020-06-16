package com.pmrelvas.udamatematica.logic;

import com.badlogic.gdx.Gdx;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Calculations {

    private static Calculations instance;

    private final int RESULT_LIST_SIZE = 4;
    private final int SUM_BOUND = 10;

    private List<Integer> results;
    private Integer operandA;
    private Integer operandB;
    private Operator operator;
    private int resultIdx;

    private Calculations() {
        results = Arrays.asList(new Integer[RESULT_LIST_SIZE]);
        Gdx.app.log("results", results.toString());
    }

    public static Calculations getInstance() {
        if (instance == null) {
            instance = new Calculations();
        }
        return instance;
    }

    public int getResultIdx() {
        return resultIdx;
    }

    public void buildGameResults() {
        Random random = new Random();
        operandA = random.nextInt(SUM_BOUND);
        operandB = random.nextInt(SUM_BOUND);
        operator = Operator.SUM;
        resultIdx = random.nextInt(RESULT_LIST_SIZE);
        int expectedResult = operandA + operandB;

        results = Arrays.asList(new Integer[RESULT_LIST_SIZE]);
        for (int i = 0; i < RESULT_LIST_SIZE; i++) {
            int result;
            if (i == resultIdx) {
                result = expectedResult;
            } else {
                do {
                    result = random.nextInt(SUM_BOUND) + random.nextInt(SUM_BOUND);
                } while (results.contains(result));
            }
            results.set(i, result);
        }

        // debug
        Gdx.app.log("operandA", operandA.toString());
        Gdx.app.log("operandB", operandB.toString());
        Gdx.app.log("resultIdx", String.valueOf(resultIdx));
        Gdx.app.log("results", results.toString());
    }

    public List<Integer> getResults() {
        return results;
    }

    public String getOperationStr() {
        return operandA.toString() + operator.toString() + operandB.toString();
    }
}
