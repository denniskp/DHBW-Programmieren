package de.dhbwka.java.exercise.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Lottery {
    private static final int AMOUNT_NUMBERS = 7;
    private final Random random = new Random();
    private final ArrayList<Integer> numbers = new ArrayList<>();

    public void draw() {
        numbers.clear();
        while (numbers.size() != AMOUNT_NUMBERS) {
            int randNumber = random.nextInt(49) + 1;
            if (!numbers.contains(randNumber)) {
                numbers.add(randNumber);
            }
        }
        Collections.sort(numbers.subList(0, AMOUNT_NUMBERS - 1));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < AMOUNT_NUMBERS - 1; i++) {
            sb.append(String.format("%d ", numbers.get(i)));
        }
        sb.append(String.format("Zusatzzahl: %d", numbers.get(AMOUNT_NUMBERS - 1)));
        return sb.toString();
    }

    public static void main(String[] args) {
        Lottery lottery = new Lottery();
        lottery.draw();
        System.out.println(lottery);
    }
}
