package org.novokrest.hh2.task1;


import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Submit {

    public static void main(String[] args) {
        Task1Runner.runTask();
    }

    public interface AnswerConsumer {
        void consume(String answer);
    }

    private static class AnswerToConsoleWriter implements AnswerConsumer {
        @Override
        public void consume(String answer) {
            System.out.println(answer);
            System.out.flush();
        }
    }

    private static class Task1Runner {

        public static void runTask() {
            IslandMapsReader islandMapsReader = new IslandMapsReader();
            AnswerConsumer answerConsumer = new AnswerToConsoleWriter();

            Task1 task1 = new Task1(islandMapsReader, answerConsumer);
            task1.run();
        }
    }


    private static class Task1 {
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


    private static class IslandCell implements Comparable<IslandCell> {
        public final int x;
        public final int y;
        public final int height;

        public IslandCell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }

        @Override
        public int compareTo(IslandCell other) {
            if (this.height < other.height) {
                return -1;
            }
            if (this.height > other.height) {
                return 1;
            }
            return 0;
        }
    }

    private static class IslandMap {
        private static final int[][] CELL_NEIGHBOUR_DIRECTIONS = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

        private final RectangularMatrix<Short> heights;
        private final RectangularMatrix<Boolean> visitedCells;
        private final PriorityQueue<IslandCell> islandCells;

        public IslandMap(RectangularMatrix<Short> heights) {
            this.heights = heights;
            this.visitedCells = new RectangularMatrix<>(heights.getRows(), heights.getColumns());
            this.islandCells = new PriorityQueue<>();
        }

        public int calculateWaterVolumeAfterRain() {
            addBorders();

            int volume = 0;
            while (!islandCells.isEmpty()) {
                IslandCell currentCell = islandCells.poll();
                for (int i = 0; i < CELL_NEIGHBOUR_DIRECTIONS.length; i++) {
                    int neighbourCellX = currentCell.x + CELL_NEIGHBOUR_DIRECTIONS[i][0];
                    int neighbourCellY = currentCell.y + CELL_NEIGHBOUR_DIRECTIONS[i][1];
                    if (neighbourCellX >= 0 && neighbourCellX < heights.getRows()
                            && neighbourCellY >= 0 && neighbourCellY < heights.getColumns()
                            && visitedCells.getValue(neighbourCellX, neighbourCellY) == null) {
                        visitedCells.setValue(neighbourCellX, neighbourCellY, true);
                        IslandCell neighbourCell = new IslandCell(neighbourCellX, neighbourCellY, Math.max(currentCell.height, heights.getValue(neighbourCellX, neighbourCellY)));
                        volume += neighbourCell.height < currentCell.height ? currentCell.height - neighbourCell.height : 0;
                    }
                }
            }

            return volume;
        }

        private void addBorders() {
            addLeftAndRightBorder();
            addTopAndBottomBorder();
        }

        private void addLeftAndRightBorder() {
            int leftColumn = 0;
            int rightColumn = heights.getColumns() - 1;

            for (int r = 0; r < heights.getRows(); r++) {
                islandCells.add(new IslandCell(r, leftColumn, heights.getValue(r, leftColumn)));
                visitedCells.setValue(r, leftColumn, true);
                islandCells.add(new IslandCell(r, rightColumn, heights.getValue(r, rightColumn)));
                visitedCells.setValue(r, rightColumn, true);
            }
        }

        private void addTopAndBottomBorder() {
            int topRow = 0;
            int bottomRow = heights.getRows() - 1;

            for (int c = 1; c < heights.getColumns() - 1; c++) {
                islandCells.add(new IslandCell(topRow, c, heights.getValue(topRow, c)));
                visitedCells.setValue(topRow, c, true);
                islandCells.add(new IslandCell(bottomRow, c, heights.getValue(bottomRow, c)));
                visitedCells.setValue(bottomRow, c, true);
            }
        }
    }

    private static class IslandMapsReader {
        private final Scanner inputScanner = new Scanner(System.in);
        private int islandCount;

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
            RectangularMatrix matrix = readRectangularMatrix();
            return new IslandMap(matrix);
        }

        private RectangularMatrix<Short> readRectangularMatrix() {
            int n = readInt();
            int m = readInt();

            RectangularMatrix<Short> matrix = new RectangularMatrix<>(n, m);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    short value = readShort();
                    matrix.setValue(i, j, value);
                }
            }

            return matrix;
        }

        private int readInt() {
            return inputScanner.nextInt();
        }

        private short readShort() {
            return inputScanner.nextShort();
        }
    }

    private static class RectangularMatrix<T> {
        private final T[] values;
        private final int n;
        private final int m;

        public RectangularMatrix(int n, int m) {
            values = (T[]) new Object[n * m];
            this.n = n;
            this.m = m;
        }

        public int getRows() {
            return n;
        }

        public int getColumns() {
            return m;
        }

        public T getValue(int i, int j) {
            return values[n * i + j];
        }

        public void setValue(int i, int j, T value) {
            values[n * i + j] = value;
        }
    }

}
