package org.novokrest.hh2.core;

import java.util.Scanner;


public class ConsoleInputReader implements InputReader {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int readInt() {
        return scanner.nextInt();
    }

    @Override
    public short readShort() {
        return scanner.nextShort();
    }

    @Override
    public boolean hasLine() {
        return scanner.hasNextLine();
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
