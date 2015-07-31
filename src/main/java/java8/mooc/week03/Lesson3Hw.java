/**
 * Copyright © 2014, Oracle and/or its affiliates. All rights reserved.
 * <p>
 * JDK 8 MOOC Lesson 3 homework
 */
package java8.mooc.week03;


import java.io.IOException;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * @author Simon Ritter (@speakjava)
 * @author Stuart Marks
 */
public class Lesson3Hw {
    /* How many times to repeat the test.  5 seems to give reasonable results */
    private static final int RUN_COUNT = 5;

    private static class Pair<T> {
        final T i;
        final T j;
        Pair(T i, T j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "(" + i + "," + j + ")";
        }
    }



    /**
     * Used by the measure method to determine how long a Supplier takes to
     * return a result.
     *
     * @param <T> The type of the result provided by the Supplier
     * @param label Description of what's being measured
     * @param supplier The Supplier to measure execution time of
     * @return
     */
    static <T> T measureOneRun(String label, Supplier<T> supplier) {
        long startTime = System.nanoTime();
        T result = supplier.get();
        long endTime = System.nanoTime();
        System.out.printf("%s took %dms%n",
                label, (endTime - startTime + 500_000L) / 1_000_000L);
        return result;
    }

    /**
     * Repeatedly generate results using a Supplier to eliminate some of the
     * issues of running a micro-benchmark.
     *
     * @param <T> The type of result generated by the Supplier
     * @param label Description of what's being measured
     * @param supplier The Supplier to measure execution time of
     * @return The last execution time of the Supplier code
     */
    static <T> T measure(String label, Supplier<T> supplier) {
        T result = null;

        for (int i = 0; i < RUN_COUNT; i++)
            result = measureOneRun(label, supplier);

        return result;
    }

    /**
     * Computes the Levenshtein distance between every pair of words in the
     * subset, and returns a matrix of distances. This actually computes twice as
     * much as it needs to, since for every word a, b it should be the case that
     * lev(a,b) == lev(b,a) i.e., Levenshtein distance is commutative.
     *
     * @param wordList The subset of words whose distances to compute
     * @param parallel Whether to run in parallel
     * @return Matrix of Levenshtein distances
     */
    static int[][] computeLevenshtein(List<String> wordList, boolean parallel) {
        final int LIST_SIZE = wordList.size();
        int[][] distances = new int[LIST_SIZE][LIST_SIZE];

        // YOUR CODE HERE

       final Map<Pair, Integer> map;
        if (!parallel) {
            IntStream.range(0, wordList.size())
                    .boxed()
                    .flatMap((Integer i) ->
                            IntStream.range(0, wordList.size()).boxed().map(j -> new Pair<Integer>(i, j)))
                    .collect(Collectors.toMap(
                            Function.identity(),
                            p -> Levenshtein.lev(wordList.get(p.i), wordList.get(p.j)))
                    )
                    .entrySet()
                    .stream()
                    .forEach(e -> distances[e.getKey().i][e.getKey().j] = e.getValue());

        } else {
            IntStream.range(0, wordList.size())
                    .boxed()
                    .flatMap((Integer i) ->
                            IntStream.range(0, wordList.size()).boxed().map(j -> new Pair<Integer>(i, j)))
                    .parallel()
                    .collect(Collectors.toMap(
                                    Function.identity(),
                                    p -> Levenshtein.lev(wordList.get(p.i), wordList.get(p.j)))
                    )
                    .entrySet()
                    .stream()
                    .forEach(e -> distances[e.getKey().i][e.getKey().j] = e.getValue());
        }

//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                System.out.print(distances[i][j] + " ");
//            }
//            System.out.println();
//        }
        return distances;
    }

    /**
     * Process a list of random strings and return a modified list
     *
     * @param wordList The subset of words whose distances to compute
     * @param parallel Whether to run in parallel
     * @return The list processed in whatever way you want
     */
    static List<String> processWords(List<String> wordList, boolean parallel) {
        // YOUR CODE HERE
        Stream<String> stream;
        if (!parallel) {
            stream = wordList.stream().sequential();
        } else {
            stream = wordList.parallelStream();
        }
        stream
            .map(String::toLowerCase)
            .map(String::toUpperCase)
//            .distinct()
//            .sorted()
            .filter(s -> s.length() > 4)
            .count();


        return null;
    }

    /**
     * Main entry point for application
     *
     * @param args the command line arguments
     * @throws IOException If word file cannot be read
     */
    public static void main(String[] args) throws IOException {
        RandomWords fullWordList = new RandomWords();
        List<String> wordList = fullWordList.createList(1_000_000);
//        List<String> wordList = fullWordList.createList(2_500);
//        List<String> wordList = fullWordList.createList(1000);

//        measure("Sequential", () -> computeLevenshtein(wordList, false));
//        measure("Parallel", () -> computeLevenshtein(wordList, true));

    measure("Sequential", () -> processWords(wordList, false));
    measure("Parallel", () -> processWords(wordList, true));
    }
}