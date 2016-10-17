package org.novokrest.hh2.task2;


import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class NaturalNumberSequenceAnalyzerTest {

    @Test
    public void test_Given_Number_Should_ComputeStartIndexOfNumberInSequence() {
        test_Given_Number_Should_ComputeStartIndexOfNumberInSequence("1", 1);
        test_Given_Number_Should_ComputeStartIndexOfNumberInSequence("6", 6);
        test_Given_Number_Should_ComputeStartIndexOfNumberInSequence("10", 10);
        test_Given_Number_Should_ComputeStartIndexOfNumberInSequence("20", 30);
        test_Given_Number_Should_ComputeStartIndexOfNumberInSequence("21", 32);
    }

    private void test_Given_Number_Should_ComputeStartIndexOfNumberInSequence(String number, long expectedStartIndex) {
        test_Given_Number_Should_ComputeStartIndexOfNumberInSequence(number, BigInteger.valueOf(expectedStartIndex));
    }

    private void test_Given_Number_Should_ComputeStartIndexOfNumberInSequence(String number, BigInteger expectedStartIndex) {
        BigInteger actualStartIndex = new NaturalNumberSequenceAnalyzer().getStartIndex(number);
        Assert.assertEquals(expectedStartIndex, actualStartIndex);
    }
}
