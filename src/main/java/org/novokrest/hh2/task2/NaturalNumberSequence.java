package org.novokrest.hh2.task2;


import java.math.BigInteger;

public class NaturalNumberSequence {
    private NaturalNumberSequenceAnalyzer analyzer = new NaturalNumberSequenceAnalyzer();

    public BigInteger indexOf(NaturalNumber naturalNumber) {
        String naturalNumberString = naturalNumber.toString();
        return analyzer.getStartIndex(naturalNumberString);
    }
}
