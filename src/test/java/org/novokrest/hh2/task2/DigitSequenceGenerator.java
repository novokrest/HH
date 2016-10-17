package org.novokrest.hh2.task2;


import org.novokrest.hh2.core.Verifiers;

import java.util.Random;

public class DigitSequenceGenerator {
    private final Random random = new Random();

    public String generate(int length) {
        StringBuilder digits = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int digitValue = random.nextInt(10);
            Verifiers.verify(digitValue >= 0 && digitValue <= 9, "Incorrect digit value");
            digits.append(digitValue);
        }

        return digits.toString();
    }
}
