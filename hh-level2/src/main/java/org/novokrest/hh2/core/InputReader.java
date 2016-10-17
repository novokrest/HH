package org.novokrest.hh2.core;


public interface InputReader {
    int readInt();
    short readShort();

    boolean hasLine();
    String readLine();
}
