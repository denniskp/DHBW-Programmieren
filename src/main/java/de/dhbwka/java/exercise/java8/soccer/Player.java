package de.dhbwka.java.exercise.java8.soccer;

public record Player(int number, String name, String position, String birthday, String club, int games, int goals) {
    @Override
    public String toString() {
        return String.format("Number: %d; Name: %s; Position: %s; Birthday: %s;" +
                "Club: %s; Games: %d; Goals: %d", number, name, position, birthday, club, games, goals);
    }
}
