package org.novokrest.hh2.task2;

import java.util.ArrayList;
import java.util.List;


public class NaturalNumberSequencePartMatcher {
    private final DigitSequence digitSequence;
    private final DigitSequence firstNumberTail;
    private final List<NaturalNumberSequencePart> matches = new ArrayList<>();

    public NaturalNumberSequencePartMatcher(DigitSequence digitSequence, int firstNumberTailLength) {
        this.digitSequence = digitSequence;
        this.firstNumberTail = DigitSequenceEx.subsequence(digitSequence, 0, firstNumberTailLength);
    }

    public void findMatches() {
        int secondNumberStartIndex = firstNumberTail.length();
        DigitSequence secondNumberTail = getSecondNumberTail(firstNumberTail);
        DigitSubSequenceOccurrencesFinder finder = new DigitSubSequenceOccurrencesFinder(digitSequence);
        for (Integer secondNumberTailIndex: finder.findOccurrences(secondNumberTail, firstNumberTail.length())) {
            int secondNumberEndIndex = secondNumberTailIndex + secondNumberTail.length();
            DigitSequence secondNumberDigitSequence = DigitSequenceEx.concat(DigitSequenceEx.subsequence(digitSequence, secondNumberStartIndex, secondNumberTailIndex),
                                                                             secondNumberTail);
            NaturalNumber secondNumber = NaturalNumber.fromDigitSequence(secondNumberDigitSequence);
            if (secondNumberEndIndex < digitSequence.length()) {
                DigitSequence digitSequenceRest = DigitSequenceEx.subsequence(digitSequence, secondNumberEndIndex);
                if (checkRestOfDigitSequence(secondNumber, digitSequenceRest)) {
                    matches.add(new NaturalNumberSequencePart(firstNumberTail, secondNumber));
                }
            }
            else {
                matches.add(new NaturalNumberSequencePart(firstNumberTail, secondNumber));
            }
        }
    }

    private DigitSequence getSecondNumberTail(DigitSequence firstNumberTail) {
        DigitSequence incrementedFirstNumberTail = DigitSequenceIncrementer.increment(firstNumberTail);
        if (incrementedFirstNumberTail.length() > firstNumberTail.length()) {
            int start = incrementedFirstNumberTail.length() - firstNumberTail.length();
            return DigitSequenceEx.subsequence(incrementedFirstNumberTail, start);
        }
        return incrementedFirstNumberTail;
    }

    private boolean checkRestOfDigitSequence(NaturalNumber startNumber, DigitSequence followingDigitSequence) {
        NaturalNumberSequenceChecker checker = new NaturalNumberSequenceChecker(startNumber, followingDigitSequence);
        return checker.check();
    }

    public boolean hasMatches() {
        return matches.size() > 0;
    }

    public Iterable<NaturalNumberSequencePart> getMatches() {
        return matches;
    }
}
