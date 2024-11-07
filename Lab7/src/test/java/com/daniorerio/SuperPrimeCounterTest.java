package com.daniorerio;

import org.junit.jupiter.api.Test;

import static com.daniorerio.SuperPrimeCounter.*;
import static org.junit.jupiter.api.Assertions.*;

public class SuperPrimeCounterTest {

    @Test
    public void testIsPrime() {
        assertTrue(isPrime.test(2));
        assertTrue(isPrime.test(3));
        assertFalse(isPrime.test(4));
        assertTrue(isPrime.test(29));
        assertFalse(isPrime.test(1));
        assertFalse(isPrime.test(0));
        assertFalse(isPrime.test(-7));
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