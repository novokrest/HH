package org.novokrest.hh2.task2;


import java.util.Iterator;

public class DigitIterator implements Iterator<Digit> {
    private final DigitSequence digitSequence;
    private final int stopIndex;
    private int currentIndex;

    public DigitIterator(DigitSequence digitSequence, int startIndex, int stopIndex) {
        this.digitSequence = digitSequence;
        this.currentIndex = startIndex;
        this.stopIndex = stopIndex;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < stopIndex;
    }

    @Override
    public Digit next() {
        return digitSequence.digitAt(currentIndex++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
