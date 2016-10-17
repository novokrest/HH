package org.novokrest.hh2.task2;


class NaturalNumberSequenceChecker {
    private final NaturalNumber startNumber;
    private final DigitSequence followingDigitSequence;

    public NaturalNumberSequenceChecker(NaturalNumber startNumber, DigitSequence followingDigitSequence) {
        this.startNumber = startNumber;
        this.followingDigitSequence = followingDigitSequence;
    }

    public boolean check() {
        int currentIndex = 0;
        NaturalNumber currentNumber = startNumber.increment();
        while (currentIndex < followingDigitSequence.length()) {
            DigitSequence digitSequenceRest = DigitSequenceEx.subsequence(followingDigitSequence, currentIndex);
            if (!DigitSequenceEx.startsWith(digitSequenceRest, currentNumber.getDigitSequence())) {
                return false;
            }
            currentIndex = currentIndex + currentNumber.getDigitSequence().length();
            currentNumber = currentNumber.increment();
        }

        return currentIndex >= followingDigitSequence.length();
    }
}
