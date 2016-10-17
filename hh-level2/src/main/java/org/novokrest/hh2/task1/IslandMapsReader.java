package org.novokrest.hh2.task1;

import org.novokrest.hh2.core.InputReader;

import java.util.Iterator;


public class IslandMapsReader {
    private final InputReader inputReader;
    private int islandCount;

    public IslandMapsReader(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public Iterator<IslandMap> read() {
        islandCount = readInt();

        return new Iterator<IslandMap>() {

            @Override
            public boolean hasNext() {
                return islandCount > 0;
            }

            @Override
            public IslandMap next() {
                --islandCount;
                return readIslandMap();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private IslandMap readIslandMap() {
        int n = readInt();
        int m = readInt();
        short[][] heights = readHeights(m, n);

        return new IslandMap(n, m, heights);
    }

    private short[][] readHeights(int m, int n) {
        short[][] heights = new short[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                short value = readShort();
                heights[i][j] = value;
            }
        }

        return heights;
    }

    private int readInt() {
        return inputReader.readInt();
    }

    private short readShort() {
        return inputReader.readShort();
    }
}
