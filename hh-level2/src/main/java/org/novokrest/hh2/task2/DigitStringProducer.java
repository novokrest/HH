package org.novokrest.hh2.task2;

import org.novokrest.hh2.core.InputReader;
import java.util.Iterator;


public class DigitStringProducer {
    private final InputReader inputReader;

    public DigitStringProducer(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public Iterable<String> getDigitStrings() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return createDigitStringIterator();
            }
        };
    }

    private Iterator<String> createDigitStringIterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return inputReader.hasLine();
            }

            @Override
            public String next() {
                return inputReader.readLine();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
