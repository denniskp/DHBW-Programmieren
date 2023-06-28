package de.dhbwka.java.exercise.java8.soccer;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Soccer {
    private static URI toUri(URL url) {
        try {
            return url.toURI();
        } catch (URISyntaxException e) {
            return null;
        }
    }

    private static List<Player> getPlayersFromFile(Path resPath) {
        try {
            return Files.readAllLines(resPath).stream()
                    .map(l -> l.split(";"))
                    .filter(l -> l.length == 7)
                    .map(l -> new Player(Integer.parseInt(l[0]), l[1], l[2], l[3], l[4], Integer.parseInt(l[5]), Integer.parseInt(l[6])))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            return null;
        }
    }

    public static int comparePlayerByNumber(Player p1, Player p2) {
        return Integer.compare(p1.number(), p2.number());
    }

    public static int comparePlayerByName(Player p1, Player p2) {
        return p1.name().compareTo(p2.name());
    }

    public static void main(String[] args) {
        URL resUrl = Soccer.class.getClassLoader().getResource("TeamDE.txt");
        if (resUrl == null) {
            System.out.println("The requested file doesn't exist");
            return;
        }

        URI resUri = toUri(resUrl);
        if (resUri == null) {
            System.out.println("The requested file doesn't exist");
            return;
        }

        List<Player> players = getPlayersFromFile(Paths.get(resUri));
        if (players == null) {
            System.out.println("Unable to read contents of the file");
            return;
        }

        players.stream()
                .sorted(Soccer::comparePlayerByNumber)
                .forEach(System.out::println);
        System.out.println();

        players.stream()
                .filter(p -> p.games() > 50)
                .sorted(Soccer::comparePlayerByName)
                .forEach(System.out::println);
        System.out.println();

        players.stream()
                .map(Player::club)
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        long amount = players.stream()
                .filter(p -> p.goals() < 5)
                .count();
        System.out.println(amount);

        int goals = players.stream()
                .mapToInt(Player::goals)
                .sum();
        System.out.println(goals);
    }
}
