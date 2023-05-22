package de.dhbwka.java.exercise.classes.abstr;

public abstract class Vehicle {
    public double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }

    public abstract void setSpeed(double speed);
    public abstract void drive(double minutes);
    public abstract void info();

    @Override
    public abstract String toString();
}
