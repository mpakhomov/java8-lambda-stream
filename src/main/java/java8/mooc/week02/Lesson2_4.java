package java8.mooc.week02;

import java.util.stream.*;

/**
 * @author: mpakhomov
 */
public class Lesson2_4 {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1, 10);
        intStream.forEach(System.out::print);

        System.out.println();

        intStream = IntStream.range(1, 10);
        intStream.forEachOrdered(System.out::print);

        System.out.println();
        intStream = IntStream.of(1, 2, 3, 4);
        intStream.forEachOrdered(System.out::print);

        System.out.println();
//        java.lang.ClassCastException: java.util.stream.IntPipeline$Head cannot be cast to java.util.stream.Stream
//        Stream.concat((intStream, (Stream)IntStream.of(5, 6, 7, 8, 9))
//                .forEachOrdered(System.out::print);
        IntStream.concat(IntStream.rangeClosed(1, 4), IntStream.of(5, 6, 7, 8, 9))
                .forEachOrdered(System.out::print);

    }
}
