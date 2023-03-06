package de.dhbwka.java.exercise.classes.vehicles;

public class Car extends Vehicle{
    public Car(double velocity) {
        super(4, 140.0, 0.0, velocity);
    }

    public Car(double maxVelocity, double velocity) {
        super(4, maxVelocity, 0.0, velocity);
    }
}
