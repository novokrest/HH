package org.novokrest.hh2.task2;


import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class DigitStringFirstOccurrencesFinderTest {
    @Test
    public void test_Given_DigitString_Should_FindFirstOccurrenceAndCheck() {
        test_Given_DigitString_Should_FindFirstOccurrenceAndCheck("1", 1);
        test_Given_DigitString_Should_FindFirstOccurrenceAndCheck("7", 7);
        test_Given_DigitString_Should_FindFirstOccurrenceAndCheck("10", 10);
        test_Given_DigitString_Should_FindFirstOccurrenceAndCheck("6789", 6);
        test_Given_DigitString_Should_FindFirstOccurrenceAndCheck("111", 12);
        test_Given_DigitString_Should_FindFirstOccurrenceAndCheck("131", 16);
        test_Given_DigitString_Should_FindFirstOccurrenceAndCheck("20", 30);
    }

    private void test_Given_DigitString_Should_FindFirstOccurrenceAndCheck(String digitString, int expectedFirstOccurrence) {
        test_Given_DigitString_Should_FindFirstOccurrenceAndCheck(digitString, BigInteger.valueOf(expectedFirstOccurrence));
    }

    private void test_Given_DigitString_Should_FindFirstOccurrenceAndCheck(String digitString, BigInteger expectedFirstOccurrence) {
        DigitStringFirstOccurrenceFinder finder = new DigitStringFirstOccurrenceFinder();

        BigInteger actualFirstOccurrence = finder.findFirstOccurrence(digitString);

        Assert.assertEquals(expectedFirstOccurrence, actualFirstOccurrence);
    }

    @Test
    public void test_Given_DigitString_Should_FindFirstOccurrence() {
        DigitSequenceGenerator generator = new DigitSequenceGenerator();
        DigitStringFirstOccurrenceFinder finder = new DigitStringFirstOccurrenceFinder();

        for (int i = 0; i < 10000; i++) {
            String digitSequence = generator.generate(50);
            finder.findFirstOccurrence(digitSequence);
        }
    }
}
