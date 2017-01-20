package com.mpakhomov;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class CountChars {

    public static void main(String[] args) {
        String s = args[0];

        Map<Character, Long> result = s.chars()
            .mapToObj(i -> (char)i)
            .collect(
                Collectors.groupingBy(
                    Function.identity(), Collectors.counting()
                )
            );

        result.entrySet().stream()
            .sorted(comparingByValue(Comparator.reverseOrder()))
            .forEach(e -> System.out.println("char: " + e.getKey() + ", count: " + e.getValue()));

        /**
         * scala:
         *
         val s = "venivedivici"

         val res = s
           .map(c => (c, 1))
           .groupBy(_._1)
           .mapValues(_.size)
           .toSeq
           .sortBy(_._2)
           .reverse
         */
    }
}
