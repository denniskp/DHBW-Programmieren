package de.dhbwka.java.exercise.classes;

import java.util.*;

class AttemptResult extends AbstractMap.SimpleEntry<Integer, Integer> {
    public AttemptResult(Integer nCorrect, Integer nSimilar) {
        super(nCorrect, nSimilar);
    }
}

class Attempt extends AbstractMap.SimpleEntry<String, AttemptResult> {
    public Attempt(String attempt, AttemptResult attemptResult) {
        super(attempt, attemptResult);
    }
}

// #typedef AbstractMap.SimpleEntry<String, AbstractMap.SimpleEntry<Integer, Integer>> Attempt

public class MasterMind {
    private static final int MIN_STRING_RANGE = 0x41;
    private static final int MAX_STRING_RANGE = 0x48;
    private static final int MAX_STRING_LENGTH = 5;
    private static final int MAX_ATTEMPTS = 20;

    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);

    public void play() {
        do {
            String randomString = generateRandomString();
            System.out.println(randomString);

            int amountAttempts = 0;
            List<Attempt> attempts = new ArrayList<>();

            do {
                amountAttempts++;

                System.out.print("Submit you tip: ");
                String tip = scanner.next().toUpperCase();
                tip = tip.substring(0, Math.min(tip.length(), MAX_STRING_LENGTH));
                tip = String.format("%-" + MAX_STRING_LENGTH + "s", tip);
                tip = tip.replace(' ', 'A');

                if (tip.equalsIgnoreCase(randomString)) {
                    System.out.printf("You won with %d guesses!\n", amountAttempts);
                    break;
                } else if (amountAttempts >= MAX_ATTEMPTS) {
                    System.out.printf("You were not able to guess %s after %d attempts!\n", randomString, MAX_ATTEMPTS);
                    break;
                }

                AttemptResult currentAttemptResult = getCorrectAndSimilar(tip, randomString);
                Attempt currentAttempt = new Attempt(tip, currentAttemptResult);
                attempts.add(currentAttempt);

                System.out.printf("%d previous attempts:\n", amountAttempts);
                for (Attempt attempt : attempts) {
                    AttemptResult attemptResult = attempt.getValue();
                    System.out.printf("%s %d %d\n", attempt.getKey(), attemptResult.getKey(), attemptResult.getValue());
                }

                System.out.println();
            } while (true);

            System.out.println("(C)ontinue playing");
            System.out.println("(E)xit");
            System.out.print("--> ");
        } while (scanner.next().equalsIgnoreCase("c"));
    }

    private AttemptResult getCorrectAndSimilar(String attempt, String random) {
        boolean[] checked = new boolean[MAX_STRING_LENGTH];
        boolean[] used = new boolean[MAX_STRING_LENGTH];
        int nCorrect = 0;
        int nSimilar = 0;

        // Get correct letters
        for (int i = 0; i < MAX_STRING_LENGTH; i++) {
            if (attempt.charAt(i) == random.charAt(i)) {
                nCorrect++;
                checked[i] = true;
                used[i] = true;
            }
        }

        // Get letters on bad position
        for (int i = 0; i < MAX_STRING_LENGTH; i++) {
            for (int j = 0; j < MAX_STRING_LENGTH; j++) {
                if ((i == j) || (used[i]) || (checked[j])) {
                    continue;
                } else if ((attempt.charAt(i) == random.charAt(j)) && (!checked[j])) {
                    nSimilar++;
                    checked[j] = true;
                    break;
                }
            }
        }

        return new AttemptResult(nCorrect, nSimilar);
    }

    private String generateRandomString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MAX_STRING_LENGTH; i++) {
            char randomChar = (char) random.nextInt(MIN_STRING_RANGE, MAX_STRING_RANGE + 1);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MasterMind game = new MasterMind();
        game.play();
    }
}
