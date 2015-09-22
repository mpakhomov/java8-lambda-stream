package com.mpakhomov;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

/**
 * @author mpakhomov
 * @since 9/22/2015
 */
public class FindMax {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> max = l.stream().reduce((a, b) -> a > b ? a : b);
        System.out.println(max);

        OptionalInt max1 = l.stream().mapToInt(Integer::intValue).max();
        System.out.println(max1);

        max = l.stream().max(Comparator.naturalOrder());
        System.out.println(max);

        max = l.stream().reduce(Integer::max);
        System.out.println(max);

        max = l.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));
        System.out.println(max);

        int maximum = l.stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax();
        System.out.println(maximum);
    }
}
