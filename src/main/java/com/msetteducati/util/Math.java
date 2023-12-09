package com.msetteducati.util;

import lombok.experimental.UtilityClass;

/**
 * Reference: <a href="https://www.calculator.net/lcm-calculator.html">Calculator</a>
 */
@UtilityClass
public class Math {

    public static long lcm(long[] input) {
        long result = input[0];
        for(int i = 1; i < input.length; i++) {
            long gcf = gcf(result, input[i]);
            result = (result * input[i]) / gcf;
        }
        return result;
    }

    public static long gcf(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return (gcf(b, a % b));
        }
    }
}
