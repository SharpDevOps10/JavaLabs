package com.daniorerio;

import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class SuperPrimeCounter {

    public static final IntPredicate isPrime = number -> {
        if (number < 2) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(i -> number % i == 0);
    };

    public static int reverseNumber(int number) {
        return Integer.parseInt(new StringBuilder(String.valueOf(number)).reverse().toString());
    }

    public static int countSuperPrimes(int limit) {
        return (int) IntStream.rangeClosed(2, limit)
                .filter(i -> isPrime.test(i) && isPrime.test(reverseNumber(i)))
                .count();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a natural number not greater than 1000: ");
            int limit = scanner.nextInt();

            if (limit > 1000 || limit < 1) {
                System.out.println("The number must be in the range from 1 to 1000!");
            } else {
                int result = countSuperPrimes(limit);
                System.out.println("The number of super primes is: " + result);
            }
        }
    }
}