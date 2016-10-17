package org.novokrest.hh2.task2;


import org.junit.Assert;
import org.junit.Test;

public class DigitSequenceViewTest {
    @Test
    public void test_Given_DigitSequenceView_Should_CreateDigitSequenceViewAndCheckLength() {
        DigitSequence digitSequence = DigitSequenceImpl.fromStringOfDigits("12345");

        DigitSequenceView subsequence = new DigitSequenceView(digitSequence, 0, digitSequence.length());

        Assert.assertEquals(digitSequence.length(), subsequence.length());
    }
}
