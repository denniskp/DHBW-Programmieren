package de.dhbwka.java.exercise.classes.abstr;

public class Car extends Vehicle{
    public Car(double velocity) {
        super(4, 140.0, 0.0, velocity);
    }

    public Car(double maxVelocity, double velocity) {
        super(4, maxVelocity, 0.0, velocity);
    }

    @Override
    public void info() {
        System.out.println(this);
    }
}
