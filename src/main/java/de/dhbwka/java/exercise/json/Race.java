package de.dhbwka.java.exercise.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Race {
    public static void main(String[] args) {
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(json.toJson(new de.dhbwka.java.exercise.classes.vehicles.Race()));
    }
}
