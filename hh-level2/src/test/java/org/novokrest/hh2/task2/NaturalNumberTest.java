package org.novokrest.hh2.task2;


import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class NaturalNumberTest {
    @Test
    public void test_Given_DigitString_Should_GetNaturalNumberValue() {
        test_Given_DigitString_Should_GetNaturalNumberValue("6789", 6789);
        test_Given_DigitString_Should_GetNaturalNumberValue("38471856919878365", new BigInteger("38471856919878365"));
        test_Given_DigitString_Should_GetNaturalNumberValue("09874407589274", new BigInteger("09874407589274"));
    }

    private void test_Given_DigitString_Should_GetNaturalNumberValue(String digitString, int value) {
        test_Given_DigitString_Should_GetNaturalNumberValue(digitString, BigInteger.valueOf(value));
    }

    private void test_Given_DigitString_Should_GetNaturalNumberValue(String digitString, BigInteger expectedValue) {
        DigitSequence digitSequence = DigitSequenceImpl.fromStringOfDigits(digitString);

        NaturalNumber naturalNumber = NaturalNumber.fromDigitSequence(digitSequence);

        Assert.assertEquals(expectedValue, naturalNumber.getValue());
    }
}
