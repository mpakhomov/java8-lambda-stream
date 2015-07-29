package java8.mooc.week03;

import java.util.*;

/**
 * @author: mpakhomov
 */
public class Lesson3 {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.ints()
                .filter(i -> i > 256)
                .findFirst()
                .getAsInt()
        );
    }
}
