package org.novokrest.hh2.task2;


import java.util.*;

public class DigitSequenceAnalyzer {
    private final DigitSequence digits;
    private final Map<Integer, Integer> digitToNextAvailableDigit = new HashMap<Integer, Integer>();
    private final Map<Digit, List<Integer>> digitToIndexesMap = new HashMap<Digit, List<Integer>>();
    //private final Map<Integer, List<Integer>> indexOfDigitToIndexesOfNextDigitMap = new HashMap<Integer, List<Integer>>();

    public static DigitSequenceAnalyzer create(DigitSequence digits) {
        DigitSequenceAnalyzer digitSequenceAnalyzer = new DigitSequenceAnalyzer(digits);
        digitSequenceAnalyzer.analyze();

        return digitSequenceAnalyzer;
    }

    private DigitSequenceAnalyzer(DigitSequence digits) {
        this.digits = digits;
    }

    private void analyze() {
        int index = 0;
        Iterator<Digit> digitIterator = DigitSequenceEx.iterator(digits);
        while (digitIterator.hasNext()) {
            Digit digit = digitIterator.next();
            addAvailableDigit(digit);
            addDigitIndex(digit, index);
            ++index;
        }
    }

    private void addAvailableDigit(Digit digit) {

    }

    private void addDigitIndex(Digit digit, int index) {
        getIndexes(digit).add(index);
    }

    private List<Integer> getIndexes(Digit digit) {
        if (!digitToIndexesMap.containsKey(digit)) {
            List<Integer> indexes = new ArrayList<Integer>();
            digitToIndexesMap.put(digit, indexes);
        }

        return digitToIndexesMap.get(digit);
    }
}
