package de.dhbwka.java.exercise.classes.periodic;

public class Metal extends Element {
    private final boolean metalliod;
    private final double conductivity;

    public Metal(String name, String symbol, int ordinal, char shell, int phase, boolean isMainGroup, boolean metalliod, double conductivity) {
        super(name, symbol, ordinal, shell, phase, isMainGroup);
        this.metalliod = metalliod;
        this.conductivity = conductivity;
    }

    public boolean isMetalliod() {
        return metalliod;
    }

    public double getConductivity() {
        return conductivity;
    }

    @Override
    public String toString() {
        return String.format("%s | %-5s | %.2E S/m", super.toString(), metalliod, conductivity);
    }
}
