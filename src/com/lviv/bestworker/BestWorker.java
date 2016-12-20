package com.lviv.bestworker;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class BestWorker implements Runnable {
    private static final Scanner scanner = new Scanner(System.in);
    private String nameOfFile;
    private long timeOfWork;


    public BestWorker(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }

    public long getTimeOfWork() {
        return timeOfWork;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long start1 = System.currentTimeMillis();
        copyFilesFromInDirectoryToOtherDirectory();
        findWord();
        timeOfWork = System.currentTimeMillis() - start1;
        System.out.println("Work time of " + Thread.currentThread().getName() + " is " + timeOfWork);
        deleteFile();
    }

    void findWord() {

        Path path = Paths.get("./" + nameOfFile + ".txt");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String word = "Jingle";

            String line = null;
            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    String s = st.nextToken();
                    if (s.equals(word)) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * The method allows to copy the file.
     */
    public void copyFilesFromInDirectoryToOtherDirectory() {
        try {
            Files.copy(Paths.get("./Story.txt"), Paths.get("./" + nameOfFile + ".txt"), REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * The method allows to delete a file.
     */
    public void deleteFile() {
        try {
            Files.delete(Paths.get("./" + nameOfFile + ".txt"));
            System.out.println("Source file delete successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String getInfo(String string) {
        System.out.println(string);
        return scanner.next();
    }
}
