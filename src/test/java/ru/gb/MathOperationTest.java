package ru.gb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MathOperationTest {

    /*@ParameterizedTest
    @MethodSource("valuesForSuccessfulSumOperationProvider")
    void shouldSumSuccessfully_whenTwoValidDigitsPassed(double expected, double arg1, double arg2) {
        Assertions.assertEquals(expected, MathOperation.sum(arg1, arg2));
    }

    private static Stream<Arguments> valuesForSuccessfulSumOperationProvider() {
        return Stream.of(
                Arguments.of(3, 1, 2),
                Arguments.of(-4, -2, -2),
                Arguments.of(100, 58, 42)
        );
    }

    @Test
    void testSuccessfulSumCalculation_whenFewValidDigitsPassed() {
        Assertions.assertEquals(6, MathOperation.sum(1, 2, 3));
    }

    @Test
    void shouldDivideSuccessfully_whenTwoValidDigitsPassed() {
        Assertions.assertEquals(3, MathOperation.divide(6, 2));
    }

    @Test
    void shouldThrowArithmeticException_whenSecondArgumentIsZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> MathOperation.divide(6, 0));
    }

    *//**
     * Bad naming convention practice
     *//*
    void getSumValue() {

    }*/
    @ParameterizedTest
    @MethodSource("valuesForSuccessfulSumOperationProvider")
    void shouldSumSuccessfully_whenTwoValidDigitsPassed(double expected, double arg1, double arg2) {
        Assertions.assertEquals(expected, MathOperation.sum(arg1, arg2));
    }

    private static Stream<Arguments> valuesForSuccessfulSumOperationProvider() {
        return Stream.of(
                Arguments.of(3, 1, 2),
                Arguments.of(-4, -2, -2),
                Arguments.of(100, 58, 42)
        );
    }
}
