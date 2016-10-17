package org.novokrest.hh2.task2;


import org.junit.Assert;
import org.junit.Test;

public class NaturalNumberSequenceCheckerTest {
    @Test
    public void test_Given_StartNumberAndDigitSequence_Should_CheckFollowingSequenceCorrect() {
        Assert.assertTrue(test_Given_StartNumberAndDigitSequence_Should_CheckFollowingSequenceCorrect("6", "7891011"));
        Assert.assertFalse(test_Given_StartNumberAndDigitSequence_Should_CheckFollowingSequenceCorrect("6", "67891011"));
        Assert.assertTrue(test_Given_StartNumberAndDigitSequence_Should_CheckFollowingSequenceCorrect("7", "89"));
    }

    private boolean test_Given_StartNumberAndDigitSequence_Should_CheckFollowingSequenceCorrect(String number, String digitString) {
        NaturalNumber naturalNumber = NaturalNumber.fromDigitSequence(DigitSequenceImpl.fromStringOfDigits(number));

        NaturalNumberSequenceChecker checker = new NaturalNumberSequenceChecker(naturalNumber,
                                                                                DigitSequenceImpl.fromStringOfDigits(digitString));
        return checker.check();
    }
}
