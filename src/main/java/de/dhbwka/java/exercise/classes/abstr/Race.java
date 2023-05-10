package de.dhbwka.java.exercise.classes.abstr;

import de.dhbwka.java.exercise.classes.abstr.Vehicle;
import de.dhbwka.java.exercise.classes.abstr.Bicycle;
import de.dhbwka.java.exercise.classes.abstr.Ambulance;
import de.dhbwka.java.exercise.classes.abstr.Car;
import de.dhbwka.java.exercise.classes.abstr.RacingCar;

public class Race {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[4];
        vehicles[0] = new Bicycle(20.0);
        vehicles[1] = new Car(150.0);
        vehicles[2] = new RacingCar(200.0);
        vehicles[3] = new Ambulance(80.0, true);
        // 4 hours lead for the bike
        vehicles[0].drive(240.0);
        // 1 hour of driving for everyone
        for (Vehicle vehicle : vehicles) {
            vehicle.drive(60);
        }
        // Output Race
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}
