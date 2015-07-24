/**
 * Copyright © 2014, Oracle and/or its affiliates. All rights reserved.
 * <p>
 * JDK 8 MOOC Lesson 1 homework
 */
package java8.mooc.week01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.*;

/**
 * @author Speakjava (simon.ritter@oracle.com)
 */
public class Lesson1Hw {
    /**
     * Run the exercises to ensure we got the right answers
     */
    public void runExercises() {
        System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 1");
        System.out.println("Running exercise 1 solution...");
        exercise1();
        System.out.println("Running exercise 2 solution...");
        exercise2();
        System.out.println("Running exercise 3 solution...");
        exercise3();
        System.out.println("Running exercise 4 solution...");
        exercise4();
        System.out.println("Running exercise 5 solution...");
        exercise5();
    }

    /**
     * All exercises should be completed using Lambda expressions and the new
     * methods added to JDK 8 where appropriate. There is no need to use an
     * explicit loop in any of the code. Use method references rather than full
     * lambda expressions wherever possible.
     */
    /**
     * Exercise 1
     *
     * Create a string that consists of the first letter of each word in the list
     * of Strings provided.
     */
    private void exercise1() {
        List<String> list = Arrays.asList(
                "alpha", "bravo", "charlie", "delta", "echo", "foxtrot");

        String string = list.stream()
                .map(s -> s.substring(0, 1))
                .reduce(
                        "",
                        (a, b) -> a + b
                );
        System.out.println(string);
    }

    /**
     * Exercise 2
     *
     * Remove the words that have odd lengths from the list.
     */
    private void exercise2() {
        List<String> list = new ArrayList<>(Arrays.asList(
                "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

        list.removeIf(s -> s.length() % 2 != 0);
        System.out.println(list);
    }

    /**
     * Exercise 3
     *
     * Replace every word in the list with its upper case equivalent.
     */
    private void exercise3() {
        List<String> list = new ArrayList<>(Arrays.asList(
                "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

        List<String> upperCaseList = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(upperCaseList);
    }

    /**
     * Exercise 4
     *
     * Convert every key-value pair of the map into a string and append them all
     * into a single string, in iteration order.
     */
    private void exercise4() {
        Map<String, Integer> map = new TreeMap<>();
        map.put("c", 3);
        map.put("b", 2);
        map.put("a", 1);

        String string =map.entrySet().stream()
                .map(entry -> entry.getKey() + entry.getValue())
                .reduce("", String::concat);
        System.out.println(string);
    }

    /**
     * Exercise 5
     *
     * Create a new thread that prints the numbers from the list.
     */
    private void exercise5() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        new Thread( () ->
            list.forEach(System.out::println)
        ).start();
    }

    /**
     * Main entry point for application
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lesson1Hw lesson = new Lesson1Hw();
        lesson.runExercises();
    }
}
