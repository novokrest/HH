package org.novokrest.hh2.task2;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;


public class MathEx {
    private static final BigInteger TEN = BigInteger.valueOf(10);
    private static final Map<Integer, BigInteger> powersOfTen;

    static {
        int optimizedCapacity = (int)Math.floor(50 / 0.75) + 1;
        powersOfTen = new HashMap<>(optimizedCapacity);
    }

    public static BigInteger powOfTen(int power) {
        if (alreadyComputed(power)) {
            return getComputedPowerOfTen(power);
        }

        return computePowerOfTen(power);
    }

    private static boolean alreadyComputed(int power) {
        return powersOfTen.containsKey(power);
    }

    private static BigInteger getComputedPowerOfTen(int power) {
        return powersOfTen.get(power);
    }

    private static BigInteger computePowerOfTen(int power) {
        BigInteger powerOfTen = TEN.pow(power);
        powersOfTen.put(power, powerOfTen);

        return powerOfTen;
    }
}
