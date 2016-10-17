package org.novokrest.hh2.task2;

import org.novokrest.hh2.core.AnswerConsumer;

import java.math.BigInteger;


public class Task2 {
    private final DigitStringFirstOccurrenceFinder firstOccurrenceFinder = new DigitStringFirstOccurrenceFinder();
    private final DigitStringProducer digitStringProducer;
    private final AnswerConsumer answerConsumer;

    public Task2(DigitStringProducer digitStringProducer, AnswerConsumer answerConsumer) {
        this.digitStringProducer = digitStringProducer;
        this.answerConsumer = answerConsumer;
    }

    public void run() {
        for (String digitString: digitStringProducer.getDigitStrings()) {
            BigInteger indexOfFirstOccurrence = firstOccurrenceFinder.findFirstOccurrence(digitString);
            answerConsumer.consume(indexOfFirstOccurrence.toString());
        }
    }
}
