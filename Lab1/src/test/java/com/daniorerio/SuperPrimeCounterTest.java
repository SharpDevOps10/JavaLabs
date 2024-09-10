package com.daniorerio;

import org.junit.jupiter.api.Test;

import static com.daniorerio.SuperPrimeCounter.*;
import static org.junit.jupiter.api.Assertions.*;

public class SuperPrimeCounterTest {

    @Test
    public void testIsPrime() {
        assertTrue(isPrime(2));
        assertTrue(isPrime(3));
        assertFalse(isPrime(4));
        assertTrue(isPrime(29));
        assertFalse(isPrime(1));
        assertFalse(isPrime(0));
        assertFalse(isPrime(-7));
    }

    @Test
    public void testReverseNumber() {
        assertEquals(321, reverseNumber(123));
        assertEquals(0, reverseNumber(0));
        assertEquals(4891, reverseNumber(1984));
        assertEquals(987654321, reverseNumber(123456789));
    }

    @Test
    public void testCountSuperPrimes() {
        assertEquals(4, countSuperPrimes(8));
        assertEquals(13, countSuperPrimes(100));
        assertEquals(0, countSuperPrimes(1));
        assertEquals(25, countSuperPrimes(200));
        assertEquals(25, countSuperPrimes(300));
        assertEquals(56, countSuperPrimes(1000));
    }
}
