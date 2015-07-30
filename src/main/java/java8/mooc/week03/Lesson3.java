package java8.mooc.week03;

import java.util.*;
import java.util.stream.*;

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
        streamFromArray();
    }

    static public void streamFromArray() {
        int[] intArray = new int[] {1, 2, 3, 4};

        System.out.println(Arrays.stream(intArray)
                        .boxed()
                        .map(Object::toString)
                        .collect(Collectors.joining(" "))
        );

        String s1 = new String("abcd");
        String s2 = new String("abcd");
        System.out.println(Integer.toHexString(s1.hashCode()));
        System.out.println(Integer.toHexString(s2.hashCode()));
        Foo foo = new Foo();
        System.out.println(Integer.toHexString(foo.hashCode()));
        System.out.println(foo);
        Object o = s1;
        System.out.println(o.toString());
        System.out.println(Integer.toHexString(o.hashCode()));
        System.out.println(Integer.toHexString(System.identityHashCode(o)));
    }

    public static class Foo {

    }
}
