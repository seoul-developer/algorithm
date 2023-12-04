package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest
    @CsvSource(value = {"banana,3", "abracadabra,6", "aaabbaccccabba,3"})
    void test(String s, int expected) {
        final Solution solution = new Solution();
        final int actual = solution.solution(s);
        assertEquals(actual, expected);
    }
}
