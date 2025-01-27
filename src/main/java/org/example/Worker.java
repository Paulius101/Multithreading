package org.example;

import java.util.List;

public class Worker implements Runnable {
    private List<Integer> numberArray;
    private List<Integer> resultArray;

    public Worker(List<Integer> numberArray, List<Integer> resultArray) {
        this.numberArray = numberArray;
        this.resultArray = resultArray;
    }

    public synchronized void toSquare() {
        for (int i = 0; i < numberArray.size(); i++) {
            int number = numberArray.get(i);
            numberArray.set(i, number * number);
        }
    }

    @Override
    public void run() {
        toSquare();
        resultArray.addAll(numberArray);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "resultArray=" + resultArray +
                '}';
    }

    public List<Integer> getResultArray() {
        return resultArray;
    }
}
