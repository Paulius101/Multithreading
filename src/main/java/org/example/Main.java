package org.example;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws InterruptedException {
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
        ArrayList<Integer> resultList = new ArrayList<>();


        Worker worker1 = new Worker(arrayList.subList(0, 3), resultList);
        Worker worker2 = new Worker(arrayList.subList(3, 6), resultList);
        Worker worker3 = new Worker(arrayList.subList(6, arrayList.size()), resultList);

        Thread thread1 = new Thread(worker1);
        Thread thread2 = new Thread(worker2);
        Thread thread3 = new Thread(worker3);

        thread1.start();
        thread1.join();

        thread2.start();
        thread2.join();

        thread3.start();
        thread3.join();

        System.out.println(resultList);

    }
}