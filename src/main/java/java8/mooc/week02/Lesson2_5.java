package java8.mooc.week02;

import java.io.*;
import java.nio.file.*;

/**
 * @author: mpakhomov
 */
public class Lesson2_5 {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader("src/main/java/java8/mooc/week02/Lesson2_5.java"))) {
            br.lines()
                    .skip(10)
                    .limit(3)
                    .forEach(System.out::println);
        }

        System.out.println();

        Files.lines(Paths.get("src/main/java/java8/mooc/week02/Lesson2_5.java"))
                .skip(10)
                .limit(3)
                .forEach(System.out::println);


    }
}
