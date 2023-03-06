package de.dhbwka.java.exercise.classes.vehicles;

public class Ambulance extends Car {
    private boolean areBlueLightsOn;

    public Ambulance(double velocity, boolean areBlueLightsOn) {
        super(velocity);
        this.areBlueLightsOn = areBlueLightsOn;
    }

    public void toggleBlueLights() {
        areBlueLightsOn = !areBlueLightsOn;
    }

    @Override
    public String toString() {
        return String.format("%s Signal %s.", super.toString(), areBlueLightsOn ? "on" : "off");
    }
}
