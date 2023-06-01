package de.dhbwka.java.exercise.collections.gas;

public record GasPrices(double diesel, double superE5, double superE10) {
    @Override
    public String toString() {
        return String.format("Diesel: %.2f, SuperE5: %.2f, SuperE10: %.2f", diesel, superE5, superE10);
    }
}
