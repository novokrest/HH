package org.novokrest.hh2.core;


public class AnswerToConsoleWriter implements AnswerConsumer {
    @Override
    public void consume(String answer) {
        System.out.println(answer);
        System.out.flush();
    }
}
