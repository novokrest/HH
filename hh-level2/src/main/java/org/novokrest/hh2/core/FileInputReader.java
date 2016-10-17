package org.novokrest.hh2.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileInputReader implements InputReader {
    private final Scanner scanner;

    public FileInputReader(String file) {
        try {
            scanner = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

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
