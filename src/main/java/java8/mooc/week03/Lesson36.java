package java8.mooc.week03;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.stream.*;

/**
 * @author: mpakhomov
 */
public class Lesson36 {

    private static final String WORD_REGEXP = "[- .:,]+";

    public static void main(String[] args) throws IOException {
        Lesson36 tester = new Lesson36();

        tester.exercise7();

    }

    /**
     * Modify exercise6 so that the words are sorted by length
     */
    private void exercise7() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {

            System.out.println(
                    reader.lines()
//                            .peek(System.out::println)
                            .flatMap((String l) -> Stream.of(l.split(WORD_REGEXP)))
                            .peek(System.out::println)
                            .map(String::toLowerCase)
                            .distinct()
                            .sorted((l, r) -> l.length() - r.length())
//                      .sorted((l, r) -> Integer.compare(l.length(), r.length()))
                            .collect(Collectors.joining(" ")));
        }
    }
}
