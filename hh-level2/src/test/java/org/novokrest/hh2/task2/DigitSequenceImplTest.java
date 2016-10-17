package org.novokrest.hh2.task2;

import org.junit.Assert;
import org.junit.Test;


public class DigitSequenceImplTest {

    @Test
    public void test_Given_TwoDigitSequence_Should_CheckFirstStartsWithSecond() {
        test_Given_TwoDigitSequence_Should_CheckFirstStartsWithSecond("12345", "12345", true);
        test_Given_TwoDigitSequence_Should_CheckFirstStartsWithSecond("12345", "123", true);
        test_Given_TwoDigitSequence_Should_CheckFirstStartsWithSecond("12345", "1", true);
        test_Given_TwoDigitSequence_Should_CheckFirstStartsWithSecond("1", "1", true);
        test_Given_TwoDigitSequence_Should_CheckFirstStartsWithSecond("1", "12", true);
        test_Given_TwoDigitSequence_Should_CheckFirstStartsWithSecond("1", "12345", true);

        test_Given_TwoDigitSequence_Should_CheckFirstStartsWithSecond("1", "2", false);
        test_Given_TwoDigitSequence_Should_CheckFirstStartsWithSecond("1", "21", false);
        test_Given_TwoDigitSequence_Should_CheckFirstStartsWithSecond("12", "2", false);
        test_Given_TwoDigitSequence_Should_CheckFirstStartsWithSecond("12345", "2", false);
        test_Given_TwoDigitSequence_Should_CheckFirstStartsWithSecond("12345", "234567", false);
    }

    private void test_Given_TwoDigitSequence_Should_CheckFirstStartsWithSecond(String firstDigitSequenceString,
                                                                               String secondDigitSequenceString,
                                                                               boolean expected) {
        DigitSequence firstDigitSequence = DigitSequenceImpl.fromStringOfDigits(firstDigitSequenceString);
        DigitSequence secondDigitSequence = DigitSequenceImpl.fromStringOfDigits(secondDigitSequenceString);

        boolean actual = DigitSequenceEx.startsWith(firstDigitSequence, secondDigitSequence);

        Assert.assertTrue(expected == actual);
    }
}
