package com.lviv.bestworker;

import java.util.ArrayList;
import java.util.List;

/**
 * На предприятии имеется 5 рабочих. Необходимо им поручить задание считать один
 * и тот же файл(Story.txt) и найти в нем одно слово и вывести время, которое потратил каждый работник.
 * Для каждого потока взять копию файла, чтобы избежать блокировки потоков.
 * Копию файла для себя делает каждый поток сам.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("<<<<<<GO!!!>>>>>>>>");
        List<Long> listResults = new ArrayList<>();
        BestWorker bestWorker1 = new BestWorker("Worker#1");
        BestWorker bestWorker2 = new BestWorker("Worker#2");
        BestWorker bestWorker3 = new BestWorker("Worker#3");
        BestWorker bestWorker4 = new BestWorker("Worker#4");
        BestWorker bestWorker5 = new BestWorker("Worker#5");

        Thread thread1 = new Thread(bestWorker1);
        thread1.setName("Worker#1");
        Thread thread2 = new Thread(bestWorker2);
        thread2.setName("Worker#2");
        Thread thread3 = new Thread(bestWorker3);
        thread3.setName("Worker#3");
        Thread thread4 = new Thread(bestWorker4);
        thread4.setName("Worker#4");
        Thread thread5 = new Thread(bestWorker5);
        thread5.setName("Worker#5");
        thread1.start();
        thread1.join();
        listResults.add(bestWorker1.getTimeOfWork());
        thread2.start();
        thread2.join();
        listResults.add(bestWorker2.getTimeOfWork());
        thread3.start();
        thread3.join();
        listResults.add(bestWorker3.getTimeOfWork());
        thread4.start();
        thread4.join();
        listResults.add(bestWorker4.getTimeOfWork());
        thread5.start();
        thread5.join();
        listResults.add(bestWorker5.getTimeOfWork());

        Long bestTime = listResults.stream().min(Long::compare).get();
        System.out.println("Best time is " + bestTime);
    }
}
