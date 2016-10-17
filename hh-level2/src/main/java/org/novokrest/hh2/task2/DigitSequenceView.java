package org.novokrest.hh2.task2;


public class DigitSequenceView implements DigitSequence {
    private final DigitSequence digitSequence;
    private final int beginIndex;
    private final int endIndex;

    public DigitSequenceView(DigitSequence digitSequence, int beginIndex, int endIndex) {
        this.digitSequence = digitSequence;
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
    }

    public int length() {
        return endIndex - beginIndex;
    }

    @Override
    public Digit digitAt(int index) {
        return digitSequence.digitAt(beginIndex + index);
    }

    @Override
    public String toString() {
        return digitSequence.toString().substring(beginIndex, endIndex);
    }
}
