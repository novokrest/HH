package org.novokrest.hh2.task2;

import java.math.BigInteger;


class DigitStringFirstOccurrenceFinder {
    private final NaturalNumberSequence naturalNumberSequence = new NaturalNumberSequence();
    private BigInteger firstOccurrence;

    public BigInteger findFirstOccurrence(String digitString) {
        DigitSequence digitSequence = DigitSequenceImpl.fromStringOfDigits(digitString);
        return findFirstOccurrence(digitSequence);
    }

    private BigInteger findFirstOccurrence(DigitSequence digitSequence) {
        firstOccurrence = naturalNumberSequence.indexOf(NaturalNumber.fromDigitSequence(digitSequence));
        for (int firstNumberTailLength = 1, maxLength = digitSequence.length(); firstNumberTailLength < maxLength; firstNumberTailLength++) {
            NaturalNumberSequencePartMatcher sequencePartMatcher = new NaturalNumberSequencePartMatcher(digitSequence, firstNumberTailLength);
            sequencePartMatcher.findMatches();
            if (sequencePartMatcher.hasMatches()) {
                Iterable<NaturalNumberSequencePart> matches = sequencePartMatcher.getMatches();
                for (NaturalNumberSequencePart match: matches) {
                    BigInteger startIndex = computeStartIndex(match);
                    updateFirstOccurrence(startIndex);
                }
            }
        }
        return firstOccurrence;
    }

    private BigInteger computeStartIndex(NaturalNumberSequencePart naturalNumberSequencePart) {
        BigInteger secondNumberIndex = naturalNumberSequence.indexOf(naturalNumberSequencePart.getSecondNumber());
        return secondNumberIndex.subtract(BigInteger.valueOf(naturalNumberSequencePart.getFirstNumberTail().length()));
    }

    private void updateFirstOccurrence(BigInteger foundFirstOccurrence) {
        if (firstOccurrence.compareTo(foundFirstOccurrence) > 0) {
            firstOccurrence = foundFirstOccurrence;
        }
    }
}
