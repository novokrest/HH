package org.novokrest.hh2.task2;


public class NaturalNumberSequencePart {
    private DigitSequence firstNumberTail;
    private NaturalNumber secondNumber;

    public NaturalNumberSequencePart(DigitSequence firstNumberTail,
                                     NaturalNumber secondNumber) {
        this.firstNumberTail = firstNumberTail;
        this.secondNumber = secondNumber;
    }

    public DigitSequence getFirstNumberTail() {
        return firstNumberTail;
    }

    public NaturalNumber getSecondNumber() {
        return secondNumber;
    }
}
