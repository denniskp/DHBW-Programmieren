package de.dhbwka.java.exercise.enums.cards;

public enum Suit {
    HEART("Herz"),
    DIAMONDS("Karo"),
    CLUBS("Kreuz"),
    SPADE("Pik");

    private final String name;

    Suit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
