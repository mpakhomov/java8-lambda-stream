/**
 * Copyright © 2014, Oracle and/or its affiliates. All rights reserved.
 *
 * JDK 8 MOOC Lesson 2 homework
 */
package java8.mooc.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;

/**
 * @author Speakjava (simon.ritter@oracle.com)
 */
public class Lesson2_Hw {
  private static final String WORD_REGEXP = "[- .:,]+";

  /**
   * Run the exercises to ensure we got the right answers
   *
   * @throws java.io.IOException
   */
  public void runExercises() throws IOException {
    System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 2");
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
    System.out.println("Running exercise 6 solution...");
    exercise6();
    System.out.println("Running exercise 7 solution...");
    exercise7();
  }

  /**
   * Exercise 1
   *
   * Create a new list with all the strings from original list converted to 
   * lower case and print them out.
   */
  private void exercise1() {
    List<String> list = Arrays.asList(
        "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

    /* YOUR CODE HERE */
    System.out.println(
            list.stream()
                    .map(String::toUpperCase)
                    .collect(Collectors.joining(" ")));

  }

  /**
   * Exercise 2
   *
   * Modify exercise 1 so that the new list only contains strings that have an
   * odd length
   */
  private void exercise2() {
    List<String> list = Arrays.asList(
        "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

    /* YOUR CODE HERE */
    System.out.println(
            list.stream()
                    .map(String::toUpperCase)
                    .filter(s -> s.length() % 2 != 0)
                    .collect(Collectors.joining(" ")));
  }

  /**
   * Exercise 3
   *
   * Join the second, third and forth strings of the list into a single string,
   * where each word is separated by a hyphen (-). Print the resulting string.
   */
  private void exercise3() {
    final List<String> list = Arrays.asList(
        "The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

    /* YOUR CODE HERE */
    System.out.println(
        list.stream()
            .filter(s -> list.indexOf(s) == 1 || list.indexOf(s) == 2 || list.indexOf(s) == 3)
            .collect(Collectors.joining("-"))
    );
  }

  /**
   * Count the number of lines in the file using the BufferedReader provided
   */
  private void exercise4() throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(
        Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {
        /* YOUR CODE HERE */
      System.out.println(reader.lines().count());
    }

    System.out.println(Files.lines(Paths.get("SonnetI.txt")).count());
  }
  
  /**
   * Using the BufferedReader to access the file, create a list of words with
   * no duplicates contained in the file.  Print the words.
   * 
   * HINT: A regular expression, WORD_REGEXP, is already defined for your use.
   */
  private void exercise5() throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(
        Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {
      /* YOUR CODE HERE */
      System.out.println(
              reader.lines()
                      .flatMap((String l) -> Stream.of(l.split(WORD_REGEXP)))
                      .map(String::toLowerCase)
                      .distinct()
                      .collect(Collectors.joining(" ")));
    }

    // find duplicates
    Set<String> uniqueWords = new HashSet<>();
    System.out.println(
            Files.lines(Paths.get("SonnetI.txt"))
                    .flatMap((String l) -> Stream.of(l.split(WORD_REGEXP)))
                    .map(String::toLowerCase)
                    .filter(s -> uniqueWords.add(s) == false)
                    .collect(Collectors.joining(" ")));
  }
  
  /**
   * Using the BufferedReader to access the file create a list of words from 
   * the file, converted to lower-case and with duplicates removed, which is
   * sorted by natural order.  Print the contents of the list.
   */
  private void exercise6() throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(
        Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {
         /* YOUR CODE HERE */
        System.out.println(
                reader.lines()
                        .flatMap((String l) -> Stream.of(l.split(WORD_REGEXP)))
                        .map(String::toLowerCase)
                        .distinct()
                        .sorted()
                        .collect(Collectors.joining(" ")));
    }
  }
  
  /**
   * Modify exercise6 so that the words are sorted by length
   */
  private void exercise7() throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(
        Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {

        System.out.println(
              reader.lines()
                      .flatMap((String l) -> Stream.of(l.split(WORD_REGEXP)))
                      .map(String::toLowerCase)
                      .distinct()
                      .sorted((l, r) -> l.length() - r.length())
//                      .sorted((l, r) -> Integer.compare(l.length(), r.length()))
                      .collect(Collectors.joining(" ")));
    }
  }

  /**
   * Main entry point for application
   *
   * @param args the command line arguments
   * @throws IOException If file access does not work
   */
  public static void main(String[] args) throws IOException {
    Lesson2_Hw lesson = new Lesson2_Hw();
    lesson.runExercises();
  }
}

