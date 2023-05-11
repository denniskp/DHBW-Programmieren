package de.dhbwka.java.exercise.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class PrimesFile {
    public static void main(String[] args) throws IOException {
        int[] sieve = IntStream.rangeClosed(2, 99999).toArray();
        BufferedWriter writer = new BufferedWriter(new FileWriter("IOTest/primes.txt"));

        while (Arrays.stream(sieve).asLongStream().sum() > 0) {
            // Get smallest number min in sieve
            int min = Arrays.stream(sieve).filter(n -> n != 0).findFirst().orElse(0);

            // Add min to primes
            writer.write(min + "\n");

            // Remove min from sieve
            for (int i = 0; i < sieve.length; ++i) {
                if (sieve[i] == 0)
                    continue;
                if (sieve[i] % min == 0)
                    sieve[i] = 0;
            }
        }

        // Flush and close
        writer.close();
    }
}
