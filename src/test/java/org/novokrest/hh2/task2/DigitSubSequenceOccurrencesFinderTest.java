package org.novokrest.hh2.task2;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DigitSubSequenceOccurrencesFinderTest {

    @Test
    public void test_Given_DigitSequenceAndSubSequence_Should_FindOccurrencesOfSubSequence() {
        check("123", "2", 1);
        check("123", "4");
        check("122", "2", 1, 2);
        check("222222", "22", 0, 1, 2, 3, 4, 5);
    }

    private void check(String digitSequenceString, String digitSubSequenceString, Integer... expectedOccurrences) {
        check(digitSequenceString, digitSubSequenceString, new ArrayList<>(Arrays.asList(expectedOccurrences)));
    }

    private void check(String digitSequenceString, String digitSubSequenceString, List<Integer> expectedOccurrences) {
        DigitSequence digitSequence = DigitSequenceImpl.fromStringOfDigits(digitSequenceString);
        DigitSequence digitSubSequence = DigitSequenceImpl.fromStringOfDigits(digitSubSequenceString);

        DigitSubSequenceOccurrencesFinder finder = new DigitSubSequenceOccurrencesFinder(digitSequence);
        List<Integer> actualOccurrences = finder.findOccurrences(digitSubSequence);

        Assert.assertEquals(expectedOccurrences, actualOccurrences);
    }

    private String createNaturalNumberSequenceString(int startNumber, int stopNumber) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = startNumber; i < stopNumber; i ++) {
            stringBuilder.append(i);
        }

        return stringBuilder.toString();
    }
}
