package org.novokrest.hh2.task2;

import java.util.ArrayList;
import java.util.List;


public class DigitSubSequenceOccurrencesFinder {
    private final DigitSequence sourceDigitSequence;

    public DigitSubSequenceOccurrencesFinder(DigitSequence digitSequence) {
        this.sourceDigitSequence = digitSequence;
    }

    public List<Integer> findOccurrences(DigitSequence targetSubSequence) {
        return findOccurrences(targetSubSequence, 0);
    }

    public List<Integer> findOccurrences(DigitSequence targetSubSequence, int fromIndex) {
        List<Integer> foundIndexes = new ArrayList<>();
        for (int i = fromIndex; i < sourceDigitSequence.length(); i++) {
            DigitSequence sourceDigitSubSequence = DigitSequenceEx.subsequence(sourceDigitSequence, i);
            if (DigitSequenceEx.startsWith(sourceDigitSubSequence, targetSubSequence)) {
                foundIndexes.add(i);
            }
        }

        return foundIndexes;
    }
}
