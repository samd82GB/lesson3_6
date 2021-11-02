package ru.gb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayOperationTest {


//Задание 1
//тест на выброс исключения, если в массиве нет цифры 4
    @ParameterizedTest
    @MethodSource ("dataForCheckArrayFor4AndException")
    void shouldThrowRuntimeException_whenNoDigit4(int [] ar) {
        Assertions.assertThrows(RuntimeException.class, () -> ArrayOperation.checkArray(ar));
    }
    private static Stream<Arguments> dataForCheckArrayFor4AndException () {
        List<Arguments> data = new ArrayList<>();
        data.add(Arguments.arguments(new int [] {1,2,3,4,5,6,7,8,9}));//не должно быть исключения
        data.add(Arguments.arguments(new int [] {1,2,3,5,6,7,8,9}));  //должно быть брошено исключение
        return data.stream();
        }

// тест на правильность добавления данных в новый массив после обнаружения 4

    @ParameterizedTest
    @MethodSource ("dataForCheckArrayFor4")
    void shouldCheckFor4Successfully_whenDigit4IsPresent(int [] ar, int [] result) {
        Assertions.assertArrayEquals(result, ArrayOperation.checkArray(ar));
    }
    private static Stream<Arguments> dataForCheckArrayFor4 () {
        List<Arguments> data = new ArrayList<>();
        data.add(Arguments.arguments(new int [] {1,2,3,4,5,6,7,8,9}, new int [] {5,6,7,8,9})); //тест удачный
        data.add(Arguments.arguments(new int [] {1,2,3,5,6,7,4,9}, new int [] {9}));           //тест удачный
        data.add(Arguments.arguments(new int [] {1,2,3,5,4,7,8}, new int [] {7,8,9}));          //тест провален
        return data.stream();
    }

// Задание 2
// тест на правильность проверки массива на наличие только 1 и 4
    @ParameterizedTest
    @MethodSource ("dataForCheckArrayFor1And4")
    void shouldCheckFor1And4Successfully_whenAllAndOnlyThisDigitArePresent(int [] ar, boolean result) {
        Assertions.assertEquals(result, ArrayOperation.checkArrayFor1And4(ar));
}
    private static Stream<Arguments> dataForCheckArrayFor1And4 () {
        List<Arguments> data = new ArrayList<>();
        data.add(Arguments.arguments(new int [] {1,4,4,1,4}, true));        //тест удачный
        data.add(Arguments.arguments(new int [] {1,4,4,1,4}, false));       //тест провален
        data.add(Arguments.arguments(new int [] {1,1,1,1}, false));         //тест удачный
        data.add(Arguments.arguments(new int [] {4,4,4}, false));           //тест удачный
        data.add(Arguments.arguments(new int [] {1,4,4,4,5,1,1,1}, true)); //тест провален
        return data.stream();
    }

    }


