package org.example;

import java.util.ArrayList;
import java.util.Random;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> resultList = new ArrayList<>();
        ArrayList<Integer> dataList = getDataList();
        Random random = new Random();
        int stepSize = random.nextInt(1, 4);
        int startIndex = 0;
        int endIndex = stepSize;

        int numberOfThreads = dataList.size() / stepSize;
        int dataListSize = dataList.size();
        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(new Worker(getDataList().subList(startIndex, endIndex), resultList));
            thread.start();
            thread.join();
            startIndex += stepSize;
            endIndex += stepSize;
            if (endIndex > dataListSize) endIndex = dataListSize;
            if (startIndex + stepSize > dataListSize - stepSize) startIndex = dataListSize - stepSize;
        }

        System.out.println(resultList);
    }

    private static ArrayList<Integer> getDataList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(4);
        arrayList.add(8);
        arrayList.add(6);
        arrayList.add(1);
        arrayList.add(10);
        arrayList.add(9);
        return arrayList;
    }
}