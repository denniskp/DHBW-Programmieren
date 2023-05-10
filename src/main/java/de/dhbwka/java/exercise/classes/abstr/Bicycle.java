package de.dhbwka.java.exercise.classes.abstr;

public class Bicycle extends Vehicle {
    public Bicycle(double velocity) {
        super(2, 30.0, 0.0, velocity);
    }

    @Override
    public void info() {
        System.out.println(this);
    }
}
