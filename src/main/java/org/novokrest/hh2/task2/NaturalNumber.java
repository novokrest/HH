package org.novokrest.hh2.task2;

import org.novokrest.hh2.core.BigIntegerEx;

import java.math.BigInteger;


public class NaturalNumber {
    private final DigitSequence digitSequence;
    private final BigInteger value;

    public static NaturalNumber fromDigitSequence(DigitSequence digitSequence) {
        return fromDigitSequence(digitSequence, 0, digitSequence.length());
    }

    public static NaturalNumber fromDigitSequence(DigitSequence digitSequence, int start, int stop) {
        DigitSequence numberDigitSequence = DigitSequenceEx.subsequence(digitSequence, start, stop);
        BigInteger numberValue = BigInteger.ZERO;
        for (int i = 0; i < numberDigitSequence.length(); i++) {
            Digit digit = numberDigitSequence.digitAt(i);
            numberValue = numberValue.multiply(MathEx.powOfTen(1))
                                     .add(BigInteger.valueOf(digit.getValue()));
        }
        return new NaturalNumber(numberDigitSequence, numberValue);
    }

    private NaturalNumber(DigitSequence digitSequence, BigInteger value) {
        this.digitSequence = digitSequence;
        this.value = value;
    }

    public BigInteger getValue() {
        return value;
    }

    public DigitSequence getDigitSequence() {
        return digitSequence;
    }

    public NaturalNumber increment() {
        return new NaturalNumber(DigitSequenceIncrementer.increment(digitSequence),
                                 BigIntegerEx.increment(value));
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
