package de.dhbwka.java.exercise.io;

import java.io.File;
import java.io.IOException;

public class FileExperiments {
    public static void main(String[] args) {
        File dir = new File("myDir");
        dir.mkdir();

        File foo1 = new File(dir, "foo1");
        try {
            foo1.createNewFile();
        } catch (IOException ex) {
            System.out.println("Unable to create file foo1.");
            return;
        }

        File foo2 = new File(dir, "foo2");
        try {
            foo2.createNewFile();
        } catch (IOException ex) {
            System.out.println("Unable to create file foo2.");
            return;
        }

        File foo3 = new File(dir, "foo3");
        try {
            foo3.createNewFile();
        } catch (IOException ex) {
            System.out.println("Unable to create file foo3.");
            return;
        }

        System.out.printf("Absolute path: %s\n", dir.getAbsolutePath());
        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("The directory myDir is empty.");
            return;
        }

        System.out.println("Contents of myDir:");
        for (File f : files) {
            System.out.println(f.getName());
            f.delete();
        }

        dir.delete();
    }
}
