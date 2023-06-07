package de.dhbwka.java.exercise.enums.cards;

public enum CardValue {
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("Bube"),
    QUEEN("Dame"),
    KING("König"),
    ACE("Ass");

    private final String name;

    CardValue(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
