package de.dhbwka.java.exercise.enums.cards;

public enum Suit {
    DIAMONDS("Karo"),
    HEART("Herz"),
    SPADE("Pik"),
    CLUBS("Kreuz");

    private final String name;

    Suit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
