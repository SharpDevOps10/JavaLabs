package com.daniorerio;

import java.util.Scanner;

public class SuperPrimeCounter {
    public static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static int reverseNumber(int number) {
        int reversed = 0;
        while (number > 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        return reversed;
    }

    public static int countSuperPrimes(int limit) {
        int superPrimesCounter = 0;
        for (int i = 2; i <= limit; i++) {
            if (isPrime((i))) {
                int reversed = reverseNumber(i);
                if (isPrime(reversed)) {
                    superPrimesCounter++;
                }
            }
        }
        return superPrimesCounter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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