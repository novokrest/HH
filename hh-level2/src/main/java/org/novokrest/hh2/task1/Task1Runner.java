package org.novokrest.hh2.task1;

import org.novokrest.hh2.core.AnswerConsumer;
import org.novokrest.hh2.core.AnswerToConsoleWriter;
import org.novokrest.hh2.core.ConsoleInputReader;


public class Task1Runner {
    public static void runTask() {
        IslandMapsReader islandMapsReader = new IslandMapsReader(new ConsoleInputReader());
        AnswerConsumer answerConsumer = new AnswerToConsoleWriter();

        Task1 task1 = new Task1(islandMapsReader, answerConsumer);
        task1.run();
    }
}
