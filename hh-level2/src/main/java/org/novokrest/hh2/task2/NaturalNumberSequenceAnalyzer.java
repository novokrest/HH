package org.novokrest.hh2.task2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class NaturalNumberSequenceAnalyzer {
    private static final int MAX_NUMBER_LENGTH = 50;
    private static final int ONE_DIGIT_NUMBERS_COUNT = 9;
    private static ArrayList<BigInteger> kDigitNumbersCount = new ArrayList<BigInteger>(MAX_NUMBER_LENGTH);

    private static Map<Integer, BigInteger> totalLengthOfKOrLessDigitNumbers = new HashMap<Integer, BigInteger>(MAX_NUMBER_LENGTH);
    private static int computedTotalLengthOfKOrLessDigitNumbers;

    static {
        kDigitNumbersCount.add(BigInteger.valueOf(ONE_DIGIT_NUMBERS_COUNT));
        totalLengthOfKOrLessDigitNumbers.put(1, BigInteger.valueOf(ONE_DIGIT_NUMBERS_COUNT));
        computedTotalLengthOfKOrLessDigitNumbers = 1;
    }

    public BigInteger getStartIndex(String numberString) {
        int digitCount = numberString.length();
        BigInteger totalLengthOfKOrLessDigitNumbers = getTotalLengthOfKOrLessDigitNumbers(digitCount - 1);
        return totalLengthOfKOrLessDigitNumbers.add(new BigInteger(numberString).subtract(MathEx.powOfTen(digitCount - 1))
                                                                                .multiply(BigInteger.valueOf(digitCount)))
                                               .add(BigInteger.valueOf(1));
    }

    private BigInteger getTotalLengthOfKOrLessDigitNumbers(int k) {
        if (totalLengthOfKOrLessDigitNumbers.containsKey(k)) {
            return totalLengthOfKOrLessDigitNumbers.get(k);
        }

        return computeTotalLengthOfKOrLessDigitNumbers(k);
    }

    private BigInteger computeTotalLengthOfKOrLessDigitNumbers(int k) {
        BigInteger totalLength = BigInteger.valueOf(0);
        for (int i = 1, limit = k + 1; i < limit; i++) {
            totalLength.add(new KDigitNumbers(1).totalLength());
        }
        return totalLength;
    }
}
