package java8.mooc.week03;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

/**
 * @author: mpakhomov
 */
public class Lesson2 {

    public static void main(String[] args) throws IOException{
        final List<String> lines = Files.lines(Paths.get("SonnetI.txt"))
                .collect(Collectors.toList());

        recursiveSolution1(lines);
        streamSolution1(lines);
        streamSolution2(lines);

    }

    public static void recursiveSolution1(List<String> lines) {
        System.out.println(findLongestLine("", 0, lines));
    }

    public static void streamSolution1(List<String> lines) {
        System.out.println(lines.stream()
                .reduce((String x, String y) -> {
                    return y.length() > x.length() ? y : x;
                })
                .orElse("")

        );
    }

    public static void streamSolution2(List<String> lines) {
        System.out.println(lines.stream()
            .max(Comparator.comparingInt(String::length))
            .orElse("")

        );
    }

    public static String findLongestLine(String max, int index, List<String> lines) {
        if (index >= lines.size()) {
            return max;
        }

        String curStr = lines.get(index);
        if (curStr.length() > max.length()) {
            max = curStr;
        }
        return findLongestLine(max, index + 1, lines);
    }
}
