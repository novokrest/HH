package org.novokrest.hh2.task1;


public class RectangularMatrix<T> {
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
        return values[m * i + j];
    }

    public void setValue(int i, int j, T value) {
        values[m * i + j] = value;
    }
}
