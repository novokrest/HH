package org.novokrest.hh2.task2;

import org.junit.Assert;
import org.junit.Test;


public class DigitSequenceTest {

    @Test
    public void test_Given_StringOfDigits_Should_CreateDigitSequence() {
        String stringOfDigits = "0123456789876543210";
        DigitSequence expectedDigitSequence = new DigitSequenceImpl(stringOfDigits);

        DigitSequence actualDigitSequence = DigitSequenceImpl.fromStringOfDigits(stringOfDigits);

        Assert.assertEquals(expectedDigitSequence, actualDigitSequence);
    }

    @Test
    public void test_Given_DigitSequence_Should_GetNextDigitSequence() {
        test_Given_DigitSequence_Should_GetNextDigitSequence("0", "1");
        test_Given_DigitSequence_Should_GetNextDigitSequence("00", "01");
        test_Given_DigitSequence_Should_GetNextDigitSequence("1", "2");
        test_Given_DigitSequence_Should_GetNextDigitSequence("01", "02");
        test_Given_DigitSequence_Should_GetNextDigitSequence("11", "12");
        test_Given_DigitSequence_Should_GetNextDigitSequence("011", "012");
        test_Given_DigitSequence_Should_GetNextDigitSequence("9", "10");
        test_Given_DigitSequence_Should_GetNextDigitSequence("09", "10");
        test_Given_DigitSequence_Should_GetNextDigitSequence("19", "20");
        test_Given_DigitSequence_Should_GetNextDigitSequence("019", "020");
        test_Given_DigitSequence_Should_GetNextDigitSequence("99", "100");
        test_Given_DigitSequence_Should_GetNextDigitSequence("099", "100");
        test_Given_DigitSequence_Should_GetNextDigitSequence("0099", "0100");
    }

    private void test_Given_DigitSequence_Should_GetNextDigitSequence(String givenStringOfDigits, String expectedNextStringOfDigits) {
        DigitSequence current = DigitSequenceImpl.fromStringOfDigits(givenStringOfDigits);
        DigitSequence expectedNext = DigitSequenceImpl.fromStringOfDigits(expectedNextStringOfDigits);

        DigitSequence actualNext = DigitSequenceIncrementer.increment(current);

        Assert.assertEquals(expectedNext, actualNext);
    }
}
