package de.dhbwka.java.exercise.classes;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private final int drawAmount;
    private final int ballAmount;
    private int[] drawn = null;
    private int[] tip = null;

    public Lotto(int drawAmount, int ballAmount) {
        this.drawAmount = drawAmount;
        this.ballAmount = ballAmount;
    }

    public void tippen(int[] tip) {
        this.tip = Arrays.stream(tip).sorted().toArray();
    }

    public int[] tippen() {
        int[] tip = new int[this.drawAmount];
        for (int i = 0; i < this.drawAmount; i++) {
            while (true) {
                System.out.printf("Geben Sie bitte Ihren Tipp für die %d. Zahl ein: ", i + 1);
                int currTip;
                try {
                    currTip = scanner.nextInt();
                    if ((currTip >= 1) && (currTip <= this.ballAmount)) {
                        tip[i] = currTip;
                        break;
                    }
                } catch (Exception ignored) {
                    scanner.nextLine();
                }
            }
        }
        return tip;
    }

    public void ziehen() {
        int[] drawn = new int[6];
        for (int i = 0; i < this.drawAmount; i++) {
            drawn[i] = random.nextInt(this.ballAmount) + 1;
        }
        this.drawn = Arrays.stream(drawn).sorted().toArray();
    }

    public int richtige() {
        int result = 0;
        for (int i = 0; i < this.drawAmount; i++) {
            if (tip[i] == drawn[i]) {
                result++;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Tipp: ");
        for (int i = 0; i < this.drawAmount; i++) {
            output.append(tip[i]).append(" ");
        }
        if (drawn != null) {
            output.append("\nGezogene Zahlen: ");
            for (int i = 0; i < this.drawAmount; i++) {
                output.append(drawn[i]).append(" ");
            }
        }
        return output.toString();
    }

    public static void main(String[] args) {
        Lotto deutschesLotto = new Lotto(6, 49);
        int[] tip = deutschesLotto.tippen();
        deutschesLotto.tippen(tip);
        System.out.println(deutschesLotto);
        deutschesLotto.ziehen();
        System.out.println(deutschesLotto);
        System.out.printf("Richtige: %d\n", deutschesLotto.richtige());
    }
}
