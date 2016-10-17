package org.novokrest.hh2.task1;

import org.novokrest.hh2.core.AnswerConsumer;
import java.util.Iterator;


public class Task1 {
    private final IslandMapsReader islandMapsReader;
    private final AnswerConsumer answerConsumer;

    public Task1(IslandMapsReader islandMapsReader, AnswerConsumer answerConsumer) {
        this.islandMapsReader = islandMapsReader;
        this.answerConsumer = answerConsumer;
    }

    public void run() {
        for (IslandMap islandMap: readIslandMaps()) {
            int waterVolume = islandMap.calculateWaterVolumeAfterRain();
            answerConsumer.consume(Integer.toString(waterVolume));
        }
    }

    private Iterable<IslandMap> readIslandMaps() {
        return new Iterable<IslandMap>() {
            @Override
            public Iterator<IslandMap> iterator() {
                return islandMapsReader.read();
            }
        };
    }
}
