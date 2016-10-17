package org.novokrest.hh2.task2;


import java.math.BigInteger;

public class KDigitNumbers {
    private final int k;

    public KDigitNumbers(int k) {
        this.k = k;
    }

    public BigInteger totalLength() {
        return totalCount().multiply(BigInteger.valueOf(k));
    }

    private BigInteger totalCount() {
        return MathEx.powOfTen(k - 1).multiply(BigInteger.valueOf(9));
    }
}
