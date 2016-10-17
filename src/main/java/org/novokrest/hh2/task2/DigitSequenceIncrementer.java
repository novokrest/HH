package org.novokrest.hh2.task2;

import org.novokrest.hh2.core.StringEx;

import java.util.ArrayList;


public class DigitSequenceIncrementer {
    private final DigitSequence digitSequence;

    public static DigitSequence increment(DigitSequence digitSequence) {
        return new DigitSequenceIncrementer(digitSequence).increment();
    }

    public DigitSequenceIncrementer(DigitSequence digitSequence) {
        this.digitSequence = digitSequence;
    }

    public DigitSequence increment() {
        int maxResultDigitsCount = digitSequence.length() + 1;
        StringBuilder reversedStringOfDigitsBuilder = new StringBuilder(maxResultDigitsCount);
        ArrayList<Digit> incrementedDigitSequence = new ArrayList<>(maxResultDigitsCount);
        boolean shouldIncrement = true;
        for (int i = digitSequence.length() - 1; i >= 0; i--) {
            Digit resultDigit, digit = digitSequence.digitAt(i);
            if (shouldIncrement) {
                resultDigit = digit.increment();
                shouldIncrement = digit.isOverflowWhenIncremented();
            }
            else {
                resultDigit = digit;
            }
            incrementedDigitSequence.add(resultDigit);
            reversedStringOfDigitsBuilder.append(resultDigit);
        }
        if (shouldIncrement) {
            incrementedDigitSequence.add(Digit.valueOf(1));
            reversedStringOfDigitsBuilder.append(Digit.valueOf(1));
        }

        String resultStringOfDigits = StringEx.reverse(reversedStringOfDigitsBuilder.toString());
        return new DigitSequenceImpl(resultStringOfDigits, incrementedDigitSequence);
    }
}
