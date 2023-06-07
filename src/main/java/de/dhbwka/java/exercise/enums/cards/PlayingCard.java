package de.dhbwka.java.exercise.enums.cards;

public record PlayingCard(Suit suit, CardValue cardValue) implements Comparable<PlayingCard> {
    @Override
    public int compareTo(PlayingCard c) {
        int valueCompare = Integer.compare(cardValue.ordinal(), c.cardValue().ordinal());
        return valueCompare == 0 ? Integer.compare(suit.ordinal(), c.suit().ordinal()) : valueCompare;
    }

    @Override
    public String toString() {
        return String.format("%s %s", suit.getName(), cardValue.getName());
    }
}
