package de.dhbwka.java.exercise.classes;

import java.util.Scanner;

public class Nimmspiel {
    private final Scanner scanner = new Scanner(System.in);
    private final String playerName1;
    private final String playerName2;
    private int heap1;
    private int heap2;
    private int playerIdx;

    public Nimmspiel(String playerName1, String playerName2) {
        this.playerName1 =  playerName1;
        this.playerName2 = playerName2;
        heap1 = generateRandomHeap();
        heap2 = generateRandomHeap();
        playerIdx = getRandomPlayerIdx();
    }

    private int getRandomPlayerIdx() {
        return Math.random() < 0.5 ? 0 : 1;
    }

    private void nextTurn() {
        playerIdx = (playerIdx + 1) % 2;
    }

    private int generateRandomHeap() {
        return (int)(Math.random() * 20) + 1;
    }

    private boolean areHeapsEmpty() {
        return (heap1 <= 0) && (heap2 <= 0);
    }

    private void playerTurn() {
        String currentPlayerName = playerIdx == 0 ? playerName1 : playerName2;

        // Get heap
        int heapChoice;
        while (true) {
            System.out.printf("Spieler %s: Von welchem Haufen ziehen Sie Kugeln? ", currentPlayerName);
            try {
                int heap = scanner.nextInt();
                if (((heap == 1) && (heap1 > 0)) || ((heap == 2) && (heap2 > 0))) {
                    heapChoice = heap;
                    break;
                }
            } catch (Exception ignored) {
                scanner.nextLine();
            }
        }

        // Get amount
        while (true) {
            System.out.printf("Spieler %s: Wie viele Kugeln ziehen Sie? ", currentPlayerName);
            try {
                int take = scanner.nextInt();
                if (take > 0) {
                    if (((heapChoice == 1) && (take <= heap1)) || ((heapChoice == 2) && (take <= heap2))) {
                        if (heapChoice == 1) {
                            heap1 -= take;
                        } else {
                            heap2 -= take;
                        }
                        break;
                    }
                }
            } catch (Exception ignored) {
                scanner.nextLine();
            }
        }
    }

    public void play() {
        while (true) {
            System.out.println(this);
            playerTurn();
            if (areHeapsEmpty()) {
                System.out.println("Spiel beendet.");
                System.out.printf("Gewonnen hat Spieler %s\n", playerIdx == 0 ? playerName1 : playerName2);
                break;
            }
            nextTurn();
        }
    }

    @Override
    public String toString() {
        return String.format("Spieler: %s und %s, Haufen 1: %d Kugel(n), Haufen 2: %d Kugel(n)", playerName1, playerName2, heap1, heap2);
    }

    public static void main(String[] args) {
        Nimmspiel game = new Nimmspiel("Max", "Moritz");
        game.play();
    }
}
