package org.novokrest.hh2.task2;

import org.novokrest.hh2.core.*;


public class Task2Runner {
    public static void runTask() {
        DigitStringProducer digitStringProducer = new DigitStringProducer(new ConsoleInputReader());
        AnswerConsumer answerConsumer = new AnswerToConsoleWriter();

        Task2 task2 = new Task2(digitStringProducer, answerConsumer);
        task2.run();
    }
}
