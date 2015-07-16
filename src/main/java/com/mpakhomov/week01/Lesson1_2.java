package com.mpakhomov.week01;

import java.util.function.*;

/**
 * @author: mpakhomov
 */
public class Lesson1_2 {

    Function<Integer, String> funcInt2String = (Integer i) -> {
        System.out.println(i);
        if (i == 1_000_000) {
            throw new RuntimeException("Exception from lambda");
        }
        return i.toString();
    };

    public static void main(String[] args) {
        try {
            Lesson1_2 tester = new Lesson1_2();
            tester.funcInt2String.apply(1);
            tester.funcInt2String.apply(1_000_000);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        testFunctionComposeAndThen();

    }

    public static void testFunctionComposeAndThen() {
        Function<Integer, Integer> function = i -> i + 2;
        Function<Integer, Integer> toSquare = i -> i * i;
        // 2 * 2 + 2 + 3 == 9
        int a = function.compose((Integer i) -> i * i).andThen(i -> i + 3).apply(2);

        // 3 * 3 + 2 + 3 == 14
        int b = function.compose((Integer i) -> i * i).andThen(i -> i + 3).apply(3);
        System.out.println(a);
        System.out.println(b);
    }
}
