package de.dhbwka.java.exercise.control;

public class ShoeSize {
    public static double sizeToCm(int size) {
        return size / 1.5;
    }

    public static void main(String[] args) {
        System.out.println("Zentimeter | Größe");
        System.out.println("-----------+------");
        for (int i = 30; i <= 49; ++i) {
            String resLower = String.format("%.2f", sizeToCm(i - 1));
            String resUpper = String.format("%.2f", sizeToCm(i));
            System.out.println(resLower + " - " + resUpper + " | " + i);
        }
    }
}
