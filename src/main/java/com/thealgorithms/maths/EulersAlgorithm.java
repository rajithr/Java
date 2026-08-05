/**
 * EulersAlgorithm.java
 *
 * Implementation of Euler's (Euclid's) algorithm to compute the HCF (GCD)
 * of two integers.
 *
 * Placed in package: com.thealgorithms.maths
 */
package com.thealgorithms.maths;

public final class EulersAlgorithm {

    private EulersAlgorithm() {
        // utility class
    }

    /**
     * Returns the Highest Common Factor (HCF), also known as GCD, of two integers.
     * Uses the iterative Euclidean algorithm. Handles negative inputs and zero.
     *
     * @param a first number
     * @param b second number
     * @return non-negative HCF of |a| and |b|
     */
    public static long hcf(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    /**
     * Simple demonstration. Run with two integer arguments to compute their HCF,
     * or run without arguments to see examples.
     */
    public static void main(String[] args) {
        if (args.length >= 2) {
            try {
                long a = Long.parseLong(args[0]);
                long b = Long.parseLong(args[1]);
                System.out.printf("HCF(%d, %d) = %d%n", a, b, hcf(a, b));
            } catch (NumberFormatException e) {
                System.err.println("Please provide two integer arguments.");
                System.exit(2);
            }
            return;
        }

        // Examples
        long[][] examples = {
            {48, 18},
            {0, 5},
            {17, 13},
            {-24, 36},
            {270, 192}
        };

        for (long[] ex : examples) {
            System.out.printf("HCF(%d, %d) = %d%n", ex[0], ex[1], hcf(ex[0], ex[1]));
        }
    }
}
