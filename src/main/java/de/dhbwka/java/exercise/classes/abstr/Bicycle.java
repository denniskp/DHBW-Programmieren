package de.dhbwka.java.exercise.classes.abstr;

public class Bicycle extends Vehicle {
    private final int wheels;
    private final double maxVelocity; // km/h
    private double position;
    private double velocity; // km/h

    public Bicycle() {
        this(0, 0.0, 0.0, 0.0);
    }

    public Bicycle(double velocity) {
        this(2, 30.0, 0.0, velocity);
    }

    public Bicycle(int wheels, double maxVelocity, double position, double velocity) {
        this.wheels = wheels;
        this.maxVelocity = maxVelocity;
        this.position = position;
        setSpeed(velocity);
    }

    @Override
    public void setSpeed(double speed) {
        speed = super.clamp(speed, 0, maxVelocity);
        velocity = speed;
    }

    @Override
    public void drive(double minutes) {
        position += velocity * (minutes / 60);
    }

    @Override
    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("%s at position %.2f km with %d wheels at speed %.2f km/h of max. %.2f km/h.",
                getClass().getSimpleName(), position, wheels, velocity, maxVelocity);
    }
}
