package org.novokrest.hh2.task2;


import org.novokrest.hh2.core.StringEx;

import java.util.ArrayList;
import java.util.List;


public final class DigitSequenceImpl implements DigitSequence {
    private final String stringOfDigits;
    private final List<Digit> digitsInReverseOrder;


    public static DigitSequence fromStringOfDigits(String stringOfDigits) {
        return new DigitSequenceImpl(stringOfDigits);
    }

    public DigitSequenceImpl(String stringOfDigits, List<Digit> digitsInReverseOrder) {
        this.stringOfDigits = stringOfDigits;
        this.digitsInReverseOrder = digitsInReverseOrder;
    }

    public DigitSequenceImpl(String stringOfDigits) {
        this.stringOfDigits = stringOfDigits;
        this.digitsInReverseOrder = new ArrayList<>(stringOfDigits.length());
        initializeDigits();
    }

    private void initializeDigits() {
        String reversedStringOfDigits = StringEx.reverse(stringOfDigits);
        for (char c: reversedStringOfDigits.toCharArray()) {
            digitsInReverseOrder.add(Digit.fromChar(c));
        }
    }

    @Override
    public int length() {
        return digitsInReverseOrder.size();
    }

    @Override
    public Digit digitAt(int index) {
        return digitsInReverseOrder.get(length() - 1 - index);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (!(object instanceof DigitSequenceImpl)) return false;

        DigitSequenceImpl other = (DigitSequenceImpl) object;

        return this.digitsInReverseOrder.equals(other.digitsInReverseOrder);
    }

    @Override
    public String toString() {
        return stringOfDigits;
    }
}
