package org.novokrest.hh2.task2;

import org.novokrest.hh2.core.Verifiers;

import java.util.Iterator;


public class DigitSequenceEx {
    public static boolean startsWith(DigitSequence sourceDigitSequence, DigitSequence targetDigitSequence) {
        return startsWith(sourceDigitSequence, targetDigitSequence, 0);
    }

    public static boolean startsWith(DigitSequence sourceDigitSequence, DigitSequence targetDigitSequence, int fromIndex) {
        int count = Math.min(sourceDigitSequence.length() - fromIndex, targetDigitSequence.length());
        int current = 0;
        while (--count >= 0) {
            if (sourceDigitSequence.digitAt(fromIndex + current) != targetDigitSequence.digitAt(current)) {
                return false;
            }
            ++current;
        }
        return true;
    }

    public static DigitSequence subsequence(DigitSequence digitSequence, int beginIndex) {
        return subsequence(digitSequence, beginIndex, digitSequence.length());
    }

    public static DigitSequence subsequence(DigitSequence digitSequence, int beginIndex, int endIndex) {
        Verifiers.verify(beginIndex >= 0 && beginIndex <= endIndex && endIndex <= digitSequence.length(),
                         "Incorrect bounds: begin=%s, end=%s, length=%s", beginIndex, endIndex, digitSequence.length());
        return new DigitSequenceView(digitSequence, beginIndex, endIndex);
    }

    public static DigitSequence concat(DigitSequence head, DigitSequence tail) {
        return new ConcatenatedDigitSequence(head, tail);
    }

    public static Iterator<Digit> iterator(DigitSequence digitSequence) {
        return new DigitIterator(digitSequence, 0, digitSequence.length());
    }

    public static boolean equals(DigitSequence digitSequence1, DigitSequence digitSequence2) {
        if (digitSequence1.length() != digitSequence2.length()) return false;

        Iterator<Digit> digitIterator1 = iterator(digitSequence1);
        Iterator<Digit> digitIterator2 = iterator(digitSequence2);

        while (digitIterator1.hasNext()) {
            if (digitIterator2.next() != digitIterator2.next()) {
                return false;
            }
        }

        return !digitIterator2.hasNext();
    }
}
