package org.novokrest.hh2.core;


public class Verifiers {
    public static void verify(boolean b) {
        if (!b) {
            throw new RuntimeException();
        }
    }

    public static void verify(boolean b, String messageFormat, Object... objects) {
        if (!b) {
            throw new RuntimeException(String.format(messageFormat, objects));
        }
    }
}
