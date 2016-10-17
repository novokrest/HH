package org.novokrest.hh2.task1;


public class IslandCell implements Comparable<IslandCell> {
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
