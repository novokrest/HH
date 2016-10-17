package org.novokrest.hh2.task2;

import org.novokrest.hh2.core.Verifiers;


public class Digit {
    private static final int FIRST_DIGIT_VALUE = 0;
    private static final int LAST_DIGIT_VALUE = 9;
    private static final int DIGITS_COUNT = 10;
    private static final char FIRST_DIGIT_CHAR_VALUE = '0';
    private static final Digit[] digits = new Digit[DIGITS_COUNT];

    private static final Digit FIRST_DIGIT;
    private static final Digit LAST_DIGIT;

    static {
        for (int value = FIRST_DIGIT_VALUE; value <= LAST_DIGIT_VALUE; value++) {
            digits[value] = new Digit(value);
        }
        FIRST_DIGIT = getDigitByValue(FIRST_DIGIT_VALUE);
        LAST_DIGIT = getDigitByValue(LAST_DIGIT_VALUE);
    }

    public static Digit fromChar(char value) {
        return valueOf(value - FIRST_DIGIT_CHAR_VALUE);
    }

    public static Digit valueOf(int value) {
        Verifiers.verify(value >= FIRST_DIGIT_VALUE && value <= LAST_DIGIT_VALUE, "Incorrect digit value: %d", value);
        return getDigitByValue(value);
    }

    private static Digit getDigitByValue(int value) {
        return digits[value];
    }

    private final int value;
    private Digit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isOverflowWhenIncremented() {
        return this == LAST_DIGIT;
    }

    public Digit increment() {
        int nextDigitValue = value == LAST_DIGIT_VALUE ? FIRST_DIGIT_VALUE : value + 1;
        return getDigitByValue(nextDigitValue);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
