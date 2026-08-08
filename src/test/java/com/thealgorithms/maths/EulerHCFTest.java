package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Tests for EulerHCF algorithms (recursive, iterative, and long variant)
 */
class EulerHCFTest {

    @Test
    void testEulerHCFRecursive() {
        // common cases
        assertEquals(6, EulerHCF.eulerHCF(54, 24));
        assertEquals(1, EulerHCF.eulerHCF(17, 13));
        // swapped arguments should behave the same
        assertEquals(6, EulerHCF.eulerHCF(24, 54));
        // trivial case
        assertEquals(1, EulerHCF.eulerHCF(1, 1));
    }

    @Test
    void testEulerHCFIterative() {
        assertEquals(6, EulerHCF.eulerHCFIterative(54, 24));
        assertEquals(1, EulerHCF.eulerHCFIterative(17, 13));
        assertEquals(6, EulerHCF.eulerHCFIterative(24, 54));
        assertEquals(1, EulerHCF.eulerHCFIterative(1, 1));
    }

    @Test
    void testEulerHCFLong() {
        // long inputs with a clear gcd
        assertEquals(5_000_000_000L, EulerHCF.eulerHCF(10_000_000_000L, 5_000_000_000L));
        // two large odd numbers expected to be coprime
        assertEquals(1L, EulerHCF.eulerHCF(9_000_000_000_000_001L, 9_000_000_000_000_003L));
    }

    @Test
    void testIllegalInputs() {
        assertAll(
            () -> assertThrows(IllegalArgumentException.class, () -> EulerHCF.eulerHCF(0, 1)),
            () -> assertThrows(IllegalArgumentException.class, () -> EulerHCF.eulerHCF(1, 0)),
            () -> assertThrows(IllegalArgumentException.class, () -> EulerHCF.eulerHCF(0, 0)),
            () -> assertThrows(IllegalArgumentException.class, () -> EulerHCF.eulerHCF(-1, 5)),
            () -> assertThrows(IllegalArgumentException.class, () -> EulerHCF.eulerHCF(5, -1)),
            () -> assertThrows(IllegalArgumentException.class, () -> EulerHCF.eulerHCFIterative(0, 1)),
            () -> assertThrows(IllegalArgumentException.class, () -> EulerHCF.eulerHCFIterative(1, 0)),
            () -> assertThrows(IllegalArgumentException.class, () -> EulerHCF.eulerHCF(0L, 1L)),
            () -> assertThrows(IllegalArgumentException.class, () -> EulerHCF.eulerHCF(1L, 0L))
        );
    }
}
