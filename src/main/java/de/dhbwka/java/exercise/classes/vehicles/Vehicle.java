package de.dhbwka.java.exercise.classes.vehicles;

public class Vehicle {
    private final int wheels;
    private final double maxVelocity; // km/h
    private double position;
    private double velocity; // km/h

    public Vehicle() {
        this(0, 0.0, 0.0, 0.0);
    }

    public Vehicle(int wheels, double maxVelocity, double position, double velocity) {
        this.wheels = wheels;
        this.maxVelocity = maxVelocity;
        this.position = position;
        setSpeed(velocity);
    }

    private double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }

    public void setSpeed(double speed) {
        speed = clamp(speed, 0, maxVelocity);
        velocity = speed;
    }

    public void drive(double minutes) {
        position += velocity * (minutes / 60);
    }

    @Override
    public String toString() {
        return String.format("%s at position %.2f km with %d wheels at speed %.2f km/h of max. %.2f km/h.",
                getClass().getSimpleName(), position, wheels, velocity, maxVelocity);
    }
}
