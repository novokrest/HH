package org.novokrest.hh2.task2;


public class ConcatenatedDigitSequence implements DigitSequence {
    private final DigitSequence head;
    private final DigitSequence tail;

    public ConcatenatedDigitSequence(DigitSequence head, DigitSequence tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public int length() {
        return head.length() + tail.length();
    }

    @Override
    public Digit digitAt(int index) {
        return index < head.length() ? head.digitAt(index) : tail.digitAt(index - head.length());
    }

   @Override
    public String toString() {
       return head.toString() + tail.toString();
   }
}
