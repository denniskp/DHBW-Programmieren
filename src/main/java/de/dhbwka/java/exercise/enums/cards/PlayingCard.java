package de.dhbwka.java.exercise.enums.cards;

public record PlayingCard(Suit suit, CardValue cardValue) implements Comparable<PlayingCard> {
    @Override
    public int compareTo(PlayingCard c) {
        int suitCompare = Integer.compare(suit.ordinal(), c.suit().ordinal());
        return suitCompare == 0 ? Integer.compare(cardValue.ordinal(), c.cardValue.ordinal()) : suitCompare;
    }

    @Override
    public String toString() {
        return String.format("%s %s", suit.getName(), cardValue.getName());
    }
}
