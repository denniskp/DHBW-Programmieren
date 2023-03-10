package de.dhbwka.java.exercise.control;

public class TemperatureTable {
    public static double fahrenheitToCelsius(int fahrenheit) {
        return (5. / 9) * (fahrenheit - 32);
    }

    public static void main(String[] args) {
        System.out.println("Fahrenheit | Celsius");
        System.out.println("-----------+--------");
        for (int i = 0; i <= 300; i += 20) {
            double result = fahrenheitToCelsius(i);
            System.out.printf("%d | %.2f \n", i, result);
        }
    }
}
