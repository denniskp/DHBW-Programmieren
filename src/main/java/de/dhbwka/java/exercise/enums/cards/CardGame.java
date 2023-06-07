package de.dhbwka.java.exercise.enums.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardGame {
    private final List<PlayingCard> cards = new ArrayList<>();

    public CardGame() {
        for (int i = 0; i < Suit.values().length; i++) {
            for (int j = 0; j < CardValue.values().length; j++) {
                cards.add(new PlayingCard(Suit.values()[i], CardValue.values()[j]));
            }
        }
    }

    public List<PlayingCard> all() {
        return cards;
    }

    public PlayingCard get() {
        PlayingCard card = cards.get(cards.size() - 1);
        cards.remove(card);
        return card;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void sort() {
        Collections.sort(cards);
    }

    public static void main(String[] args) {
        CardGame cardGame = new CardGame();
        PlayingCard heart7 = new PlayingCard(Suit.HEART, CardValue.SEVEN);

        cardGame.shuffle();
        System.out.println(cardGame.all());

        for (int i = 0; i < 10; i++) {
            PlayingCard card = cardGame.get();
            System.out.printf("%s (Compared to %s: %d)\n", card, heart7, card.compareTo(heart7));
        }

        cardGame.sort();
        System.out.println(cardGame.all());
    }
}
