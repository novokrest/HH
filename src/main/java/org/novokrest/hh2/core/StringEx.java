package org.novokrest.hh2.core;


public class StringEx {
    public static String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }
}
