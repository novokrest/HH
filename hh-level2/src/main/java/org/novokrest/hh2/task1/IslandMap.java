package org.novokrest.hh2.task1;


import java.util.PriorityQueue;

public class IslandMap {
    private static final int[][] CELL_NEIGHBOUR_DIRECTIONS = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    private final int rowsCount;
    private final int columnsCount;
    private final short[][] heights;
    private final boolean[][] visitedCells;
    private final PriorityQueue<IslandCell> traversedIslandCells;

    public IslandMap(int n, int m, short[][] heights) {
        this.rowsCount = n;
        this.columnsCount = m;
        this.heights = heights;
        this.visitedCells = new boolean[n][m];
        this.traversedIslandCells = new PriorityQueue<>();
    }

    public int calculateWaterVolumeAfterRain() {
        int volume = 0;

        traverseBorders();
        while (!traversedIslandCells.isEmpty()) {
            IslandCell currentCell = traversedIslandCells.poll();
            for (int i = 0; i < CELL_NEIGHBOUR_DIRECTIONS.length; i++) {
                int neighbourCellX = currentCell.x + CELL_NEIGHBOUR_DIRECTIONS[i][0];
                int neighbourCellY = currentCell.y + CELL_NEIGHBOUR_DIRECTIONS[i][1];
                if (isCellExist(neighbourCellX, neighbourCellY) && !isAlreadyVisited(neighbourCellX, neighbourCellY)) {
                    short initialNeighbourCellHeight = getHeight(neighbourCellX, neighbourCellY);
                    short resultNeighbourCellHeight = (short) Math.max(currentCell.height, initialNeighbourCellHeight);
                    if (initialNeighbourCellHeight < resultNeighbourCellHeight) {
                        volume += resultNeighbourCellHeight - initialNeighbourCellHeight;
                    }
                    IslandCell neighbourCell = new IslandCell(neighbourCellX, neighbourCellY, resultNeighbourCellHeight);
                    traverseCell(neighbourCell);
                }
            }
        }

        return volume;
    }

    private void traverseBorders() {
        traverseLeftAndRightBorder();
        traverseTopAndBottomBorder();
    }

    private void traverseLeftAndRightBorder() {
        int leftColumn = 0;
        int rightColumn = columnsCount - 1;

        for (int r = 0; r < rowsCount; r++) {
            IslandCell leftBorderCell = new IslandCell(r, leftColumn, getHeight(r, leftColumn));
            traverseCell(leftBorderCell);

            IslandCell rightBorderCell = new IslandCell(r, rightColumn, getHeight(r, rightColumn));
            traverseCell(rightBorderCell);
        }
    }

    private void traverseTopAndBottomBorder() {
        int topRow = 0;
        int bottomRow = rowsCount - 1;

        for (int c = 1; c < columnsCount - 1; c++) {
            IslandCell topBorderCell = new IslandCell(topRow, c, getHeight(topRow, c));
            traverseCell(topBorderCell);

            IslandCell bottomBorderCell = new IslandCell(bottomRow, c, getHeight(bottomRow, c));
            traverseCell(bottomBorderCell);
        }
    }

    private void traverseCell(IslandCell cell) {
        traversedIslandCells.offer(cell);
        visitedCells[cell.x][cell.y] = true;
    }

    private boolean isCellExist(int x, int y) {
        return x>=0 && x < rowsCount && y >= 0 && y < columnsCount;
    }

    private boolean isAlreadyVisited(int x, int y) {
        return visitedCells[x][y];
    }

    private short getHeight(int x, int y) {
        return heights[x][y];
    }

    private static class IslandCell implements Comparable<IslandCell> {
        public final int x;
        public final int y;
        public final short height;

        public IslandCell(int x, int y, short height) {
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
}
